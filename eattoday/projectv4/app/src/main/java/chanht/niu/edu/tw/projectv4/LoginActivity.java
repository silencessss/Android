package chanht.niu.edu.tw.projectv4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private Button mlogin;
    private EditText eduserid = findViewById(R.id.inputaccount);
    private EditText edpassword = findViewById(R.id.inputpassword);

    private String uid = eduserid.getText().toString();
    private String pw = edpassword.getText().toString();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton();


    }
    public void LoginButton(){

       //pt.setText(Integer.toString(attempt_counter));
        mlogin = findViewById(R.id.buttonlogin);

        mlogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (uid.equals("user") && pw.equals("pass")){
                            Toast.makeText(LoginActivity.this,"Username and password is correct",
                                    Toast.LENGTH_SHORT).show();
                            finish();
                            //Intent intent = new Intent("com.abhinavhackpundit.loginapp.User");
                            //startActivity(intent);

                        }
                        else {
                            Toast.makeText(LoginActivity.this,"Username and password is NOT correct",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }
    /*
    public void login(View v){
        EditText eduserid = findViewById(R.id.inputaccount);
        EditText edpassword = findViewById(R.id.inputpassword);
        String uid = eduserid.getText().toString();
        String pw = edpassword.getText().toString();
        if(uid.equals("chan") && pw.equals("1234")){
            Toast.makeText(this,"Login success!",Toast.LENGTH_LONG).show();
            finish();
        }else{
            new AlertDialog.Builder(this)
                    .setTitle("test")
                    .setMessage("Login fail!")
                    .setPositiveButton("OK",null)
                    .show();
        }
    }*/

}