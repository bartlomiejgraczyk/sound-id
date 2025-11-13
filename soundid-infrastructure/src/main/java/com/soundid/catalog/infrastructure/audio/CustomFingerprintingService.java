package com.soundid.catalog.infrastructure.audio;

import com.soundid.catalog.domain.model.fingerprint.AudioSample;
import com.soundid.catalog.domain.model.fingerprint.Fingerprint;
import com.soundid.catalog.domain.service.FingerprintingService;
import java.util.Set;
import org.jspecify.annotations.NonNull;

public class CustomFingerprintingService implements FingerprintingService {
    @Override
    public Set<Fingerprint> generateFingerprints(@NonNull AudioSample sample) {
        return Set.of();
    }
}
