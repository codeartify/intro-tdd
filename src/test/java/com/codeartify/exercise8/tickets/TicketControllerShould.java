package com.codeartify.exercise8.tickets;

import com.codeartify.exercise8.tickets.model.Payment;
import com.codeartify.exercise8.tickets.model.PaymentRequest;
import com.codeartify.exercise8.tickets.model.Ticket;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TicketControllerShould {
    @Test
    void test() {
        var ticketController = new TicketController(null);

        var paymentRequest = new PaymentRequest();
        paymentRequest.setTickets(new ArrayList<>());


        assertThrows(IllegalArgumentException.class, () -> ticketController.processPayment(paymentRequest));

     }
     
    @Test
    void test2() {
        var ticketController = new TicketController(null);

        var paymentRequest = new PaymentRequest();
        paymentRequest.setTickets(List.of(
                new Ticket(),
                new Ticket(),
                new Ticket(),
                new Ticket(),
                new Ticket(),
                new Ticket(),
                new Ticket(),
                new Ticket(),
                new Ticket(),
                new Ticket(),
                new Ticket(),
                new Ticket(),
                new Ticket(),
                new Ticket(),
                new Ticket(),
                new Ticket(),
                new Ticket(),
                new Ticket(),
                new Ticket(),
                new Ticket(),
                new Ticket(),
                new Ticket(),
                new Ticket(),
                new Ticket()
        ));


        assertThrows(IllegalArgumentException.class, () -> ticketController.processPayment(paymentRequest));

     }

}