package com.example.sandeep.codelearntwitterapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button _loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final SharedPreferences prefs = getSharedPreferences("codelearntwitter",MODE_PRIVATE);
        String savedUserName = prefs.getString("username", null);
        String savedPwd = prefs.getString("password",null);

        if(savedUserName != null && savedPwd !=null){
            Intent intent = new Intent(getApplicationContext(),TweetListActivity.class);
            startActivity(intent);
            finish();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _loginBtn = (Button) findViewById(R.id.btn_login);


        _loginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //_loginBtn.setText("Iam Clicked..");
                EditText username = (EditText) findViewById(R.id.fld_username);
                String usernameValue = username.getText().toString();

                EditText pwd = (EditText) findViewById(R.id.fld_pwd);
                String pwdValue = pwd.getText().toString();

                //Log.d("CodeLearn", "UserName is" + usernameValue);
                //Log.d("CodeLearn","Password is"+ pwdValue);

                SharedPreferences.Editor editor = prefs.edit();

                editor.putString("username", usernameValue);
                editor.putString("password", pwdValue);

                editor.commit();

                String stored = prefs.getString("username",null) + " " +prefs.getString("password",null);

                Log.d("CodeLearnShared",stored);

                Intent intent = new Intent(getApplicationContext(),TweetListActivity.class);
                startActivity(intent);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
