package br.com.ismael.app.movaction.animations;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class ImageAnimation {
    private AnimatorSet mCurrentAnimator;

    public void zoomImage(final ImageView miniatura, final ImageView imagemComZoom, final View container) {
        if (mCurrentAnimator != null) {
            mCurrentAnimator.cancel();
        }

        final Rect startBounds = new Rect();
        final Rect finalBounds = new Rect();
        final Point globalOffset = new Point();

        miniatura.getGlobalVisibleRect(startBounds);
        container.getGlobalVisibleRect(finalBounds, globalOffset);
        startBounds.offset(-globalOffset.x, -globalOffset.y);
        finalBounds.offset(-globalOffset.x, -globalOffset.y);

        float startScale;
        if ((float) finalBounds.width() / finalBounds.height()
                > (float) startBounds.width() / startBounds.height()) {

            startScale = (float) startBounds.height() / finalBounds.height();
            float startWidth = startScale * finalBounds.width();
            float deltaWidth = (startWidth - startBounds.width()) / 2;
            startBounds.left -= deltaWidth;
            startBounds.right += deltaWidth;
        } else {
            startScale = (float) startBounds.width() / finalBounds.width();
            float startHeight = startScale * finalBounds.height();
            float deltaHeight = (startHeight - startBounds.height()) / 2;
            startBounds.top -= deltaHeight;
            startBounds.bottom += deltaHeight;
        }

        imagemComZoom.setVisibility(View.VISIBLE);
        miniatura.setAlpha(0f);

        imagemComZoom.setPivotX(0f);
        imagemComZoom.setPivotY(0f);

        AnimatorSet set = new AnimatorSet();

        set.play(ObjectAnimator.ofFloat(imagemComZoom, View.X,
                        startBounds.left, finalBounds.left))
                .with(ObjectAnimator.ofFloat(imagemComZoom, View.Y,
                        startBounds.top, finalBounds.top))
                .with(ObjectAnimator.ofFloat(imagemComZoom, View.SCALE_X,
                        startScale, 1f))
                .with(ObjectAnimator.ofFloat(imagemComZoom,
                        View.SCALE_Y, startScale, 1f));
        set.setDuration(200);
        set.setInterpolator(new DecelerateInterpolator());
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mCurrentAnimator = null;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                mCurrentAnimator = null;
            }
        });
        set.start();
        mCurrentAnimator = set;

        final float startScaleFinal = startScale;
        imagemComZoom.setOnClickListener(view -> {
            if (mCurrentAnimator != null) {
                mCurrentAnimator.cancel();
            }

            AnimatorSet set1 = new AnimatorSet();
            set1.play(ObjectAnimator
                    .ofFloat(imagemComZoom, View.X, startBounds.left))
                    .with(ObjectAnimator
                            .ofFloat(imagemComZoom,
                                    View.Y,startBounds.top))
                    .with(ObjectAnimator
                            .ofFloat(imagemComZoom,
                                    View.SCALE_X, startScaleFinal))
                    .with(ObjectAnimator
                            .ofFloat(imagemComZoom,
                                    View.SCALE_Y, startScaleFinal));
            set1.setDuration(200);
            set1.setInterpolator(new DecelerateInterpolator());
            set1.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    miniatura.setAlpha(1f);
                    imagemComZoom.setVisibility(View.GONE);
                    mCurrentAnimator = null;
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                    miniatura.setAlpha(1f);
                    imagemComZoom.setVisibility(View.GONE);
                    mCurrentAnimator = null;
                }
            });
            set1.start();
            mCurrentAnimator = set1;
        });
    }
}
