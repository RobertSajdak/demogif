package com.rs.gifdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Gif {

    @Getter
    private String name;
    @Getter
    private String username;
    @Getter
    private Boolean favorite;
    @Getter
    private int categoryId;


}

