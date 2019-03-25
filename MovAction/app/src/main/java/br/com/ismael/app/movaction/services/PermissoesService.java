package br.com.ismael.app.movaction.services;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;

public class PermissoesService {
    private final Context mContext;
    private final Activity mActivity;

    public PermissoesService(Context context, Activity activity) {
        mContext = context;
        mActivity = activity;
    }

    public void obterPermissao(int codigoPermissao) {
        if (ActivityCompat.checkSelfPermission(mContext, android.Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.INTERNET}, codigoPermissao);
        }
    }
}
