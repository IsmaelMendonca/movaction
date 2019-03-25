package br.com.ismael.app.movaction.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PertenceColecao {
    @JsonProperty("id")
    private Integer mId;

    @JsonProperty("name")
    private String mNome;

    @JsonProperty("poster_path")
    private String mCaminhoImagePoster;

    @JsonProperty("backdrop_path")
    private String mCaminhoImagePainel;

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public String getNome() {
        return mNome;
    }

    public void setNome(String nome) {
        mNome = nome;
    }

    public String getCaminhoImagePoster() {
        return mCaminhoImagePoster;
    }

    public void setCaminhoImagePoster(String caminhoImagePoster) {
        mCaminhoImagePoster = caminhoImagePoster;
    }

    public String getCaminhoImagePainel() {
        return mCaminhoImagePainel;
    }

    public void setCaminhoImagePainel(String caminhoImagePainel) {
        mCaminhoImagePainel = caminhoImagePainel;
    }
}
