package com.sanvalero.service;

import com.sanvalero.domain.Country;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

import java.io.IOException;
import java.util.List;

import static com.sanvalero.utils.Constants.URL_BASE;

public class CountriesService {

    private CountriesApiService api;

    public CountriesService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        api = retrofit.create(CountriesApiService.class);
    }

    public List<Country> getAllCountries() {
        Call<List<Country>> allCountriesCall = api.getAllCountries();

        try {
            Response<List<Country>> response = allCountriesCall.execute();
            return response.body(); // Recoge el JSON de la web
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

//    public Observable<List<Country>> getAllCountries() {
//
//        return api.getAllCountries();
//
//    }


    public List<Country> getCountryByName(String name) {
        Call<List<Country>> countryByNameCall = api.getCountryByName(name);

        try {
            Response<List<Country>> response = countryByNameCall.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

}
