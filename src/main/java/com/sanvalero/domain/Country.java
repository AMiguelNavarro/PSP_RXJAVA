package com.sanvalero.domain;

import lombok.Data;

@Data
public class Country {

    public String name, capital, region, subregion;

    @Override
    public String toString() {
        return name + " [ " + capital + region + " ]";
    }

//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getCapital() {
//        return capital;
//    }
//    public void setCapital(String capital) {
//        this.capital = capital;
//    }
//    public String getRegion() {
//        return region;
//    }
//    public void setRegion(String region) {
//        this.region = region;
//    }
//    public String getSubregion() {
//        return subregion;
//    }
//    public void setSubregion(String subregion) {
//        this.subregion = subregion;
//    }

}
