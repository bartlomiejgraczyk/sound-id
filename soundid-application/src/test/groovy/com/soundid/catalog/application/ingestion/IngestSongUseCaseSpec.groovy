package com.soundid.catalog.application.ingestion

import com.soundid.catalog.domain.model.fingerprint.Fingerprint
import com.soundid.catalog.domain.model.song.Song
import com.soundid.catalog.domain.model.song.SongId
import com.soundid.catalog.domain.repository.FingerprintRepository
import com.soundid.catalog.domain.repository.SongRepository
import com.soundid.catalog.domain.service.FingerprintingService
import spock.lang.Specification

import static com.soundid.catalog.application.ingestion.IngestSongCommandBuilder.anIngestSongCommand
import static com.soundid.catalog.domain.model.fingerprint.AudioSampleBuilder.anAudioSample

class IngestSongUseCaseSpec extends Specification {

    private static final def AUDIO_SAMPLE_BYTES = [0, 1, 2, 3, 4, 5] as byte[]
    private static final def AUDIO_WAV_CONTENT_TYPE = "audio/wav"
    private static final def SONG_TITLE = "Song Title"
    private static final def ARTIST_NAME = "Artist Name"
    private static final def ALBUM_NAME = "Album Name"

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
                new Fingerprint(123L, 100),
                new Fingerprint(456L, 200)
        )
        fingerprintingService.generateFingerprints(audioSample) >> generatedFingerprints

        when:
        def resultSongId = handle(anIngestSongCommand()
                .withTitle(SONG_TITLE)
                .withArtist(ARTIST_NAME)
                .withAlbum(ALBUM_NAME)
                .withAudioSample(audioSample)
        )

        then:
        1 * songRepository.save(_ as Song)

        and:
        1 * fingerprintRepository.saveAll(resultSongId, generatedFingerprints)

        and:
        resultSongId != null
        resultSongId.value() != null
    }

    private SongId handle(IngestSongCommandBuilder command) {
        return useCase.handle(command.build())
    }
}
