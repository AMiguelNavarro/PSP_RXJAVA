package com.sanvalero.controller;

import com.sanvalero.domain.Country;
import com.sanvalero.service.CountriesService;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;

public class AppController implements Initializable {

    public Button btListAll;
    public ListView lvList;
    CountriesService service;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        service = new CountriesService();
    }


    @FXML
    public void listAllCountries(Event event) {

        System.out.println("Funciona");

        lvList.getItems().clear();

        List<Country> allCountries = service.getAllCountries();

        lvList.setItems(FXCollections.observableList(allCountries));

//        service.getAllCountries()
//                .flatMap(Observable::from)
//                .doOnCompleted(() -> System.out.println("Listado de países descargado"))
//                .doOnError(throwable -> System.out.println(throwable.getMessage()))
//                .subscribeOn(Schedulers.from(Executors.newCachedThreadPool()))
//                .subscribe(lvList.setItems(FXCollections.observableList()));

        //System.out.println(allCountries.toString()); /* Pinta todas correctamente por consola */

    }

}
