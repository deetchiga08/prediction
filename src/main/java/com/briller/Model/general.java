package com.briller.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.*;
/**
 * add @Data, @NoArgsConstructor, @AllArgsConstructor in the models ,
 * the lombok will automatically create getter and setter and also two constructor,
 * one is empty and other one is parameterized.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ConfigurationProperties("example")
public class general {

    @Id
    private int id;
    private String name;



}
