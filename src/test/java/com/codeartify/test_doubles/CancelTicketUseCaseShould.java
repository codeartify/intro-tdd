package com.codeartify.test_doubles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CancelTicketUseCaseShould {

    @Test
    void reject_cancellation_if_concert_visitor_is_not_registered() {
        var cancelTicketUseCase = new CancelTicketUseCase(
                new FakeConcertVisitorRepository(null), null, null, new FakeConcertVisitorRepository(null)
        );

        assertThrows(ConcertVisitorNotRegisteredException.class, () -> cancelTicketUseCase.invoke(1, 1));
    }

    @Test
    void reject_cancellation_if_concert_visitor_has_not_purchased_a_ticket() {
        var concertVisitor = new ConcertVisitor(1, true);
        var concertVisitorRepository = new FakeConcertVisitorRepository(concertVisitor);

        var cancelTicketUseCase = new CancelTicketUseCase(
                concertVisitorRepository,
                concertVisitorRepository,
                (id) -> true, new FakeConcertVisitorRepository(null)
        );

        assertThrows(TicketNotPurchasedException.class, () -> cancelTicketUseCase.invoke(1, 1));
    }

    @Test
    void reject_cancellation_if_ticket_purchase_cannot_be_cancelled() {
        var concertVisitor = new ConcertVisitor(1, true);
        concertVisitor.addTicket(new Ticket(1, 1));
        var concertVisitorRepository = new FakeConcertVisitorRepository(concertVisitor);

        var cancelTicketUseCase = new CancelTicketUseCase(
                concertVisitorRepository,
                concertVisitorRepository,
                (id) -> false, new FakeConcertVisitorRepository(null)
        );

        assertThrows(TicketCancellationNotAllowedException.class, () -> cancelTicketUseCase.invoke(1, 1));
    }

    @Test
    void remove_the_ticket_from_the_concert_visitor() {
        var concertVisitor = new ConcertVisitor(1, true);
        concertVisitor.addTicket(new Ticket(1, 1));
        var concertVisitorRepository = new FakeConcertVisitorRepository(concertVisitor);

        var cancelTicketUseCase = new CancelTicketUseCase(
                concertVisitorRepository,
                concertVisitorRepository,
                (id) -> true,
                concertVisitorRepository
        );

        cancelTicketUseCase.invoke(1, 1);

        var updatedConcertVisitor = concertVisitorRepository.fetchById(1);

        assertTrue(updatedConcertVisitor.getTickets().isEmpty());
    }
}
