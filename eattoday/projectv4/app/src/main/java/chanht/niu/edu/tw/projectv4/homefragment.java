package chanht.niu.edu.tw.projectv4;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;


public class homefragment extends Fragment {
    private EditText mbreakfirst,mlunch,mdinner;
    private Button maddsure;
    private String[] moods = {"","Happy","Upset","Annoyed"};
    private TextView mmood;
    private Spinner mspinner;

    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_one,container,false);
        mbreakfirst = view.findViewById(R.id.breakfirstinput);
        mlunch = view.findViewById(R.id.lunchinput);
        mdinner = view.findViewById(R.id.dinnerinput);
        maddsure = view.findViewById(R.id.addfinish);
        mmood = view.findViewById(R.id.textmood);
        mspinner = view.findViewById(R.id.spinner);
        final Date mdate = new Date();

        maddsure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference Ref = database.getReference("Date");
                Ref.setValue(mdate.getTime());

                DatabaseReference myRef = database.getReference("breakfirst");
                myRef.setValue(mbreakfirst.getText().toString());

                DatabaseReference myRef2 = database.getReference("lunch");
                myRef2.setValue(mlunch.getText().toString());

                DatabaseReference myRef3 = database.getReference("dinner");
                myRef3.setValue(mdinner.getText().toString());
            }
        });
        /*
        String[] moods = getResources().getStringArray(R.array.moodarray);

        int idmoods = mspinner.getSelectedItemPosition();
    */
        /*
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String >(getActivity(),R.layout.myspinner,moods);
        mspinner.setAdapter(arrayAdapter);

        mspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String msg="";
                if(position==0){
                    mmood.setText(msg);
                }else{
                    msg+=moods[position];
                    mmood.setText(msg);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        */
        return view;
    }
}
