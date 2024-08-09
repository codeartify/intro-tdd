package com.codeartify.test_doubles;

public record ConcertVisitor(int id, boolean isEligibleForTicketPurchase) {


    public boolean isEligibleForTicketPurchase() {
        return isEligibleForTicketPurchase;
    }
}
