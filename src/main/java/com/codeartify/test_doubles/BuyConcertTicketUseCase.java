package com.codeartify.test_doubles;

public class BuyConcertTicketUseCase {

    private final ForVerifyingRegistrationOfConcertVisitor checkRegistration;

    public BuyConcertTicketUseCase(ForVerifyingRegistrationOfConcertVisitor forVerifyingRegistrationOfConcertVisitor) {
        this.checkRegistration = forVerifyingRegistrationOfConcertVisitor;
    }

    public void execute(int concertVisitorId) {
        if (!checkRegistration.isRegistered(concertVisitorId)) {
            throw new ConcertVisitorNotRegisteredException();
        }

        throw new ConcertVisitorNotEligibleForTicketPurchasingException();


    }

}
