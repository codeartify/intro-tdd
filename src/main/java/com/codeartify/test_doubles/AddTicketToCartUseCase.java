package com.codeartify.test_doubles;

public class AddTicketToCartUseCase {
    private final ConcertVisitorRepository concertVisitors;
    private final TicketsRepository tickets;

    public AddTicketToCartUseCase(ConcertVisitorRepository concertVisitors, TicketsRepository tickets) {
        this.concertVisitors = concertVisitors;
        this.tickets = tickets;
    }

    public String execute(int concertVisitorId, String concertName) {
        if (!concertVisitors.exists(concertVisitorId)) {
            return "Concert Visitor does not exist";
        }
        if (!tickets.availableFor(concertName)) {
            return "No available tickets for " + concertName;
        }
        return null;
    }

}
