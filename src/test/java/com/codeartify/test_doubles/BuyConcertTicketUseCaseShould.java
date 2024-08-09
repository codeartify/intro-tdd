package com.codeartify.test_doubles;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuyConcertTicketUseCaseShould {
    @Test
    void reject_buying_a_ticket_if_the_concert_visitor_is_not_registered() {
        var concertVisitorRepository = new FakeConcertVisitorRepository(null);
        var ticketsRepository = new FakeTicketsRepository(new Ticket(1));

        var buyConcertTicketUseCase = new BuyConcertTicketUseCase(
                concertVisitorRepository,
                concertVisitorRepository,
                concertVisitorRepository,
                ticketsRepository,
                ticketsRepository
        );

        assertThrows(ConcertVisitorNotRegisteredException.class, () -> {
            buyConcertTicketUseCase.executeWith(1, 1);
        });
    }

    @Test
    void reject_buying_a_ticket_if_the_concert_visitor_is_not_eligible_for_buying_tickets() {
        var concertVisitorRepository = new FakeConcertVisitorRepository(new ConcertVisitor(1, false));
        var ticketsRepository = new FakeTicketsRepository(new Ticket(1));

        var buyConcertTicketUseCase = new BuyConcertTicketUseCase(
                concertVisitorRepository,
                concertVisitorRepository,
                concertVisitorRepository, ticketsRepository,
                ticketsRepository
        );

        assertThrows(ConcertVisitorNotEligibleForBuyingTicketsException.class, () -> {
            buyConcertTicketUseCase.executeWith(1, 1);
        });
    }

    @Test
    void reject_ticket_purchase_if_all_tickets_are_sold_out() {

        var concertVisitorRepository = new FakeConcertVisitorRepository(new ConcertVisitor(1, true));
        var ticketsRepository = new FakeTicketsRepository(null);

        var buyConcertTicketUseCase = new BuyConcertTicketUseCase(
                concertVisitorRepository,
                concertVisitorRepository,
                concertVisitorRepository, ticketsRepository,
                ticketsRepository
        );

        assertThrows(ConcertSoldOutException.class, () -> {
            buyConcertTicketUseCase.executeWith(1, 1);
        });
    }

    @Test
    void add_ticket_to_concert_visitor() {
        var concertVisitorRepository = new FakeConcertVisitorRepository(new ConcertVisitor(1, true));
        var ticketsRepository = new FakeTicketsRepository(new Ticket(1));

        var buyConcertTicketUseCase = new BuyConcertTicketUseCase(
                concertVisitorRepository,
                concertVisitorRepository,
                concertVisitorRepository,
                ticketsRepository,
                ticketsRepository
        );

        buyConcertTicketUseCase.executeWith(1, 1);

        var concertVisitor = concertVisitorRepository.fetchById(1);

        assertEquals(List.of(new Ticket(1)), concertVisitor.getTickets());
    }

    @Test
    void show_ticket_details_to_caller() {
        var concertVisitorRepository = new FakeConcertVisitorRepository(new ConcertVisitor(1, true));
        var ticketsRepository = new FakeTicketsRepository(new Ticket(1));

        var buyConcertTicketUseCase = new BuyConcertTicketUseCase(
                concertVisitorRepository,
                concertVisitorRepository,
                concertVisitorRepository,
                ticketsRepository,
                ticketsRepository
        );

        var ticketDetails = buyConcertTicketUseCase.executeWith(1, 1);

        assertEquals(new TicketDetails(1, 1, 1), ticketDetails);
    }

}
