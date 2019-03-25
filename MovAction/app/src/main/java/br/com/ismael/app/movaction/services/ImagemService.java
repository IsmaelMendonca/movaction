package br.com.ismael.app.movaction.services;

import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import javax.inject.Inject;

import br.com.ismael.app.movaction.enums.SizeEnum;
import br.com.ismael.app.movaction.services.contracts.IImagemService;
import br.com.ismael.app.movaction.singletons.ConfigurationsProperties;

public class ImagemService implements IImagemService {

    @Inject
    public ImagemService() {
    }

    @Override
    public void loadImage(ImageView view, String imageSource, SizeEnum sizeEnum, Transformation transformation) {

        if(TextUtils.isEmpty(imageSource))
            return;

        Uri uriBuilder = Uri.parse(ConfigurationsProperties.getInstance().getBaseImageUrl())
                .buildUpon()
                .appendPath(sizeEnum.obterTamanho())
                .appendPath(imageSource)
                .build();

        if(transformation == null) {
            Picasso.get().load(uriBuilder.toString()).into(view);
        } else {
            Picasso.get().load(uriBuilder.toString()).transform(transformation).into(view);
        }
    }

    @Override
    public void loadImage(ImageView view, String imageSource, SizeEnum posterSize) {
        loadImage(view, imageSource, posterSize, null);
    }
}
