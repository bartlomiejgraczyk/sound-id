package com.soundid.catalog.domain.model.song

import spock.lang.Specification
import spock.lang.Unroll

class SongIdSpec extends Specification {

    def "should create SongId with non-null and non-blank value"() {
        given:
        String validId = "a1b2c3d4-e5f6-a7b8-c9d0-e1f2a3b4c5d6"

        when:
        def songId = new SongId(validId)

        then:
        songId.value() == validId
    }

    def "generate() should return a valid, non-blank ID"() {
        when:
        def songId = SongId.generate()

        then:
        songId != null
        songId.value() != null
        !songId.value().isBlank()
        noExceptionThrown()
    }

    @Unroll
    def "should throw exception when ID value is invalid: '#invalidValue'"() {
        when:
        new SongId(invalidValue)

        then:
        thrown IllegalArgumentException

        where:
        invalidValue << [null, "", "   "]
    }
}
