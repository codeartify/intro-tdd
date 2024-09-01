package com.codeartify.exercise8.tickets.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Payment {
    private Long id;
    private double amount;
    private String paymentMethod;
    private String description;
    private boolean successful;
}
