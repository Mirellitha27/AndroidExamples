package com.mireya.pokedex.pokeApi;

import com.mireya.pokedex.models.PokemonRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokeapiService {
    @GET("pokemon")
    Call<PokemonRespuesta> obtenenerListaPokemon(@Query("limit") int limit, @Query("offset") int offset);

}
