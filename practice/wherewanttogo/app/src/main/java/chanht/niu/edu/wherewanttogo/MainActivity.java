package chanht.niu.edu.wherewanttogo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView wv;
    Spinner sp;
    CheckBox cb;
    String[] web={"Google","Yahoo","NIU"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wv = (WebView)findViewById(R.id.webview);
        sp = (Spinner)findViewById(R.id.spinner);
        cb = (CheckBox)findViewById(R.id.checkBox2);
        //default setting
        sp.setEnabled(false);
        cb.setSelected(false);
        wv.setVisibility(View.INVISIBLE);
        //checkbox setting
        cb.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(cb.isChecked()){
                    sp.setEnabled(true);
                    wv.setVisibility(View.VISIBLE);
                }
                else{
                    sp.setEnabled(false);
                    wv.setVisibility(View.INVISIBLE);
                }
            }
        });
        //spinner setting
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, web);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {
                //彈跳對話框
                Toast.makeText(MainActivity.this, "Your choice is "+web[arg2], Toast.LENGTH_SHORT).show();
                //choice
                if(web[arg2]=="Google"){
                    wv.setWebViewClient(new WebViewClient());
                    wv.loadUrl("http://www.google.com");
                }
                else if(web[arg2]=="Yahoo"){
                    wv.setWebViewClient(new WebViewClient());
                    wv.loadUrl("http://www.yahoo.com.tw");
                }
                else if(web[arg2]=="NIU"){
                    wv.setWebViewClient(new WebViewClient());
                    wv.loadUrl("https://www.niu.edu.tw/bin/home.php");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
