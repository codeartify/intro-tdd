package com.codeartify.test_doubles;

public class BuyConcertTicketUseCase {

    private final ForVerifyingRegistrationOfConcertVisitor checkRegistration;
    private final ConcertVisitor concertVisitor;

    public BuyConcertTicketUseCase(
            ForVerifyingRegistrationOfConcertVisitor forVerifyingRegistrationOfConcertVisitor,
            ConcertVisitor concertVisitor) {
        this.checkRegistration = forVerifyingRegistrationOfConcertVisitor;
        this.concertVisitor = concertVisitor;
    }

    public void execute(int concertVisitorId) {
        if (!checkRegistration.isRegistered(concertVisitorId)) {
            throw new ConcertVisitorNotRegisteredException();
        }

        if(!concertVisitor.isEligibleForTicketPurchase()) {
            throw new ConcertVisitorNotEligibleToPurchaseTicketsException();
        }

        throw new ConcertSoldOutException();

    }

}
