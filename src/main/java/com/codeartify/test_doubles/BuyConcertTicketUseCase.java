package com.codeartify.test_doubles;

public class BuyConcertTicketUseCase {

    private final ForVerifyingRegistrationOfConcertVisitor checkRegistration;
    private final ConcertVisitor concertVisitor;
    private final ForCheckingTicketSales forCheckingTicketSales;

    public BuyConcertTicketUseCase(
            ForVerifyingRegistrationOfConcertVisitor forVerifyingRegistrationOfConcertVisitor,
            ConcertVisitor concertVisitor,
            ForCheckingTicketSales forCheckingTicketSales) {

        this.checkRegistration = forVerifyingRegistrationOfConcertVisitor;
        this.concertVisitor = concertVisitor;
        this.forCheckingTicketSales = forCheckingTicketSales;
    }

    public TicketDetails execute(int concertVisitorId, String concertName) {
        if (!checkRegistration.isRegistered(concertVisitorId)) {
            throw new ConcertVisitorNotRegisteredException();
        }

        if(!concertVisitor.isEligibleForTicketPurchase()) {
            throw new ConcertVisitorNotEligibleToPurchaseTicketsException();
        }

        if (forCheckingTicketSales.isSoldOut(concertName)) {
            throw new ConcertSoldOutException();
        }

        var ticket = new Ticket(1, concertName);
        concertVisitor.addTicket(ticket);

        return new TicketDetails(ticket.ticketNumber(), concertVisitor.id(), ticket.concertName());
    }

}
