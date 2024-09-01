package com.codeartify.exercise8.tickets.model;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Event {
    private Long id;
    @NotBlank(message = "An event must have a name")
    private String name;
    @Min(value = 1, message = "Number of tickets a buyer can buy at a time needs to be larger 0")
    private int numberOfTicketsPerBooker;
}
