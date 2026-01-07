package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    // the value annotation lets use specify the value for this field
    @Value("1")
    private int id;
    @Value("Firebolt")
    private String name;
    @Value("Broom")
    private String category;
}
