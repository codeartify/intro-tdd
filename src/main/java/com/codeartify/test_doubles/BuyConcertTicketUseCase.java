package com.codeartify.test_doubles;

public class BuyConcertTicketUseCase {
    public void execute(int concertVisitorId) {
        if (concertVisitorId <= 0) {
            throw new ConcertVisitorNotRegisteredException();
        }
        throw new ConcertVisitorNotEligibleForTicketPurchasingException();


    }
}
