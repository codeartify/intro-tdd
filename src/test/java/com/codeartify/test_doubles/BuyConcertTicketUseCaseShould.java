package com.codeartify.test_doubles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuyConcertTicketUseCaseShould {
    @Test
    void reject_buying_a_ticket_if_the_concert_visitor_is_not_registered() {
        var buyConcertTicketUseCase = new BuyConcertTicketUseCase((id) -> false);

        assertThrows(ConcertVisitorNotRegisteredException.class, () -> {
            buyConcertTicketUseCase.execute(0);
        });
    }

    @Test
    void reject_buying_a_ticket_if_the_concert_visitor_is_not_eligible_to_buy_tickets() {
        var buyConcertTicketUseCase = new BuyConcertTicketUseCase((id) -> true);

        assertThrows(ConcertVisitorNotEligibleForTicketPurchasingException.class, () -> {
            buyConcertTicketUseCase.execute(1);
        });
    }

    void reject_buying_a_ticket_if_there_are_not_tickets_available_for_the_requested_concert() {

    }

    void assign_a_ticket_to_a_an_existing_eligible_concert_visitor() {

    }

    void allow_a_concert_visitor_to_buy_multiple_concert_tickets_for_the_same_concert() {

    }

    void limit_the_number_of_concert_tickets_for_the_same_concert_per_concert_visitor_to_the_specified_number_provided_by_the_concert_provider() {

    }
}
