package com.soundid.catalog.domain.model.artist

import spock.lang.Specification
import spock.lang.Unroll

class ArtistSpec extends Specification {
    private static final ArtistId ARTIST_ID = new ArtistId("artist-id")
    private static final String ARTIST_NAME = "Artist Name"

    def "should create Artist with valid data"() {
        when:
        def artist = new Artist(ARTIST_ID, ARTIST_NAME)

        then:
        artist.id() == ARTIST_ID
        artist.name() == ARTIST_NAME
    }

    @Unroll
    def "should throw exception when Artist data is invalid (id: #id, name: '#name')"() {
        when:
        new Artist(id, name)

        then:
        thrown IllegalArgumentException

        where:
        id        | name
        null      | ARTIST_NAME
        ARTIST_ID | null
        ARTIST_ID | ""
        ARTIST_ID | "   "
    }
}