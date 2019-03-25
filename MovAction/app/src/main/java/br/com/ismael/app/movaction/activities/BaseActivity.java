package br.com.ismael.app.movaction.activities;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import br.com.ismael.app.movaction.R;

public class BaseActivity extends AppCompatActivity {
    protected Dialog mDialog;

    protected final String TAG = getClass().getName();

    public void createDialog(String message, Context context) {
        closeDialog();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.alert_button_ok, (dialog, which) -> mDialog.dismiss());
        mDialog = builder.create();
        mDialog.show();
    }

    public void createDialog(String message, String title, Context context) {
        closeDialog();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setPositiveButton(R.string.alert_button_ok, (dialog, which) -> mDialog.dismiss());
        mDialog = builder.create();
        mDialog.show();
    }

    public void createConfirmDialog(Context context,
                                    @StringRes int message,
                                    @StringRes int positiveButtonMessage,
                                    @StringRes int negativeButtonMessage,
                                    DialogInterface.OnClickListener positiveListener,
                                    DialogInterface.OnClickListener negativeListener) {
        closeDialog();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(getString(message));
        builder.setPositiveButton(positiveButtonMessage, positiveListener);
        builder.setNegativeButton(negativeButtonMessage, negativeListener);

        mDialog = builder.create();
        mDialog.show();
    }

    public void createProgressDialog(String message, String title, Context context) {
        closeDialog();

        mDialog = ProgressDialog.show(context, title, message, false, false);
    }

    public void closeDialog() {
        if(mDialog != null && mDialog.isShowing())
            mDialog.dismiss();
    }
}
