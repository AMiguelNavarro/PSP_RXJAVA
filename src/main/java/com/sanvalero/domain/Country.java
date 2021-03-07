package com.sanvalero.domain;

public class Country {

    public String name, capital, region, subregion;

    @Override
    public String toString() {
        return name + " [ " + capital + " ]";
    }
}
