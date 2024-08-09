package com.codeartify.test_doubles;

public interface ForCheckingCancellationPolicy {
    boolean canTicketsBeCancelledFor(int concertId);

    default boolean policyForbidsCancellationFor(int concertId) {
        return !canTicketsBeCancelledFor(concertId);
    }
}
