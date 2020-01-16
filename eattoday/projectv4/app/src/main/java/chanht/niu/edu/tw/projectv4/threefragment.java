package chanht.niu.edu.tw.projectv4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import java.text.DecimalFormat;

public class threefragment extends Fragment {
    private EditText etheight;
    private EditText etweight;
    private RadioButton rb1;
    private RadioButton rb2;
    private Button b1;
    private TextView textView,textView2;

    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_three,container,false);
        b1 = (Button) view.findViewById(R.id.button1);
        etheight = view.findViewById(R.id.editText);
        etweight = (EditText) view.findViewById(R.id.editText2);
        rb1 =(RadioButton) view.findViewById(R.id.radioButton);
        rb2 =(RadioButton) view.findViewById(R.id.radioButton2);
        textView = (TextView) view.findViewById(R.id.textView5);
        textView2 = view.findViewById(R.id.textView6);

        b1.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v)
            {
                DecimalFormat nf = new DecimalFormat("0.00");
                double height = Double.parseDouble(etheight.getText().toString());
                double weight = Double.parseDouble(etweight.getText().toString());
                String sex = rb1.isChecked() ? "M" : "F";
                double bmi_max=0.0;
                double bmi_min=0.0;
                //計算出BMI值
                double BMI = weight / (height*height);
                if(sex.equals("M")){
                    bmi_max=25.0;
                    bmi_min=20.0;
                    if(BMI>bmi_max){
                        textView.setText("Your BMI is : "+nf.format(BMI));
                        textView2.setText("Your should eat less!!");
                    }else if(BMI<bmi_min){
                        textView.setText("Your BMI is : "+nf.format(BMI));
                        textView2.setText("Your should eat more!!");
                    }else{
                        textView.setText("Your BMI is : "+nf.format(BMI));
                        textView2.setText("Your body shape is nice!!");
                    }
                }else{
                    bmi_max = 22.0;
                    bmi_min = 18.0;
                    if(BMI>bmi_max){
                        textView.setText("Your BMI is : "+nf.format(BMI));
                        textView2.setText("Your should eat less!!");
                    }else if(BMI<bmi_min){
                        textView.setText("Your BMI is : "+nf.format(BMI));
                        textView2.setText("Your should eat more!!");
                    }else{
                        textView.setText("Your BMI is : "+nf.format(BMI));
                        textView2.setText("Your body shape is nice!!");
                    }
                }
            }
        });
        return view;
    }
}
