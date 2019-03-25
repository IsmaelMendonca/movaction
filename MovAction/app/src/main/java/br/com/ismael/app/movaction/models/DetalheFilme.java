package br.com.ismael.app.movaction.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetalheFilme {
    @JsonProperty("adult")
    private Boolean mParaAdultos;

    @JsonProperty("backdrop_path")
    private String mCaminhoImagemPainel;

    @JsonProperty("belongs_to_collection")
    private PertenceColecao mPertenceColecao;

    @JsonProperty("budget")
    private Integer mOrcamento;

    @JsonProperty("genres")
    private List<Genero> mGeneros = null;

    @JsonProperty("homepage")
    private String mPaginaInicial;

    @JsonProperty("id")
    private Integer mId;

    @JsonProperty("imdb_id")
    private String mIMDBId;

    @JsonProperty("original_language")
    private String mIdiomaOriginal;

    @JsonProperty("original_title")
    private String mTituloOriginal;

    @JsonProperty("overview")
    private String mResumo;

    @JsonProperty("popularity")
    private Double mPopularidade;

    @JsonProperty("poster_path")
    private String mCaminhoImagemPoster;

    @JsonProperty("production_companies")
    private List<EmpresaProdutora> mEmpresasProdutoras = null;

    @JsonProperty("production_countries")
    private List<PaisProdutor> mPaisesProdutores = null;

    @JsonProperty("release_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date mDataLancamento;

    @JsonProperty("revenue")
    private Integer mRendimento;

    @JsonProperty("runtime")
    private Integer mDuracao;

    @JsonProperty("spoken_languages")
    private List<IdiomaFalado> mListaIdiomas = null;

    @JsonProperty("status")
    private String mStatus;

    @JsonProperty("tagline")
    private String mTagline;

    @JsonProperty("title")
    private String mTitulo;

    @JsonProperty("video")
    private Boolean mPossuiVideo;

    @JsonProperty("vote_average")
    private Double mMediaVotos;

    @JsonProperty("vote_count")
    private Integer mTotalVotos;

    public Boolean getParaAdultos() {
        return mParaAdultos;
    }

    public void setParaAdultos(Boolean paraAdultos) {
        mParaAdultos = paraAdultos;
    }

    public String getCaminhoImagemPainel() {
        return mCaminhoImagemPainel.replace("/", "");
    }

    public void setCaminhoImagemPainel(String caminhoImagemPainel) {
        mCaminhoImagemPainel = caminhoImagemPainel;
    }

    public PertenceColecao getPertenceColecao() {
        return mPertenceColecao;
    }

    public void setPertenceColecao(PertenceColecao pertenceColecao) {
        mPertenceColecao = pertenceColecao;
    }

    public Integer getOrcamento() {
        return mOrcamento;
    }

    public void setOrcamento(Integer orcamento) {
        mOrcamento = orcamento;
    }

    public List<Genero> getGeneros() {
        return mGeneros;
    }

    public void setGeneros(List<Genero> generos) {
        mGeneros = generos;
    }

    public String getPaginaInicial() {
        return mPaginaInicial;
    }

    public void setPaginaInicial(String paginaInicial) {
        mPaginaInicial = paginaInicial;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public String getIMDBId() {
        return mIMDBId;
    }

    public void setIMDBId(String IMDBId) {
        mIMDBId = IMDBId;
    }

    public String getIdiomaOriginal() {
        return mIdiomaOriginal;
    }

    public void setIdiomaOriginal(String idiomaOriginal) {
        mIdiomaOriginal = idiomaOriginal;
    }

    public String getTituloOriginal() {
        return mTituloOriginal;
    }

    public void setTituloOriginal(String tituloOriginal) {
        mTituloOriginal = tituloOriginal;
    }

    public String getResumo() {
        return mResumo;
    }

    public void setResumo(String resumo) {
        mResumo = resumo;
    }

    public Double getPopularidade() {
        return mPopularidade;
    }

    public void setPopularidade(Double popularidade) {
        mPopularidade = popularidade;
    }

    public String getCaminhoImagemPoster() {
        return mCaminhoImagemPoster.replace("/", "");
    }

    public void setCaminhoImagemPoster(String caminhoImagemPoster) {
        mCaminhoImagemPoster = caminhoImagemPoster;
    }

    public List<EmpresaProdutora> getEmpresasProdutoras() {
        return mEmpresasProdutoras;
    }

    public void setEmpresasProdutoras(List<EmpresaProdutora> empresasProdutoras) {
        mEmpresasProdutoras = empresasProdutoras;
    }

    public List<PaisProdutor> getPaisesProdutores() {
        return mPaisesProdutores;
    }

    public void setPaisesProdutores(List<PaisProdutor> paisesProdutores) {
        mPaisesProdutores = paisesProdutores;
    }

    public Date getDataLancamento() {
        return mDataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        mDataLancamento = dataLancamento;
    }

    public Integer getRendimento() {
        return mRendimento;
    }

    public void setRendimento(Integer rendimento) {
        mRendimento = rendimento;
    }

    public Integer getDuracao() {
        return mDuracao;
    }

    public void setDuracao(Integer duracao) {
        mDuracao = duracao;
    }

    public List<IdiomaFalado> getListaIdiomas() {
        return mListaIdiomas;
    }

    public void setListaIdiomas(List<IdiomaFalado> listaIdiomas) {
        mListaIdiomas = listaIdiomas;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getTagline() {
        return mTagline;
    }

    public void setTagline(String tagline) {
        mTagline = tagline;
    }

    public String getTitulo() {
        return mTitulo;
    }

    public void setTitulo(String titulo) {
        mTitulo = titulo;
    }

    public Boolean getPossuiVideo() {
        return mPossuiVideo;
    }

    public void setPossuiVideo(Boolean possuiVideo) {
        mPossuiVideo = possuiVideo;
    }

    public Double getMediaVotos() {
        return mMediaVotos;
    }

    public void setMediaVotos(Double mediaVotos) {
        mMediaVotos = mediaVotos;
    }

    public Integer getTotalVotos() {
        return mTotalVotos;
    }

    public void setTotalVotos(Integer totalVotos) {
        mTotalVotos = totalVotos;
    }
}
