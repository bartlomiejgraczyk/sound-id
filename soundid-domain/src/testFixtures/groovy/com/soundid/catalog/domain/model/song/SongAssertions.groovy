package com.soundid.catalog.domain.model.song

class SongAssertions {
    private Song song

    SongAssertions(Song song) {
        this.song = song
    }

    static SongAssertions assertThat(Song song) {
        return new SongAssertions(song)
    }

    SongAssertions hasId(String expectedId) {
        assert song.id().value() == expectedId
        return this
    }

    SongAssertions hasTitle(String expectedTitle) {
        assert song.title() == expectedTitle
        return this
    }
}
