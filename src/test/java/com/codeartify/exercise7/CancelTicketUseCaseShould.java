package com.codeartify.exercise7;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CancelTicketUseCaseShould {

    @Test
    void shouldThrowExceptionWhenConcertVisitorIsNotRegistered() {

        assertThrows(ConcertVisitorNotRegisteredException.class, () -> {
            var cancelTicketUseCase = new CancelTicketUseCase(
                    (id) -> Optional.empty()
            );

            cancelTicketUseCase.invoke(
                    1, 2
            );
        });
    }
}
