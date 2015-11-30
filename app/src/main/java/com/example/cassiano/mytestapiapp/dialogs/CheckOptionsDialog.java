package com.example.cassiano.mytestapiapp.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.example.cassiano.mytestapiapp.R;

/**
 * Created by Cassiano on 25/11/2015.
 */
public class CheckOptionsDialog extends DialogFragment implements DialogInterface.OnMultiChoiceClickListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        boolean[] comidasSelecioandas = {true, false, false, false, true};
        return new AlertDialog.Builder(getActivity()).setTitle("Comidas").setMultiChoiceItems(R.array.comidas, comidasSelecioandas, this).create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
        String[] comidas = getActivity().getResources().getStringArray(R.array.comidas);
        String msg;
        String comida = comidas[which];
        if(isChecked){
            msg = "Você marcou a comida " + comida;
        }else{
            msg = "Você desmarcou a comida " + comida;
        }
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
