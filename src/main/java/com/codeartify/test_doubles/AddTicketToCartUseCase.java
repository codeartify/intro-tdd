package com.codeartify.test_doubles;

public class AddTicketToCartUseCase {
    public String execute(int concertVisitorId) {
        if (concertVisitorId == 1) {
            return "Concert Visitor does not exist";
        }
        return "No available tickets!";
    }
}
