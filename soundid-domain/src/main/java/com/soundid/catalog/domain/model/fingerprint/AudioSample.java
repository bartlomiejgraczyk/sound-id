package com.soundid.catalog.domain.model.fingerprint;

import java.util.Arrays;
import java.util.Objects;
import org.jspecify.annotations.NonNull;

public final class AudioSample {

    private final byte[] data;
    private final String contentType;

    public AudioSample(byte[] data, @NonNull String contentType) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Audio data cannot be empty");
        }
        if (contentType == null || contentType.isBlank()) {
            throw new IllegalArgumentException("Content type cannot be blank");
        }
        this.data = Arrays.copyOf(data, data.length);
        this.contentType = contentType;
    }

    public byte @NonNull [] data() {
        return Arrays.copyOf(data, data.length);
    }

    public @NonNull String contentType() {
        return contentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AudioSample that = (AudioSample) o;
        return Arrays.equals(data, that.data) && contentType.equals(that.contentType);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(contentType);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "AudioSample[contentType=" + contentType + ", dataSize=" + data.length + " bytes]";
    }
}
