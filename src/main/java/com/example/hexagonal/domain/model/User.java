package com.example.hexagonal.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer id;
    private String name;
    private String lastName;
    private Integer age;
}
