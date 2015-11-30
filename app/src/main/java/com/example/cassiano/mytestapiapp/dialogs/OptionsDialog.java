package com.example.cassiano.mytestapiapp.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.example.cassiano.mytestapiapp.R;

/**
 * Created by Cassiano on 25/11/2015.
 */
public class OptionsDialog extends DialogFragment implements DialogInterface.OnClickListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity()).setTitle("Comidas").setItems(R.array.comidas, this).create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        String[] comidas = getActivity().getResources().getStringArray(R.array.comidas);
        Toast.makeText(getActivity(), "Você escolheu a comida "+comidas[which], Toast.LENGTH_SHORT).show();
    }
}
