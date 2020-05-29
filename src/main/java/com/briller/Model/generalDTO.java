package com.briller.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is a DTO (Data Transfer Object).
 * DTO is an object that carries data between processes
 * It holds all the data for a call.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class generalDTO {


    private int id;
    private String name;
}
