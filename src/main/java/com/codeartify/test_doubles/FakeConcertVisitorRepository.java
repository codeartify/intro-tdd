package com.codeartify.test_doubles;

public class FakeConcertVisitorRepository implements ConcertVisitorRepository {

    private ConcertVisitor concertVisitor;

    FakeConcertVisitorRepository(ConcertVisitor concertVisitor) {
        this.concertVisitor = concertVisitor;
    }

    @Override
    public ConcertVisitor fetchById(int concertVisitorId) {
        var copy = new ConcertVisitor(this.concertVisitor.getId(), this.concertVisitor.isEligibleForBuyingConcertTickets());
        concertVisitor.getTickets().forEach(copy::addTicket);
        return copy;
    }

    @Override
    public void store(ConcertVisitor concertVisitor) {
        this.concertVisitor = concertVisitor;
    }

    @Override
    public boolean isRegistered(int concertVisitorId) {
        return concertVisitor != null;
    }
}
