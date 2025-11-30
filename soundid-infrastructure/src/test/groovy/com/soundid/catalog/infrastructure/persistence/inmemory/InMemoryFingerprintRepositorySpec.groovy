package com.soundid.catalog.infrastructure.persistence.inmemory

import com.soundid.catalog.domain.model.fingerprint.Fingerprint
import com.soundid.catalog.domain.model.song.SongId
import spock.lang.Specification

import static com.soundid.catalog.domain.model.fingerprint.FingerprintBuilder.aFingerprint

class InMemoryFingerprintRepositorySpec extends Specification {
    private static final def SONG_ID_1 = "SONG_ID_1"

    InMemoryFingerprintRepository repository

    def setup() {
        repository = new InMemoryFingerprintRepository()
    }

    def "should save and find a set of fingerprints for a song"() {
        given:
        def savedFingerprints = Set.of(
                new Fingerprint(123L, 100),
                new Fingerprint(456L, 200)
        )

        when:
        saveAll(SONG_ID_1, savedFingerprints)

        and:
        def foundFingerprints = findBySongId(SONG_ID_1)

        then:
        foundFingerprints == savedFingerprints
    }

    def "should return an empty set for an unknown song ID"() {
        when:
        def foundFingerprints = findBySongId(SONG_ID_1)

        then:
        foundFingerprints.isEmpty()
    }

    def "should overwrite fingerprints if saveAll is called again for the same song ID"() {
        given:
        def initialFingerprints = Set.of(aFingerprint().withHash(1L).withOffset(1).build())
        saveAll(SONG_ID_1, initialFingerprints)

        when:
        def newFingerprints = Set.of(
                aFingerprint().withHash(99L).withOffset(9).build(),
                aFingerprint().withHash(88L).withOffset(8).build()
        )
        saveAll(SONG_ID_1, newFingerprints)

        and:
        def foundSet = findBySongId(SONG_ID_1)

        then:
        foundSet == newFingerprints
    }

    private void saveAll(String songId, Set<Fingerprint> fingerprints) {
        repository.saveAll(new SongId(songId), fingerprints)
    }

    private Set<Fingerprint> findBySongId(String songId) {
        return repository.findBySongId(new SongId(songId))
    }
}