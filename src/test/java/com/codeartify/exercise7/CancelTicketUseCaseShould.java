package com.codeartify.exercise7;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CancelTicketUseCaseShould {

    /**
     * CancelTicketUseCase.execute(concertVisitorId, concertId)
     * Check if the Concert Visitor is Registered:
     * Fetch the concert visitor from the database using their ID.
     * If the visitor is not registered, throw a ConcertVisitorNotRegisteredException.
     * Check if the Visitor has Purchased the Ticket:
     * Verify if the visitor has purchased a ticket for the specified concert.
     * If the visitor has not purchased the ticket, throw a TicketNotPurchasedException.
     * Check Cancellation Eligibility:
     * Determine if the concert visitor is eligible for a cancellation based on the concert's cancellation policy (e.g., within a certain time frame before the concert).
     * If the visitor is not eligible, throw a TicketCancellationNotAllowedException.
     * Check for Cancellation Fees (if applicable):
     * If the cancellation is allowed but a fee applies, calculate the fee.
     * remove the ticket from the visitor’s record. 
     * Issue a Refund (if applicable):
     * If the visitor is eligible for a refund, process the refund according to the payment method used.
     * Return the RefundDetails (amount refunded, payment method, and date) to the visitor.
     * Return Cancellation Confirmation:
     * Provide a confirmation of cancellation, including details like the ticket number, concert name, and refund status.
     */
    @Test
    void shouldThrowExceptionWhenConcertVisitorIsNotRegistered() {
        assertThrows(ConcertVisitorNotRegisteredException.class, () -> {
            var cancelTicketUseCase = new CancelTicketUseCase(
                    (id) -> Optional.empty()
            );

            cancelTicketUseCase.invoke(1, 2);
        });
    }
}
