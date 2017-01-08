package com.example.ruslan.chatapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class CreateACastleActivity extends AppCompatActivity {

    Button buildCastleButton;
    EditText chatName, password;
    CheckBox s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acastle);

        buildCastleButton = (Button) findViewById(R.id.nextButton);
        chatName = (EditText) findViewById(R.id.chatName);
        password = (EditText) findViewById(R.id.password);
        s = (CheckBox) findViewById(R.id.privateSwitch);

        final String beaconID = getIntent().getStringExtra("beaconID");

        buildCastleButton.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent chatRoomActivity = new Intent (CreateACastleActivity.this, ChatRoomActivity.class);
                String name = chatName.getText().toString();
                chatRoomActivity.putExtra("roomName", name);
                chatRoomActivity.putExtra("beaconID", beaconID);

                if (s.isChecked()) {
                    String pass = password.getText().toString();
                    chatRoomActivity.putExtra("roomPassword", pass);
                }
                startActivity(chatRoomActivity);
            }
        });
    }
}
