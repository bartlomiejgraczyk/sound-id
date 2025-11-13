package com.soundid.catalog.infrastructure.persistence.adapter;

import com.soundid.catalog.domain.repository.FingerprintRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FingerprintRepositoryAdapterConfiguration {
    @Bean
    FingerprintRepository fingerprintRepository() {
        return new FingerprintRepositoryAdapter();
    }
}
