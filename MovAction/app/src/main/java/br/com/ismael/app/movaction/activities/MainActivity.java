package br.com.ismael.app.movaction.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import br.com.ismael.app.movaction.MainApplication;
import br.com.ismael.app.movaction.R;
import br.com.ismael.app.movaction.adapters.FilmeAdapter;
import br.com.ismael.app.movaction.listeners.EndlessRecyclerViewScrollListener;
import br.com.ismael.app.movaction.models.FilmePopular;
import br.com.ismael.app.movaction.models.MaisPopulares;
import br.com.ismael.app.movaction.services.PermissoesService;
import br.com.ismael.app.movaction.services.callbacks.GenericCallback;
import br.com.ismael.app.movaction.services.contracts.IFilmesService;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    @BindView(R.id.rv_filmes)
    RecyclerView mFilmes;

    @BindView(R.id.main_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.pb_carregando)
    ProgressBar mProgressBar;

    @BindView(R.id.iv_imagem_zoom)
    ImageView mImagemZoom;

    @Inject
    IFilmesService mFilmesService;

    List<FilmePopular> mFilmePopularList;

    private final static int INTERNET_PERMISSION_CODE = 21;
    int paginaAtual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {

        ButterKnife.bind(this);

        MainApplication.getAppComponent().inject(this);

        PermissoesService permissoesService = new PermissoesService(getApplicationContext(), this);
        permissoesService.obterPermissao(INTERNET_PERMISSION_CODE);

        mToolbar.setLogo(R.mipmap.moviaction_logo);
        mProgressBar.setEnabled(true);
        obterFilmesPopulares();
    }

    private void obterFilmesPopulares() {
        mProgressBar.setVisibility(View.VISIBLE);

        if(paginaAtual == 0) {
            mFilmePopularList = new ArrayList<>();
        }

        mFilmesService.obterMaisPopulares(paginaAtual + 1, new GenericCallback<MaisPopulares>() {
            @Override
            public void onResponse(Call<MaisPopulares> call, Response<MaisPopulares> response) {
                if(response.body() == null ||
                   response.body().getListaFilmesPopulares() == null ||
                   response.body().getListaFilmesPopulares().isEmpty()) {
                    return;
                }

                List<FilmePopular> temp = response.body().getListaFilmesPopulares();

                mFilmePopularList.addAll(temp);

                if(paginaAtual == 0) {
                    mFilmes.setAdapter(new FilmeAdapter(mFilmePopularList, findViewById(R.id.cl_main_container), MainActivity.this));

                    LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);

                    mFilmes.setLayoutManager(layoutManager);

                    mFilmes.addOnScrollListener(
                            new EndlessRecyclerViewScrollListener(layoutManager) {
                                @Override
                                public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                                    paginaAtual = page;
                                    obterFilmesPopulares();
                                }
                            });
                }
                mProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<MaisPopulares> call, Throwable t) {
                Log.e("RequestException", t.getMessage());
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(mImagemZoom.getVisibility() == View.VISIBLE) {
            return;
        }

        super.onBackPressed();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onPostResume() {
        if(mFilmes.getAdapter() == null)
        {
            super.onPostResume();
            return;
        }

        mFilmes.getAdapter().notifyDataSetChanged();
        super.onPostResume();
    }
}
