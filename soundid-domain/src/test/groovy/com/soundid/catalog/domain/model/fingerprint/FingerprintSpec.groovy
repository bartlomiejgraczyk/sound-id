package com.soundid.catalog.domain.model.fingerprint

import spock.lang.Specification

class FingerprintSpec extends Specification {
    private static final Long FINGERPRINT_HASH = 12345L

    def "should create Fingerprint with valid values"() {
        when:
        def fingerprint = new Fingerprint(FINGERPRINT_HASH, 500)

        then:
        fingerprint.hash() == FINGERPRINT_HASH
        fingerprint.offsetMs() == 500
    }

    def "should allow zero as a valid offset"() {
        when:
        def fingerprint = new Fingerprint(FINGERPRINT_HASH, 0)

        then:
        fingerprint.offsetMs() == 0
    }

    def "should throw exception when offset is negative"() {
        when:
        new Fingerprint(FINGERPRINT_HASH, -1)

        then:
        thrown IllegalArgumentException
    }
}
