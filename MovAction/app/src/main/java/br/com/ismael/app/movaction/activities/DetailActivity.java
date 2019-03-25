package br.com.ismael.app.movaction.activities;

import android.os.Bundle;
import android.widget.ImageView;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import br.com.ismael.app.movaction.MainApplication;
import br.com.ismael.app.movaction.R;
import br.com.ismael.app.movaction.enums.PainelSizeEnum;
import br.com.ismael.app.movaction.models.FilmePopular;
import br.com.ismael.app.movaction.services.contracts.IImagemService;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.detail_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.iv_poster)
    ImageView mPoster;

    FilmePopular mFilme;

    @Inject
    IImagemService mImagemService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        init();
    }

    private void init() {
        ButterKnife.bind(this);

        MainApplication.getServicesComponent().inject(this);

        mFilme = (FilmePopular)getIntent().getSerializableExtra("filme");

        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        mToolbar.setLogo(R.mipmap.moviaction_logo);
        mToolbar.setNavigationOnClickListener(v -> onBackPressed());

        mImagemService.loadImage(mPoster, mFilme.getCaminhoImagePainel(), PainelSizeEnum.w780);
    }
}
