package com.example.ruslan.chatapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class CreateACastleActivity extends AppCompatActivity {

    Button confirmButton;
    EditText chatName, password;
    CheckBox s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acastle);

        confirmButton = (Button) findViewById(R.id.nextButton);
        chatName = (EditText) findViewById(R.id.chatName);
        password = (EditText) findViewById(R.id.password);
        s = (CheckBox) findViewById(R.id.privateSwitch);

        confirmButton.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
                String name = chatName.getText().toString(),
                        pass = password.getText().toString();
                Boolean priv = s.isChecked();
            }
        });
    }
}
