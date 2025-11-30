package com.soundid.catalog.infrastructure.persistence.inmemory;

import com.soundid.catalog.domain.repository.FingerprintRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FingerprintRepositoryConfiguration {
    @Bean
    public FingerprintRepository fingerprintRepository() {
        return new InMemoryFingerprintRepository();
    }
}
