package br.com.ismael.app.movaction.services.contracts;

import android.widget.ImageView;

import com.squareup.picasso.Transformation;

import br.com.ismael.app.movaction.enums.SizeEnum;

public interface IImagemService {
    void loadImage(ImageView view, String imageSource, SizeEnum posterSize, Transformation transformation);
    void loadImage(ImageView view, String imageSource, SizeEnum posterSize);
}
