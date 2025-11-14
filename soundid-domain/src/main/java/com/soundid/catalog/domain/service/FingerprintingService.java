package com.soundid.catalog.domain.service;

import com.soundid.catalog.domain.model.fingerprint.AudioSample;
import com.soundid.catalog.domain.model.fingerprint.Fingerprint;
import java.util.Set;
import org.jspecify.annotations.NonNull;

public interface FingerprintingService {

    Set<Fingerprint> generateFingerprints(@NonNull AudioSample sample);
}