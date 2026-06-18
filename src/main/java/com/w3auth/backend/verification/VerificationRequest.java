package com.w3auth.backend.verification;

import java.util.Objects;

/**
 * The inputs to {@link SignatureVerifier#verify}: the parsed SIWE message
 * (containing the address claim and all other fields) and the raw signature
 * string exactly as received from the client.
 */
public record VerificationRequest(SiweMessage message, String signature) {

    public VerificationRequest {
        Objects.requireNonNull(message, "message must not be null");
        if (signature == null || signature.isBlank()) {
            throw new IllegalArgumentException("signature must not be blank");
        }
    }
}
