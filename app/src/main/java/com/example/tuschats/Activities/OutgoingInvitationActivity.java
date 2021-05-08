package com.example.tuschats.Activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tuschats.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class OutgoingInvitationActivity extends AppCompatActivity {
//    private androidx.preference.PreferenceManager preferenceManager;
//    private String inviterToken=null;
    String id;
    DatabaseReference database;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outgoing_invitation);
        database = FirebaseDatabase.getInstance().getReference().child("users");
        id = getIntent().getStringExtra("id");
//        preferenceManager=new PreferenceManager(getApplicationContext());
//        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
//            @Override
//            public void onComplete(@NonNull Task<InstanceIdResult> task) {
//                inviterToken=task.getResult().getToken();
//            }
//        });
        ImageView imgmeeting=findViewById(R.id.imgmeeting1);
        String meetingtype =getIntent().getStringExtra("type");
        if (meetingtype!=null){
            if (meetingtype.equals("video")){
                imgmeeting.setImageResource(R.drawable.ic_video);
            }
        }
        TextView textUser=findViewById(R.id.textUser);
        CircleImageView imgviewcall=findViewById(R.id.imgviewcall);

            database.child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String ten = snapshot.child("name").getValue().toString();
                    String profile = snapshot.child("profileImage").getValue().toString();
                    Picasso.get().load(profile).into(imgviewcall);
                    textUser.setText(ten);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });

        ImageView imgstop=findViewById(R.id.imgstop);
        imgstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
    private void SendRemoteMessage(String remoteMessageBody,String type){
//        ApiClient.getClient().create(ApiClient.class).SendRemoteMessage(
//        )
    }
}