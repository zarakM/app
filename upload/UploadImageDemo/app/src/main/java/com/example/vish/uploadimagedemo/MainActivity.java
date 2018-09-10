package com.example.vish.uploadimagedemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;


    RadioButton selection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = (RadioGroup)findViewById(R.id.radiomain);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                 selection = (RadioButton)findViewById(checkedId);
                if(selection.getText().equals("Upload Image"))
                {

                    FragmentManager fm = MainActivity.this.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction;
                    Fragment fragment = new UploadImageFragment();
                    fragmentTransaction =
                            fm.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentview, fragment);
                    fragmentTransaction.commit();

                }
                else if(selection.getText().equals("View Image"))
                {
                    FragmentManager fm = MainActivity.this.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction;
                    Fragment fragment = new ViewImageFragment();

                    fragmentTransaction =
                            fm.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentview, fragment);
                    fragmentTransaction.commit();
                }
            }
        });
    }
}
