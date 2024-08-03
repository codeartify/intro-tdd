package com.codeartify.test_doubles;

public class ConcertVisitorRepository implements ForVerifyingRegistrationOfConcertVisitor {
    @Override
    public boolean isRegistered(int concertVisitorId) {
        return concertVisitorId > 0;
    }
}
