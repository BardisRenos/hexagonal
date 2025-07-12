package com.example.hexagonal.domain.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String name;
    private String lastName;
    private Integer age;
}
