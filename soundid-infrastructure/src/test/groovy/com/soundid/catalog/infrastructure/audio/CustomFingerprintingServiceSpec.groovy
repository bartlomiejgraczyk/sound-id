package com.soundid.catalog.infrastructure.audio

import com.soundid.catalog.domain.model.fingerprint.Fingerprint
import spock.lang.Specification

import static com.soundid.catalog.domain.model.fingerprint.AudioSampleBuilder.anAudioSample

class CustomFingerprintingServiceSpec extends Specification {

    private static final def DUMMY_AUDIO_BYTES = [10, 20, 30, 40, 50] as byte[]
    private static final def AUDIO_WAV_CONTENT_TYPE = "audio/wav"

    def service = new CustomFingerprintingService()

    def "should return correct fingerprints for a known dummy audio sample"() {
        given:
        def expectedFingerprints = Set.of(
                new Fingerprint(123456789L, 150),
                new Fingerprint(987654321L, 450)
        )

        when:
        def result = service.generateFingerprints(anAudioSample()
                .withData(DUMMY_AUDIO_BYTES)
                .withContentType(AUDIO_WAV_CONTENT_TYPE)
                .build()
        )

        then:
        result == expectedFingerprints
    }

    def "should return an empty set for an unknown audio sample"() {
        when:
        def result = service.generateFingerprints(anAudioSample()
                .withData([9, 8, 7] as byte[])
                .withContentType(AUDIO_WAV_CONTENT_TYPE)
                .build()
        )

        then:
        result.isEmpty()
    }

    def "should always return a non-null set (contract test)"() {
        when:
        def result = service.generateFingerprints(anAudioSample()
                .withData([1, 2, 3] as byte[])
                .withContentType(AUDIO_WAV_CONTENT_TYPE)
                .build()
        )

        then:
        result != null
    }
}