package com.soundid.catalog.infrastructure.audio;

import com.soundid.catalog.domain.service.FingerprintingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FingerprintingAdapterConfiguration {
    @Bean
    FingerprintingService fingerprintingService() {
        return new CustomFingerprintingService();
    }
}
