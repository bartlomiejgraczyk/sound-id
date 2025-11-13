package com.soundid.catalog.domain.model.artist

import spock.lang.Specification
import spock.lang.Unroll

class ArtistIdSpec extends Specification {

    def "should create ArtistId correctly with valid value"() {
        given:
        String validId = "artist-123"

        when:
        def artistId = new ArtistId(validId)

        then:
        artistId.value() == validId
    }

    @Unroll
    def "should throw exception when ID value is invalid: '#invalidValue'"() {
        when:
        new ArtistId(invalidValue)

        then:
        thrown IllegalArgumentException

        where:
        invalidValue << [null, "", "   "]
    }
}