package com.codeartify.test_doubles;

import java.util.ArrayList;
import java.util.List;

public class ConcertVisitor {
    private final int concertVisitorId;
    private final boolean isEligibleForBuyingConcertTickets;
    private List<Ticket> tickets = new ArrayList<>();

    public ConcertVisitor(int concertVisitorId, boolean isEligibleForBuyingConcertTickets) {
        this.concertVisitorId = concertVisitorId;
        this.isEligibleForBuyingConcertTickets = isEligibleForBuyingConcertTickets;
    }

    public boolean isEligibleForBuyingConcertTickets() {
        return isEligibleForBuyingConcertTickets;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    boolean isBannedFromBuyingTickets() {
        return !isEligibleForBuyingConcertTickets();
    }

    public boolean purchasedTicketForConcert(int concertId) {
        return tickets.stream()
                .anyMatch(ticket -> ticket.concertId() == concertId);
    }

    public void removeTicketFor(int concertId) {
        this.tickets = new ArrayList<>(tickets.stream().filter(ticket -> ticket.concertId() != concertId).toList());
    }

    public int getId() {
        return concertVisitorId;
    }

}
