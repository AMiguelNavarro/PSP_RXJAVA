package com.sanvalero.domain;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Movie {

    private String title;
    private String summary;
    private String genre;
    private int duration;

}
