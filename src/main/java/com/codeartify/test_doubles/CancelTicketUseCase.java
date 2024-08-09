package com.codeartify.test_doubles;

public class CancelTicketUseCase {
    private ForCheckingConcertVisitorRegistration forCheckingConcertVisitorRegistration;
    private ForFetchingConcertVisitors forFetchingConcertVisitors;
    private ForCheckingCancellationPolicy forCheckingCancellationPolicy;
    private ForStoringConcertVisitors forStoringConcertVisitors;

    public CancelTicketUseCase(ForCheckingConcertVisitorRegistration forCheckingConcertVisitorRegistration, ForFetchingConcertVisitors forFetchingConcertVisitors, ForCheckingCancellationPolicy forCheckingCancellationPolicy, FakeConcertVisitorRepository forStoringConcertVisitors) {
        this.forCheckingConcertVisitorRegistration = forCheckingConcertVisitorRegistration;
        this.forFetchingConcertVisitors = forFetchingConcertVisitors;
        this.forCheckingCancellationPolicy = forCheckingCancellationPolicy;
        this.forStoringConcertVisitors = forStoringConcertVisitors;
    }

    public void invoke(int concertVisitorId, int concertId) {
        if (forCheckingConcertVisitorRegistration.requiresRegistration(concertVisitorId)) {
            throw new ConcertVisitorNotRegisteredException();
        }

        var concertVisitor = forFetchingConcertVisitors.fetchById(concertVisitorId);
        if (!concertVisitor.purchasedTicketForConcert(concertId)) {
            throw new TicketNotPurchasedException();
        }

        if (forCheckingCancellationPolicy.policyForbidsCancellationFor(concertId)) {
            throw new TicketCancellationNotAllowedException();
        }

        concertVisitor.removeTicketFor(concertId);

        forStoringConcertVisitors.store(concertVisitor);

    }

}
