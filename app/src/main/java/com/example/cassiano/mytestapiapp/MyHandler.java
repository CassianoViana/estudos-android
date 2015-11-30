package com.example.cassiano.mytestapiapp;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Cassiano on 20/11/2015.
 */
public class MyHandler extends Handler {

    public static final int UPDATE_UI = 0;
    private final TextView textView;

    public MyHandler(TextView textView){
        this.textView = textView;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);

        if(msg.what == MyHandler.UPDATE_UI){
            String texto = msg.getData().getString("texto");
            textView.setText(texto);
        }
    }
}
