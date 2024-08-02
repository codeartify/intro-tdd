package com.codeartify.test_doubles;

public class AddTicketToCartUseCase {
    private ConcertVisitorRepository concertVisitors;

    public AddTicketToCartUseCase(ConcertVisitorRepository concertVisitors) {
        this.concertVisitors = concertVisitors;
    }

    public String execute(int concertVisitorId) {
        if (!concertVisitors.exists(concertVisitorId)) {
            return "Concert Visitor does not exist";
        }
        return "No available tickets!";
    }

}
