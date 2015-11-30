package com.example.cassiano.mytestapiapp.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Cassiano on 25/11/2015.
 */
public class SimpleDialog extends DialogFragment implements DialogInterface.OnClickListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity()).setTitle("Dialogo simples").setMessage("Texto da mensagem").setPositiveButton("Sim", this).setNegativeButton("Não", this).setNeutralButton("Não sei", this).create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

        String msg = null;
        switch (which) {
            case Dialog.BUTTON_POSITIVE:
                msg = "Sim escolhido";
                break;
            case Dialog.BUTTON_NEUTRAL:
                msg = "Não sei escolhido";
                break;
            case Dialog.BUTTON_NEGATIVE:
                msg = "Não escolhido";
                break;
            default:
                msg = "Nenhuma opção selecionada";
        }
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }
}
