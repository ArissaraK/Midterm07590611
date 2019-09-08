package com.example.midterm07590611;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.midterm07590611.model.Auth;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Button loginButton = findViewById(R.id.Login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText emailEditText = findViewById(R.id.Username_editText);
                EditText passwordEditText = findViewById(R.id.Password_editText);




                String inputEmail = emailEditText.getText().toString();

                String inputPassword = passwordEditText.getText().toString();

                String loginsuccessText = getString(R.string.Login_success);
                String loginfailedText = getString(R.string.Login_failed);

                Auth auth = new Auth(inputEmail, inputPassword);
                //auth.setEmail(inputEmail);
                //auth.setPassword(inputPassword);

                boolean result = auth.check();

                if(result){
                    Toast.makeText(
                            LoginActivity.this,
                            R.string.Login_success,
                            Toast.LENGTH_SHORT
                    ).show();

                    Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                    intent.putExtra("bbb", "Promlert" );
                    startActivity(intent);

                }
                else{
                    //login ไม่สำเร็จ

                    new AlertDialog.Builder(LoginActivity.this).setTitle("Error").setMessage(R.string.Login_failed)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });
                            //AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this);
                            //dialog.setTitle("Error");
                            /*dialog.setMessage(R.string.Login_failed);
                            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    // โค้ดที่ให้ทำงาน เมื่อuser กดปุ่ม OK
                                    //todo;
                                }
                            });*/


                }



            }
        });
    }
}
