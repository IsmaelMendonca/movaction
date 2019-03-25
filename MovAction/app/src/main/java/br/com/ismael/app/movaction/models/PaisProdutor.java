package br.com.ismael.app.movaction.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaisProdutor {
    @JsonProperty("iso_3166_1")
    private String mIso31661;

    @JsonProperty("name")
    private String mNome;

    public String getIso31661() {
        return mIso31661;
    }

    public void setIso31661(String iso31661) {
        mIso31661 = iso31661;
    }

    public String getNome() {
        return mNome;
    }

    public void setNome(String nome) {
        mNome = nome;
    }
}
