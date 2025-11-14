package com.soundid.catalog.domain.model.fingerprint

import groovy.transform.CompileStatic
import groovy.transform.builder.Builder
import groovy.transform.builder.SimpleStrategy

@CompileStatic
@Builder(builderStrategy = SimpleStrategy, prefix = "with")
class AudioSampleBuilder {
    byte[] data = [0, 1, 2, 3, 4, 5] as byte[]
    String contentType = "audio/wav"

    static AudioSampleBuilder anAudioSample() {
        return new AudioSampleBuilder()
    }

    AudioSample build() {
        return new AudioSample(
            data,
            contentType
        )
    }
}
