package com.soundid.catalog.domain.model.album

import spock.lang.Specification
import spock.lang.Unroll

class AlbumIdSpec extends Specification {

    def "should create AlbumId with valid value"() {
        given:
        String validId = "album-xyz"

        when:
        def albumId = new AlbumId(validId)

        then:
        albumId.value() == validId
    }

    @Unroll
    def "should throw exception when ID value is null or blank: '#invalidValue'"() {
        when:
        new AlbumId(invalidValue)

        then:
        thrown IllegalArgumentException

        where:
        invalidValue << [null, "", "   "]
    }
}