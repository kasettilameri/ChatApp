package com.example.kasettilameri.chatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button sendButton;
    private EditText editText;
    private Messenger messenger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.conversation);
        sendButton = (Button)findViewById(R.id.sendButton);
        editText = (EditText)findViewById(R.id.editText);

        messenger = new Messenger(this);
        Thread messengerThread = new Thread(messenger);
        messengerThread.start();

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gettxt,sendtxt,cleartxt
                messenger.sendMsg(editText.getText().toString());
                editText.getText().clear();
            }
        });
    }

    public void appendMsg(String msg) {
        textView.append(msg);
    }



}
