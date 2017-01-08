package com.example.ruslan.chatapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static com.example.ruslan.chatapplication.LogInActivity.facebookName;
import static com.example.ruslan.chatapplication.MapsActivity.databaseBeaconRoot;

public class ChatRoomActivity extends AppCompatActivity {


    private Button btn_send_msg;
    private String temp_key;
    private EditText input_msg;
    private TextView chat_conversation;

    private DatabaseReference databaseChatroomRoot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);

        Intent i = getIntent();
        String roomName = i.getStringExtra("roomName");
        String roomPassword = i.getStringExtra("roomPassword");
        String beaconID = i.getStringExtra("beaconID");

        databaseChatroomRoot = databaseBeaconRoot.child(beaconID);
        databaseChatroomRoot = databaseChatroomRoot.child("chats");
        databaseChatroomRoot = databaseChatroomRoot.child(roomName);
        setTitle(" Room - "+roomName);

        btn_send_msg = (Button) findViewById(R.id.btn_send);
        input_msg = (EditText) findViewById(R.id.msg_input);
        chat_conversation = (TextView) findViewById(R.id.textView);



        btn_send_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Map<String,Object> map = new HashMap<String, Object>();
                temp_key = databaseChatroomRoot.push().getKey();
                databaseChatroomRoot.updateChildren(map);

                DatabaseReference message_root = databaseChatroomRoot.child(temp_key);
                Map<String,Object> map2 = new HashMap<String, Object>();
                map2.put("name",facebookName);
                map2.put("msg",input_msg.getText().toString());
                message_root.updateChildren(map2);
                input_msg.setText("");
            }
        });

        databaseChatroomRoot.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                addMessageToConversation(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                addMessageToConversation(dataSnapshot);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


    private void addMessageToConversation(DataSnapshot dataSnapshot) {

        String chat_msg,chat_user_name;

        Iterator i = dataSnapshot.getChildren().iterator();

        while (i.hasNext()){

            chat_msg = (String) ((DataSnapshot)i.next()).getValue();
            chat_user_name = (String) ((DataSnapshot)i.next()).getValue();

            chat_conversation.append(chat_user_name +" : "+chat_msg +" \n");
        }


    }
    }
