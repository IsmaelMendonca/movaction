package br.com.ismael.app.movaction.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Iterator;

import javax.inject.Inject;

import androidx.appcompat.widget.Toolbar;
import br.com.ismael.app.movaction.MainApplication;
import br.com.ismael.app.movaction.R;
import br.com.ismael.app.movaction.enums.PainelSizeEnum;
import br.com.ismael.app.movaction.enums.PosterSizeEnum;
import br.com.ismael.app.movaction.models.DetalheFilme;
import br.com.ismael.app.movaction.models.Genero;
import br.com.ismael.app.movaction.services.callbacks.GenericCallback;
import br.com.ismael.app.movaction.services.contracts.IFilmesService;
import br.com.ismael.app.movaction.services.contracts.IImagemService;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Response;

public class DetailActivity extends BaseActivity {

    @BindView(R.id.detail_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.iv_painel)
    ImageView mPainel;

    @BindView(R.id.tv_titulo_filme)
    TextView mTituloFilme;

    @BindView(R.id.iv_detalhe_poster)
    ImageView mDetalhePoster;

    @BindView(R.id.tv_detalhe_data_lancamento_label)
    TextView mDataLancamentoLabel;

    @BindView(R.id.tv_detalhe_data_lancamento)
    TextView mDataLancamento;

    @BindView(R.id.tv_detalhe_duracao_label)
    TextView mDuracaoLabel;

    @BindView(R.id.tv_detalhe_duracao)
    TextView mDuracao;

    @BindView(R.id.tv_detalhe_genero_label)
    TextView mGeneroLabel;

    @BindView(R.id.tv_detalhe_genero)
    TextView mGenero;

    @BindView(R.id.tv_detalhe_resumo_label)
    TextView mResumoLabel;

    @BindView(R.id.tv_detalhe_resumo)
    TextView mResumo;

    @Inject
    IImagemService mImagemService;

    @Inject
    IFilmesService mFilmesService;

    DetalheFilme mFilme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        init();
    }

    private void init() {
        ButterKnife.bind(this);

        MainApplication.getServicesComponent().inject(this);

        detalharFilme();

        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        mToolbar.setLogo(R.mipmap.moviaction_logo);
        mToolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    private void detalharFilme() {
        closeDialog();
        createProgressDialog(getString(R.string.alert_realizando_requisicao), getString(R.string.alert_carregando), this);

        int filmeId = getIntent().getIntExtra("filmeId", 0);

        mFilmesService.detalharFilme(filmeId, new GenericCallback<DetalheFilme>() {
            @Override
            public void onResponse(Call<DetalheFilme> call, Response<DetalheFilme> response) {

                if(response.body() == null) {
                    closeDialog();
                    return;
                }

                mFilme = response.body();

                mImagemService.loadImage(mPainel, mFilme.getCaminhoImagemPainel(), PainelSizeEnum.w780);
                mImagemService.loadImage(mDetalhePoster, mFilme.getCaminhoImagemPoster(), PosterSizeEnum.w185);
                mTituloFilme.setText(mFilme.getTitulo());

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                mDataLancamento.setText(format.format(mFilme.getDataLancamento()));

                mDuracao.setText(mFilme.getDuracao().toString() + "m");

                StringBuilder generoBuilder = new StringBuilder();

                Iterator<Genero> iterator = mFilme.getGeneros().iterator();

                while (iterator.hasNext()) {
                    Genero genero = iterator.next();
                    generoBuilder.append(genero.getNome());

                    if(iterator.hasNext())
                        generoBuilder.append(", ");
                }

                mGenero.setText(generoBuilder.toString());
                mResumo.setText(mFilme.getResumo());

                mDataLancamentoLabel.setVisibility(View.VISIBLE);
                mGeneroLabel.setVisibility(View.VISIBLE);
                mDuracaoLabel.setVisibility(View.VISIBLE);
                mResumoLabel.setVisibility(View.VISIBLE);

                closeDialog();
            }

            @Override
            public void onFailure(Call<DetalheFilme> call, Throwable t) {
                Log.e("RequestException", t.getMessage());
                closeDialog();
            }
        });
    }
}
