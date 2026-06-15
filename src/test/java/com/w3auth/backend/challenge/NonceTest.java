package com.w3auth.backend.challenge;

import org.junit.jupiter.api.Test;

import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class NonceTest {

    @Test
    void generatesAtLeast128BitsOfEntropy() {
        String nonce = Nonce.generate();

        byte[] decoded = Base64.getUrlDecoder().decode(nonce);

        assertThat(decoded.length * 8).isGreaterThanOrEqualTo(128);
    }

    @Test
    void generatesUniqueValues() {
        Set<String> nonces = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            nonces.add(Nonce.generate());
        }

        assertThat(nonces).hasSize(1000);
    }
}
