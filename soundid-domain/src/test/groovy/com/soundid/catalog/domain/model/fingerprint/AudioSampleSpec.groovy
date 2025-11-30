package com.soundid.catalog.domain.model.fingerprint

import spock.lang.Specification
import spock.lang.Unroll

class AudioSampleSpec extends Specification {
    private static final def AUDIO_WAV_CONTENT_TYPE = "audio/wav"

    def "should create AudioSample with non-empty data and not-blank content type"() {
        given:
        byte[] data = [1, 2, 3]

        when:
        def sample = new AudioSample(data, AUDIO_WAV_CONTENT_TYPE)

        then:
        sample.data() == data
        sample.contentType() == AUDIO_WAV_CONTENT_TYPE
    }

    @Unroll
    def "should throw exception when #scenario"() {
        when:
        new AudioSample(data, contentType)

        then:
        thrown IllegalArgumentException

        where:
        scenario                    | data             | contentType
        "data is null"             | null             | AUDIO_WAV_CONTENT_TYPE
        "data is empty"            | new byte[0]      | AUDIO_WAV_CONTENT_TYPE
        "contentType is null"      | [1, 2] as byte[] | null
        "contentType is empty"     | [1, 2] as byte[] | ""
        "contentType is blank"     | [1, 2] as byte[] | "   "
    }

    def "should not allow for modifications through data passed as constructor's argument"() {
        given:
        byte[] originalData = [10, 20, 30]

        when:
        def sample = new AudioSample(originalData, AUDIO_WAV_CONTENT_TYPE)

        and:
        originalData[0] = 99

        then:
        sample.data() == [10, 20, 30] as byte[]
    }

    def "should not allow for modifications through data returned by getter"() {
        given:
        def sample = new AudioSample([10, 20, 30] as byte[], AUDIO_WAV_CONTENT_TYPE)

        when:
        byte[] retrievedData = sample.data()

        and:
        retrievedData[0] = 99

        then:
        sample.data() == [10, 20, 30] as byte[]
    }
}
