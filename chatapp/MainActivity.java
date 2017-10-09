package com.example.kasettilameri.chatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button sendButton;
    private EditText editText;
    private Receiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.conversation);
        sendButton = (Button)findViewById(R.id.sendButton);
        editText = (EditText)findViewById(R.id.editText);

        receiver = new Receiver(this);
        Thread receiverThread = new Thread(receiver);
        receiverThread.start();
    }

    public void appendMsg(String msg) {
        textView.append(msg);
    }



}
