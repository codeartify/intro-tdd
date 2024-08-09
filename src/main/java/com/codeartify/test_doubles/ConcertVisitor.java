package com.codeartify.test_doubles;

import java.util.Objects;

public final class ConcertVisitor {
    private final int id;
    private final boolean isEligibleForTicketPurchase;
    private Ticket ticket;

    public ConcertVisitor(int id, boolean isEligibleForTicketPurchase) {
        this.id = id;
        this.isEligibleForTicketPurchase = isEligibleForTicketPurchase;
    }


    public boolean isEligibleForTicketPurchase() {
        return isEligibleForTicketPurchase;
    }

    public Ticket ticket() {
        return ticket;
    }

    public int id() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ConcertVisitor) obj;
        return this.id == that.id &&
                this.isEligibleForTicketPurchase == that.isEligibleForTicketPurchase &&
                Objects.equals(this.ticket, that.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isEligibleForTicketPurchase, ticket);
    }

    @Override
    public String toString() {
        return "ConcertVisitor[" +
                "id=" + id + ", " +
                "isEligibleForTicketPurchase=" + isEligibleForTicketPurchase + ", " +
                "ticket=" + ticket + ']';
    }

    public void addTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
