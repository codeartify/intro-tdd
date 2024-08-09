package com.codeartify.test_doubles;

public class BuyConcertTicketUseCase {

    private final ForVerifyingRegistrationOfConcertVisitor checkRegistration;
    private final ConcertVisitor concertVisitor;
    private final boolean isSoldOut;

    public BuyConcertTicketUseCase(
            ForVerifyingRegistrationOfConcertVisitor forVerifyingRegistrationOfConcertVisitor,
            ConcertVisitor concertVisitor, boolean isSoldOut) {
        this.checkRegistration = forVerifyingRegistrationOfConcertVisitor;
        this.concertVisitor = concertVisitor;
        this.isSoldOut = isSoldOut;
    }

    public Ticket execute(int concertVisitorId, String concertName) {
        if (!checkRegistration.isRegistered(concertVisitorId)) {
            throw new ConcertVisitorNotRegisteredException();
        }

        if(!concertVisitor.isEligibleForTicketPurchase()) {
            throw new ConcertVisitorNotEligibleToPurchaseTicketsException();
        }

        if (isSoldOut) {
            throw new ConcertSoldOutException();
        }

        return new Ticket(1, concertVisitorId, concertName);
    }

}
