package br.com.ismael.app.movaction.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MaisPopulares {
    @JsonProperty("page")
    private Integer mPagina;

    @JsonProperty("total_results")
    private Integer mTotalResultados;

    @JsonProperty("total_pages")
    private Integer mTotalPaginas;

    @JsonProperty("results")
    private List<FilmePopular> mListaFilmesPopulares = null;

    public Integer getPagina() {
        return mPagina;
    }

    public void setPagina(Integer pagina) {
        mPagina = pagina;
    }

    public Integer getTotalResultados() {
        return mTotalResultados;
    }

    public void setTotalResultados(Integer totalResultados) {
        mTotalResultados = totalResultados;
    }

    public Integer getTotalPaginas() {
        return mTotalPaginas;
    }

    public void setTotalPaginas(Integer totalPaginas) {
        mTotalPaginas = totalPaginas;
    }

    public List<FilmePopular> getListaFilmesPopulares() {
        return mListaFilmesPopulares;
    }

    public void setListaFilmesPopulares(List<FilmePopular> listaFilmesPopulares) {
        mListaFilmesPopulares = listaFilmesPopulares;
    }
}
