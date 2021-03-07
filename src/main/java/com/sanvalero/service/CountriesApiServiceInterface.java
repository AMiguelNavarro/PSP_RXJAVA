package com.sanvalero.service;

import com.sanvalero.domain.Country;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface CountriesApiServiceInterface {

    /**
     * Devuelve todas las countries de la API
     * @return
     */
    @GET("/rest/v2/all")
    Call<List<Country>> getAllCountries();


}
