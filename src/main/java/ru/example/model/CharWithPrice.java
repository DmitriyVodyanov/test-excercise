package ru.example.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "Builder", setterPrefix = "set")
public class CharWithPrice {

    private String str;
    private int price;
}
