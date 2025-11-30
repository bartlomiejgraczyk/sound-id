package com.soundid.catalog.infrastructure.audio;

import com.soundid.catalog.domain.model.fingerprint.AudioSample;
import com.soundid.catalog.domain.model.fingerprint.Fingerprint;
import com.soundid.catalog.domain.service.FingerprintingService;
import java.util.Arrays;
import java.util.Set;
import org.jspecify.annotations.NonNull;

public class StubFingerprintingService implements FingerprintingService {
    private static final byte[] DUMMY_AUDIO_BYTES = new byte[] { 10, 20, 30, 40, 50 };
    private static final Set<Fingerprint> DUMMY_FINGERPRINTS = Set.of(
        new Fingerprint(123456789L, 150),
        new Fingerprint(987654321L, 450)
    );

    @Override
    public Set<Fingerprint> generateFingerprints(@NonNull AudioSample sample) {
        if (Arrays.equals(sample.data(), DUMMY_AUDIO_BYTES)) {
            return DUMMY_FINGERPRINTS;
        }
        // --- TODO: REAL ALGORITHM ---
        //
        // 1. Decode sample.data() based on sample.contentType()
        // 2. Apply FFT (Fast Fourier Transform) to get frequency data
        // 3. Find peaks (constellation map)
        // 4. Create hashes from pairs/groups of peaks
        // 5. Return the real Set<Fingerprint>
        //
        // --- END OF REAL ALGORITHM ---
        return Set.of();
    }
}
