package com.soundid.catalog.domain.model.album

import com.soundid.catalog.domain.model.artist.ArtistId
import spock.lang.Specification
import spock.lang.Unroll

class AlbumSpec extends Specification {
    private static final AlbumId ALBUM_ID = new AlbumId("album-id")
    private static final String ALBUM_NAME = "Album Name"
    private static final ArtistId ARTIST_ID = new ArtistId("artist-id")

    def "should create Album with valid data"() {
        when:
        def album = new Album(ALBUM_ID, ALBUM_NAME, ARTIST_ID)

        then:
        album.id() == ALBUM_ID
        album.name() == ALBUM_NAME
        album.artistId() == ARTIST_ID
    }

    @Unroll
    def "should throw exception when #scenario"() {
        when:
        new Album(id, name, artistId)

        then:
        thrown IllegalArgumentException

        where:
        scenario              | id       | name       | artistId
        "id is null"         | null     | ALBUM_NAME | ARTIST_ID
        "name is null"       | ALBUM_ID | null       | ARTIST_ID
        "name is empty"      | ALBUM_ID | ""         | ARTIST_ID
        "name is blank"      | ALBUM_ID | "   "      | ARTIST_ID
        "artistId is null"   | ALBUM_ID | ALBUM_NAME | null
    }
}