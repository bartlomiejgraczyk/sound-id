package com.soundid.catalog.application.ingestion

import com.soundid.catalog.domain.model.fingerprint.AudioSample
import spock.lang.Specification

class IngestSongUseCaseSpec extends Specification {

    private static final def AUDIO_SAMPLE_BYTES = [0, 1, 2, 3, 4, 5] as byte[]
    private static final def AUDIO_WAV_CONTENT_TYPE = "audio/wav"
    private static final def SONG_TITLE = "Song Title"
    private static final def ARTIST_NAME = "Artist Name"
    private static final def ALBUM_NAME = "Album Name"

    def useCase = new IngestSongUseCase()

    def "should handle song ingestion"() {
        given:
        def audioSample = new AudioSample(AUDIO_SAMPLE_BYTES, AUDIO_WAV_CONTENT_TYPE)
        def command = new IngestSongCommand(SONG_TITLE, ARTIST_NAME, ALBUM_NAME, audioSample)

        when:
        def resultSongId = useCase.handle(command)

        then: "The orchestration steps are executed correctly"
        resultSongId != null
        resultSongId.value() != null
    }
}
