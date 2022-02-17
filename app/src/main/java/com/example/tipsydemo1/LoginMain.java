package com.example.tipsydemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class LoginMain extends AppCompatActivity {

    TextInputEditText TextInputEditText_email, TextInputEditText_password;
    Button Button_login;

    //임의로 값지정
    String emailOK = "123@gmail.com";
    String passwordOK = "123";
    String inputEmail = "";
    String inputPassword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);

        TextInputEditText_email = findViewById(R.id.TextInputEditText_email);
        TextInputEditText_password = findViewById(R.id.TextInputEditText_password);
        Button_login = findViewById(R.id.Button_login);

        Button_login.setClickable(false); //버튼을 클릭안되게 설정
        //email 텍스트 칸에 타입했을때
        TextInputEditText_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence != null){
                    inputEmail=charSequence.toString();
                    Button_login.setClickable(validation()); //값이 맞으면 클릭가능해지게
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        //password 텍스트 칸에 타입했을때
        TextInputEditText_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence != null){
                    inputPassword=charSequence.toString();
                    Button_login.setClickable(validation()); //값이 맞으면 클릭가능해지게
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        //로그인 버튼 클릭되었을때
        Button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = TextInputEditText_email.getText().toString();
                String password = TextInputEditText_password.getText().toString();

                //값넘겨주기 LoginResultActivity로 넘겨주기
                Intent intent = new Intent(LoginMain.this, LoginResultActivity.class);
                intent.putExtra("email",email);
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });
    }

    //email이랑 password가 맞을때 (비교)
    public boolean validation(){
        return inputEmail.equals(emailOK) && inputPassword.equals(passwordOK);
    }
}