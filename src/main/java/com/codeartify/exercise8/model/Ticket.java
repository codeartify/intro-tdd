package com.codeartify.exercise8.model;

import jakarta.validation.constraints.Min;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Ticket {
    private Long id;
    @Min(value = 0, message = "Price must be greater than 0")
    private double price;
    private String type;
    private String qrCode;
    private Long bookerId;
    private boolean isPaid;
    private Event event;
}
