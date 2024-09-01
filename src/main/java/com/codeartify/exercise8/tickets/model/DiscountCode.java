package com.codeartify.exercise8.tickets.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class DiscountCode {
    private Long id;
    private String code;
    private double discountPercentage;
    private String applicableTicketType;
}
