package com.codeartify.test_doubles;

class FakeConcertVisitorRepository implements ConcertVisitorRepository {

    private ConcertVisitor concertVisitor;

    FakeConcertVisitorRepository(ConcertVisitor concertVisitor) {
        this.concertVisitor = concertVisitor;
    }

    @Override
    public ConcertVisitor fetchById(int concertVisitorId) {
        return this.concertVisitor;
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
