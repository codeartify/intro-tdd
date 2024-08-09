package com.codeartify.test_doubles;

public interface ForCheckingConcertVisitorRegistration {
    boolean isRegistered(int concertVisitorId);

    default boolean requiresRegistration(int concertVisitorId) {
        return !isRegistered(concertVisitorId);
    }
}

