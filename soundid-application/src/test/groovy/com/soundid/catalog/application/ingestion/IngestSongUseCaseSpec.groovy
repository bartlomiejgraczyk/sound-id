package com.soundid.catalog.application.ingestion

import com.soundid.catalog.domain.model.song.Song
import com.soundid.catalog.domain.model.song.SongId
import com.soundid.catalog.domain.repository.FingerprintRepository
import com.soundid.catalog.domain.repository.SongRepository
import com.soundid.catalog.domain.service.FingerprintingService
import spock.lang.Specification

import static com.soundid.catalog.application.ingestion.IngestSongCommandBuilder.anIngestSongCommand
import static com.soundid.catalog.domain.model.fingerprint.AudioSampleBuilder.anAudioSample
import static com.soundid.catalog.domain.model.fingerprint.FingerprintBuilder.aFingerprint

class IngestSongUseCaseSpec extends Specification {

    private static final def AUDIO_SAMPLE_BYTES = [0, 1, 2, 3, 4, 5] as byte[]
    private static final def AUDIO_WAV_CONTENT_TYPE = "audio/wav"
    private static final def SONG_TITLE = "Song Title"

    def songRepository = Mock(SongRepository)
    def fingerprintRepository = Mock(FingerprintRepository)
    def fingerprintingService = Mock(FingerprintingService)

    def useCase = new IngestSongUseCase(
            songRepository,
            fingerprintRepository,
            fingerprintingService
    )

    def "should orchestrate song ingestion"() {
        given:
        def audioSample = anAudioSample()
                .withData(AUDIO_SAMPLE_BYTES)
                .withContentType(AUDIO_WAV_CONTENT_TYPE)
                .build()
        def generatedFingerprints = Set.of(
                aFingerprint().withHash(123L).withOffset(100).build(),
                aFingerprint().withHash(456L).withOffset(200).build()
        )
        fingerprintingService.generateFingerprints(audioSample) >> generatedFingerprints

        Song savedSong = null

        when:
        def resultSongId = handle(anIngestSongCommand()
                .withTitle(SONG_TITLE)
                .withAudioSample(audioSample)
        )

        then:
        1 * songRepository.save(_ as Song) >> { Song song ->
            savedSong = song
        }
        1 * fingerprintRepository.saveAll(_, generatedFingerprints) >> { SongId songId, _ ->
            assert songId == savedSong.id()
        }

        and:
        resultSongId == savedSong.id()
    }

    def "should reject command with invalid title: #scenario"() {
        given:
        def audioSample = anAudioSample()
                .withData(AUDIO_SAMPLE_BYTES)
                .withContentType(AUDIO_WAV_CONTENT_TYPE)
                .build()

        when:
        handle(anIngestSongCommand()
                .withTitle(title)
                .withAudioSample(audioSample)
        )

        then:
        thrown IllegalArgumentException

        where:
        scenario      | title
        "null title"  | null
        "empty title" | ""
        "blank title" | "   "
    }

    def "should reject command with null audio sample"() {
        when:
        handle(anIngestSongCommand()
                .withTitle(SONG_TITLE)
                .withAudioSample(null)
        )

        then:
        thrown IllegalArgumentException
    }

    private SongId handle(IngestSongCommandBuilder command) {
        return useCase.handle(command.build())
    }
}
