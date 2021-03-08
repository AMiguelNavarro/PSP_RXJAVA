package com.sanvalero.controller;

import com.sanvalero.domain.Country;
import com.sanvalero.service.CountriesService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class AppController implements Initializable {

    public Button btListAll, btFindByName;
    public ListView lvList;
    public TextField tfName;
    public TableView tvByName;

    CountriesService service;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        service = new CountriesService();
        fixColumns();
    }


    @FXML
    public void listAllCountries(Event event) {

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


    @FXML
    public void findByName(Event event) {
        String name = tfName.getText();

        if (name.isEmpty() || name.isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("El campo nombre no puede estar vacío");
            alert.show();
            return;
        }

        tvByName.getItems().clear();

        List<Country> countryByName = service.getCountryByName(name);

        if (countryByName == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información");
            alert.setContentText("No hay ningún país con ese nombre");
            alert.show();

            return;
        }

        tvByName.setItems(FXCollections.observableList(countryByName));

    }

    private void fixColumns() {
        Field[] fields = Country.class.getDeclaredFields();

        for(Field field : fields) {
            if (field.getName().equals("subregion"))
                continue;

            TableColumn<Country, String> column = new TableColumn<>(field.getName());
            column.setCellValueFactory(new PropertyValueFactory<>(field.getName()));
            tvByName.getColumns().add(column);
        }

        tvByName.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); // Ajusta el ancho de la tabla

    }

}
