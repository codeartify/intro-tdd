package com.codeartify.test_doubles;

public class AddTicketToCartUseCase {
    private final ConcertVisitorRepository concertVisitors;

    public AddTicketToCartUseCase(ConcertVisitorRepository concertVisitors) {
        this.concertVisitors = concertVisitors;
    }

    public String execute(int concertVisitorId, String myConcert) {
        if (!concertVisitors.exists(concertVisitorId)) {
            return "Concert Visitor does not exist";
        }
        return null;
    }

}
