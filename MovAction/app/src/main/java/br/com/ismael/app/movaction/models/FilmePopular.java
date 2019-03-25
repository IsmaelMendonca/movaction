package br.com.ismael.app.movaction.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FilmePopular implements Serializable {
    @JsonProperty("vote_count")
    private Integer mQuantidadeVotos;

    @JsonProperty("id")
    private Integer mId;

    @JsonProperty("video")
    private Boolean mVideo;

    @JsonProperty("vote_average")
    private Double mMediaVotos;

    @JsonProperty("title")
    private String mTitulo;

    @JsonProperty("popularity")
    private Double mPopularidade;

    @JsonProperty("poster_path")
    private String mCaminhoImagePoster;

    @JsonProperty("original_language")
    private String mLinguaOriginal;

    @JsonProperty("original_title")
    private String mTituloOriginal;

    @JsonProperty("genre_ids")
    private List<Integer> mListaIdGenero = null;

    @JsonProperty("backdrop_path")
    private String mCaminhoImagePainel;

    @JsonProperty("adult")
    private Boolean mParaAdultos;

    @JsonProperty("overview")
    private String mResumo;

    @JsonProperty("release_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date mDataLancamento;

    public Integer getQuantidadeVotos() {
        return mQuantidadeVotos;
    }

    public void setQuantidadeVotos(Integer quantidadeVotos) {
        mQuantidadeVotos = quantidadeVotos;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public Boolean getVideo() {
        return mVideo;
    }

    public void setVideo(Boolean video) {
        mVideo = video;
    }

    public Double getMediaVotos() {
        return mMediaVotos;
    }

    public void setMediaVotos(Double mediaVotos) {
        mMediaVotos = mediaVotos;
    }

    public String getTitulo() {
        return mTitulo;
    }

    public void setTitulo(String titulo) {
        mTitulo = titulo;
    }

    public Double getPopularidade() {
        return mPopularidade;
    }

    public void setPopularidade(Double popularidade) {
        mPopularidade = popularidade;
    }

    public String getCaminhoImagePoster() {
        return mCaminhoImagePoster.replace("/", "");
    }

    public void setCaminhoImagePoster(String caminhoImagePoster) {
        mCaminhoImagePoster = caminhoImagePoster;
    }

    public String getLinguaOriginal() {
        return mLinguaOriginal;
    }

    public void setLinguaOriginal(String linguaOriginal) {
        mLinguaOriginal = linguaOriginal;
    }

    public String getTituloOriginal() {
        return mTituloOriginal;
    }

    public void setTituloOriginal(String tituloOriginal) {
        mTituloOriginal = tituloOriginal;
    }

    public List<Integer> getListaIdGenero() {
        return mListaIdGenero;
    }

    public void setListaIdGenero(List<Integer> listaIdGenero) {
        mListaIdGenero = listaIdGenero;
    }

    public String getCaminhoImagePainel() {
        return mCaminhoImagePainel.replace("/", "");
    }

    public void setCaminhoImagePainel(String caminhoImagePainel) {
        mCaminhoImagePainel = caminhoImagePainel;
    }

    public Boolean getParaAdultos() {
        return mParaAdultos;
    }

    public void setParaAdultos(Boolean paraAdultos) {
        mParaAdultos = paraAdultos;
    }

    public String getResumo() {
        return mResumo;
    }

    public void setResumo(String resumo) {
        mResumo = resumo;
    }

    public Date getDataLancamento() {
        return mDataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        mDataLancamento = dataLancamento;
    }
}
