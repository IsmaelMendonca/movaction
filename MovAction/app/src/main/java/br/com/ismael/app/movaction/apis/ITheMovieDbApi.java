package br.com.ismael.app.movaction.apis;

import br.com.ismael.app.movaction.models.MaisPopulares;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ITheMovieDbApi {
    @GET("3/movie/popular")
    Call<MaisPopulares> listarFilmesPopulares(
            @Query("api_key") String chaveApi,
            @Query("language") String idioma,
            @Query("page") int pagina);
}
