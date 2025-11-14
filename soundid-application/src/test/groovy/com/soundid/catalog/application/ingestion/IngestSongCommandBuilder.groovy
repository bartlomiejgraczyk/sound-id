package com.soundid.catalog.application.ingestion

import com.soundid.catalog.domain.model.fingerprint.AudioSample
import groovy.transform.CompileStatic
import groovy.transform.builder.Builder
import groovy.transform.builder.SimpleStrategy

@CompileStatic
@Builder(builderStrategy = SimpleStrategy, prefix = "with")
class IngestSongCommandBuilder {
    String title = "Default Song Title"
    AudioSample audioSample = new AudioSample([0, 1, 2, 3, 4, 5] as byte[], "audio/wav")

    static IngestSongCommandBuilder anIngestSongCommand() {
        return new IngestSongCommandBuilder()
    }

    IngestSongCommand build() {
        return new IngestSongCommand(
                title,
                audioSample
        )
    }
}
