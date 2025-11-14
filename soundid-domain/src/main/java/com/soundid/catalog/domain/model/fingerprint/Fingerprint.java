package com.soundid.catalog.domain.model.fingerprint;

public record Fingerprint(
    long hash,
    int offsetMs
) {
    public Fingerprint {
        if (offsetMs < 0) {
            throw new IllegalArgumentException("Offset milliseconds cannot be negative");
        }
    }
}
