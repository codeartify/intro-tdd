package com.codeartify.test_doubles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTicketToCartShould {
    /*
     * To be able to buy a ticket to a concert, a concert visitor needs to be able to add a ticket to their cart.
     * If all tickets are sold out, adding a ticket to the cart should fail, and the user should be informed via message that
     * unfortunately, the tickets were just sold out
     * If there are tickets available, a new ticket should be added to the concert visitors cart and stored again.
     * On success, the concert visitor should get informed about the success of adding the ticket to the cart.
     *
     * if(hasAvailableTickets()) {
     *     Cart cart = carts.fetchByConcertVisitorId(concertVisitorId);
     *     Ticket nextTicket = tickets.fetchByConcertId(concertId);
     *     cart.addTicket(nextTicket);
     *     nextTicket.assignedTo(concertVisitorId);
     *     carts.save(cart);
     *     return "Success";
     * }
     * return "No available tickets"
     */

    @Test
    void show_a_message_that_no_tickets_are_available() {
        var addTicketToCartUseCase = new AddTicketToCartUseCase();

        var message = addTicketToCartUseCase.execute(0);

        assertEquals("No available tickets!", message);
    }

    @Test
    void fail_if_the_concert_visitor_does_not_exist() {
        var addTicketToCartUseCase = new AddTicketToCartUseCase();

        var message = addTicketToCartUseCase.execute(1);

        assertEquals("Concert Visitor does not exist", message);
    }
}
