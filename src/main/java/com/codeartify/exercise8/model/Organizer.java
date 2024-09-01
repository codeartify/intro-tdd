package com.codeartify.exercise8.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Organizer {
    private Long id;
    private String companyName;
    private String contactName;
}
