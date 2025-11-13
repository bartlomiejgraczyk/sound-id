package com.soundid.catalog.domain.model.song

import com.soundid.catalog.domain.model.album.AlbumId
import com.soundid.catalog.domain.model.artist.ArtistId
import spock.lang.Specification
import spock.lang.Unroll

class SongSpec extends Specification {
    private static final SongId SONG_ID = new SongId("song-id")
    private static final String SONG_TITLE = "Song Title"
    private static final ArtistId ARTIST_ID = new ArtistId("artist-id")
    private static final AlbumId ALBUM_ID = new AlbumId("album-id")

    def "should create Song correctly with valid data"() {
        when:
        def song = new Song(SONG_ID, SONG_TITLE, ARTIST_ID, ALBUM_ID)

        then:
        song.id() == SONG_ID
        song.title() == SONG_TITLE
        song.artistId() == ARTIST_ID
        song.albumId() == ALBUM_ID
    }

    @Unroll
    def "should throw exception when #scenario"() {
        when:
        new Song(id, title, artistId, albumId)

        then:
        thrown IllegalArgumentException

        where:
        scenario                 | id      | title      | artistId  | albumId
        "id is null"            | null    | SONG_TITLE | ARTIST_ID | ALBUM_ID
        "title is null"         | SONG_ID | null       | ARTIST_ID | ALBUM_ID
        "title is empty"        | SONG_ID | ""         | ARTIST_ID | ALBUM_ID
        "title is blank"        | SONG_ID | "   "      | ARTIST_ID | ALBUM_ID
        "artistId is null"      | SONG_ID | SONG_TITLE | null      | ALBUM_ID
        "albumId is null"       | SONG_ID | SONG_TITLE | ARTIST_ID | null
    }
}