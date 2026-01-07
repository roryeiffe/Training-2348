package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// The first 2 create constructors
@NoArgsConstructor
@AllArgsConstructor
@Data // This annotation includes many methods (getters/setters, toString)
public class Account {
    private int id;
    private String name;
    private String password;


}
