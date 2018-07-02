package com.aldominium.marvelheroes.Api;

import com.aldominium.marvelheroes.Models.Basic;
import com.aldominium.marvelheroes.Models.Data;
import com.aldominium.marvelheroes.Models.SuperHero;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by aldo on 30/12/2016.
 */

public interface Marvel {

    String BASE_URL = "https://gateway.marvel.com/";

    String API_KEY_KEY = "apikey";
    String API_KEY_VALUE = "08797c2d81fbb7af0b495809a79a648d";

    String TIME_STAMP_KEY = "ts";
    String TIME_STAMP_VALUE = "1";

    String HASH_KEY = "hash";
    String HASH_VALUE = "2b97783910ab5a1f50736adbdf1fa951";



    @GET("v1/public/series/{seriesId}/characters")
    Call<Basic<Data<ArrayList<SuperHero>>>> getHeroes(@Path("seriesId") int seriesId);


}












