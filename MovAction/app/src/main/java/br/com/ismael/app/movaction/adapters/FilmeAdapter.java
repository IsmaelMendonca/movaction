package br.com.ismael.app.movaction.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import br.com.ismael.app.movaction.MainApplication;
import br.com.ismael.app.movaction.R;
import br.com.ismael.app.movaction.activities.DetailActivity;
import br.com.ismael.app.movaction.animations.ImageAnimation;
import br.com.ismael.app.movaction.enums.PosterSizeEnum;
import br.com.ismael.app.movaction.models.FilmePopular;
import br.com.ismael.app.movaction.repositories.access.FilmeFavoritoAccessAsyncTask;
import br.com.ismael.app.movaction.repositories.access.FilmeFavoritoResult;
import br.com.ismael.app.movaction.repositories.contracts.IAppRepository;
import br.com.ismael.app.movaction.repositories.entities.FilmeFavorito;
import br.com.ismael.app.movaction.repositories.enums.FilmeFavoritoEnum;
import br.com.ismael.app.movaction.services.contracts.IImagemService;
import br.com.ismael.app.movaction.transformations.CircleTransformation;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FilmeAdapter extends RecyclerView.Adapter<FilmeAdapter.FilmeItemHolder >  {
    private final List<FilmePopular> mFilmeList;
    private final Context mContext;
    private final View mContainerView;

    @Inject
    IImagemService mImagemService;

    @Inject
    IAppRepository mAppRepository;

    public FilmeAdapter(List<FilmePopular> filmeList, View containerView, Context context) {
        mFilmeList = filmeList;
        mContext = context;
        mContainerView = containerView;
        MainApplication.getAppComponent().inject(this);
    }

    @NonNull
    @Override
    public FilmeItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_filme, parent, false);
        FilmeItemHolder itemViewHolder = new FilmeItemHolder(view);
        view.setTag(itemViewHolder);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FilmeItemHolder holder, int position) {
        final FilmePopular filmePopular = mFilmeList.get(position);

        holder.mTvTituloFilme.setText(filmePopular.getTitulo());

        SimpleDateFormat dateFormat = new SimpleDateFormat("(yyyy)");

        holder.mTvDataLancamento.setText(dateFormat.format(filmePopular.getDataLancamento()));

        mImagemService.loadImage(
                holder.mIvPoster,
                filmePopular.getCaminhoImagePoster(),
                PosterSizeEnum.w154,
                new CircleTransformation());

        verificarFavorito(holder, filmePopular);

        holder.mIvPoster.setTag(filmePopular);
        holder.mCvFilmes.setTag(filmePopular);

        holder.mIvPoster.setOnClickListener(v -> {
            ImageAnimation animation = new ImageAnimation();
            ImageView imagemComZoom = mContainerView.findViewById(R.id.iv_imagem_zoom);
            FilmePopular dados = (FilmePopular) v.getTag();
            mImagemService.loadImage(imagemComZoom, dados.getCaminhoImagePoster(), PosterSizeEnum.w500);
            animation.zoomImage((ImageView) v, imagemComZoom, mContainerView);
        });

        holder.mCvFilmes.setOnClickListener(v -> {
            FilmePopular dados = (FilmePopular) v.getTag();
            Intent detalhes = new Intent(mContext, DetailActivity.class);
            detalhes.putExtra("filmeId", dados.getId());
            mContext.startActivity(detalhes);
        });
    }

    @Override
    public int getItemCount() {
        return mFilmeList.size();
    }

    private void verificarFavorito(final FilmeItemHolder holder, final FilmePopular filmePopular) {

        FilmeFavorito filmeFavorito = new FilmeFavorito(filmePopular.getId());

        FilmeFavoritoAccessAsyncTask asyncTask = new FilmeFavoritoAccessAsyncTask(
                mAppRepository.getDB().filmeFavoritoDao(),
                filmeFavorito,
                resposta -> {
                    if(resposta == null)
                        return;

                    FilmeFavoritoResult resultado = (FilmeFavoritoResult)resposta;

                    if(resposta instanceof FilmeFavoritoResult) {
                        resultado = (FilmeFavoritoResult) resposta;
                    }

                    if(resultado.getFilmeFavorito() == null) {
                        holder.mIvFavorito.setImageResource(R.drawable.ic_star_border);
                    } else {
                        holder.mIvFavorito.setImageResource(R.drawable.ic_star);
                    }
                });

        asyncTask.execute(FilmeFavoritoEnum.findByFilmeId);
    }

    class FilmeItemHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_titulo_filme)
        TextView mTvTituloFilme;

        @BindView(R.id.tv_data_lancamento)
        TextView mTvDataLancamento;

        @BindView(R.id.iv_poster)
        ImageView mIvPoster;

        @BindView(R.id.cv_filmes)
        CardView mCvFilmes;

        @BindView(R.id.iv_favorito)
        ImageView mIvFavorito;

        FilmeItemHolder (View view) {
            super(view);

            ButterKnife.bind(this, view);
        }
    }
}

