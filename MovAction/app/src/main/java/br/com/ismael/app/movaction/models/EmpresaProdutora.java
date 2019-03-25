package br.com.ismael.app.movaction.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmpresaProdutora {
    @JsonProperty("id")
    private Integer mId;

    @JsonProperty("logo_path")
    private String mCaminhoLogo;

    @JsonProperty("name")
    private String mNome;

    @JsonProperty("origin_country")
    private String mPaisOriginal;

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public String getCaminhoLogo() {
        return mCaminhoLogo;
    }

    public void setCaminhoLogo(String caminhoLogo) {
        mCaminhoLogo = caminhoLogo;
    }

    public String getNome() {
        return mNome;
    }

    public void setNome(String nome) {
        mNome = nome;
    }

    public String getPaisOriginal() {
        return mPaisOriginal;
    }

    public void setPaisOriginal(String paisOriginal) {
        mPaisOriginal = paisOriginal;
    }
}
