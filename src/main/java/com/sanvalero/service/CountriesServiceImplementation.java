package com.sanvalero.service;

import com.sanvalero.domain.Country;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

import static com.sanvalero.utils.Constants.URL_BASE;

public class CountriesServiceImplementation {

    private CountriesApiServiceInterface api;

    public CountriesServiceImplementation() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(CountriesApiServiceInterface.class);
    }

    public List<Country> getAllCountries() {
        Call<List<Country>> allCountriesCall = api.getAllCountries();

        try {
            Response<List<Country>> response = allCountriesCall.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

}
