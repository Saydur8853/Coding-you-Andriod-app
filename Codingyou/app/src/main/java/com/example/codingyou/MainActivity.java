package com.example.codingyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button_c;
    private Button button_java;
    private Button button_python;
    private Button button_cpp;
    private Button button_html;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_c = (Button) findViewById(R.id.button_c);
        button_java = (Button) findViewById(R.id.button_java);
        button_python = (Button) findViewById(R.id.button_python);
        button_cpp = (Button) findViewById(R.id.button_cpp);
        button_html = (Button) findViewById(R.id.button_html);


        button_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CourseDetailsActivity.class);
                intent.putExtra("name","c");
                startActivity(intent);
            }
        });

        button_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CourseDetailsActivity.class);
                intent.putExtra("name","java");
                startActivity(intent);
            }
        });

        button_python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CourseDetailsActivity.class);
                intent.putExtra("name","python");
                startActivity(intent);
            }
        });

        button_cpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CourseDetailsActivity.class);
                intent.putExtra("name","cpp");
                startActivity(intent);
            }
        });

        button_html.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CourseDetailsActivity.class);
                intent.putExtra("name","html");
                startActivity(intent);
            }
        });
    }

}
