package com.codeartify.exercise7;

import java.util.Optional;

public class CancelTicketUseCase {
    private FetchConcertVisitor fetchConcertVisitor;

    public CancelTicketUseCase(FetchConcertVisitor fetchConcertVisitor) {
        this.fetchConcertVisitor = fetchConcertVisitor;
    }

    public void invoke(int concertVisitorId, int concertId) {
        Optional<ConcertVisitor> visitor = fetchConcertVisitor.fetchById(concertVisitorId);
        if (visitor.isEmpty()) {
            throw new ConcertVisitorNotRegisteredException();
        }
    }
}
