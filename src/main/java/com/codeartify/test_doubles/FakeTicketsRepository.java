package com.codeartify.test_doubles;

class FakeTicketsRepository implements TicketsRepository {

    private final Ticket ticket;

    public FakeTicketsRepository(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public boolean isSoldOut(int concertId) {
        return ticket == null;
    }

    @Override
    public Ticket fetchTicketByConcertId(int concertId) {
        return ticket;
    }
}
