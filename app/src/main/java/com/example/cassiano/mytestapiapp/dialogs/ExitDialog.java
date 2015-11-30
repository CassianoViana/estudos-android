package com.example.cassiano.mytestapiapp.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.cassiano.mytestapiapp.R;

/**
 * Created by Cassiano on 27/11/2015.
 */
public class ExitDialog extends DialogFragment implements DialogInterface.OnClickListener {

    private ExitListener listener;

    @Override
    public void onAttach(Activity activity) {
        try {
            listener = (ExitListener) activity;
        } catch (ClassCastException e) {
            throw new RuntimeException("A activity deve implementar ExitDialog.ExitListener");
        }
        super.onAttach(activity);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        CharSequence sim = getResources().getString(R.string.sim);
        CharSequence nao = getResources().getString(R.string.nao);
        return new AlertDialog.Builder(getActivity()).setMessage("Deseja sair?").setPositiveButton(sim, this).setNegativeButton(nao, this).create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == Dialog.BUTTON_POSITIVE) {
            listener.onExit();
        }
    }

    public interface ExitListener {
        void onExit();
    }
}
