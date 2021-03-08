package com.sanvalero.service;

import com.sanvalero.domain.Country;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

import java.util.List;

public interface CountriesApiService {

    /**
     * Devuelve todas los paises de la API
     * @return
     */
    @GET("/rest/v2/all")
    Call<List<Country>> getAllCountries(); // Call necesario para que funcione retrofit


    /**
     * Devuelve los paises por nombre
     * @param name
     * @return
     */
    @GET("rest/v2/name/{name}")
    Call<List<Country>> getCountryByName(@Path("name") String name);


}
