package com.sanvalero.controller;

import com.sanvalero.domain.Country;
import com.sanvalero.service.CountriesServiceImplementation;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AppController implements Initializable {

    public Button btListAll;
    public ListView lvList;
    CountriesServiceImplementation service;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        service = new CountriesServiceImplementation();
    }


    @FXML
    public void listAllCountries(Event event) {

        System.out.println("Funciona");

        List<Country> allCountries = service.getAllCountries();

//        System.out.println(allCountries.toString()); /* Pinta todas correctamente por consola */

    }

}
