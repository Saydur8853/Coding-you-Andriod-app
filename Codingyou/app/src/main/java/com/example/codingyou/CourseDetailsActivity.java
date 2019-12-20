package com.example.codingyou;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;

public class CourseDetailsActivity extends AppCompatActivity {

    private TextView text_view_intro_details;
    private TextView text_view_benefit_details;
    private TextView text_view_oop_details;
    private TextView text_view_oop_title;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        text_view_intro_details = (TextView) findViewById(R.id.text_view_intro_details);
        text_view_benefit_details = (TextView) findViewById(R.id.text_view_benefit_details);
        text_view_oop_details = (TextView) findViewById(R.id.text_view_oop_details);
        text_view_oop_title = (TextView) findViewById(R.id.text_view_oop_title);

        String course_name = getIntent().getExtras().getString("name");

        mDatabase = FirebaseDatabase.getInstance().getReference().child("course_details");


        mDatabase.child(course_name).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    String benefit = (String) dataSnapshot.child("benefit").getValue();
                    String intro = (String) dataSnapshot.child("intro").getValue();
                    String oop = (String) dataSnapshot.child("oop").getValue();

                    text_view_intro_details.setText(intro);
                    text_view_benefit_details.setText(benefit);
                    if (oop != null){
                        text_view_oop_title.setText("OOP");
                        text_view_oop_details.setText(oop);
                    }
                }
                else {
                    text_view_intro_details.setText("No data found!");
                    text_view_benefit_details.setText("No data found!");
                }

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("123456", "onCancelled: "+databaseError);

            }
        });

    }
}
