package com.soundid.catalog.domain.model.fingerprint

import groovy.transform.CompileStatic
import groovy.transform.builder.Builder
import groovy.transform.builder.SimpleStrategy

@CompileStatic
@Builder(builderStrategy = SimpleStrategy, prefix = "with")
class FingerprintBuilder {
    long hash = 123L
    int offset = 100

    static FingerprintBuilder aFingerprint() {
        return new FingerprintBuilder()
    }

    Fingerprint build() {
        return new Fingerprint(
            hash,
            offset
        )
    }
}
