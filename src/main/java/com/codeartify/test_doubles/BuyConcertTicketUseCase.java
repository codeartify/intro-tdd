package com.codeartify.test_doubles;

public class BuyConcertTicketUseCase {

    private final ForCheckingConcertVisitorRegistration forCheckingConcertVisitorRegistration;
    private final ForFetchingConcertVisitors forFetchingConcertVisitors;
    private final ForCheckingTicketAvailability forCheckingTicketAvailability;
    private final ForFetchingTickets forFetchingTickets;
    private final ForStoringConcertVisitors forStoringConcertVisitors;


    public BuyConcertTicketUseCase(
            ForCheckingConcertVisitorRegistration forCheckingConcertVisitorRegistration,
            ForFetchingConcertVisitors forFetchingConcertVisitors,
            ForStoringConcertVisitors forStoringConcertVisitors,
            ForCheckingTicketAvailability forCheckingTicketAvailability,
            ForFetchingTickets forFetchingTickets
    ) {
        this.forCheckingConcertVisitorRegistration = forCheckingConcertVisitorRegistration;
        this.forFetchingConcertVisitors = forFetchingConcertVisitors;
        this.forStoringConcertVisitors = forStoringConcertVisitors;

        this.forCheckingTicketAvailability = forCheckingTicketAvailability;
        this.forFetchingTickets = forFetchingTickets;
    }

    public TicketDetails executeWith(int concertVisitorId, int concertId)
            throws
            ConcertVisitorNotRegisteredException,
            ConcertSoldOutException,
            ConcertVisitorNotEligibleForBuyingTicketsException {

        if (forCheckingConcertVisitorRegistration.requiresRegistration(concertVisitorId)) {
            throw new ConcertVisitorNotRegisteredException();
        }

        if (forCheckingTicketAvailability.isSoldOut(concertId)) {
            throw new ConcertSoldOutException();
        }

        var concertVisitor = forFetchingConcertVisitors.fetchById(concertVisitorId);

        if (concertVisitor.isBannedFromBuyingTickets()) {
            throw new ConcertVisitorNotEligibleForBuyingTicketsException();
        }

        var ticket = forFetchingTickets.fetchTicketByConcertId(concertId);
        concertVisitor.addTicket(ticket);

        forStoringConcertVisitors.store(concertVisitor);

        return new TicketDetails(ticket.ticketNumber(), concertId, concertVisitorId);
    }

}
