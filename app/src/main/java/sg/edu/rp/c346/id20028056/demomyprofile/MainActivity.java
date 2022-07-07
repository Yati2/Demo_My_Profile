package sg.edu.rp.c346.id20028056.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etName,etGPA;
    RadioGroup rgGender;
    RadioButton rbM,rbF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName=findViewById(R.id.etName);
        etGPA=findViewById(R.id.etGPA);
        rgGender=findViewById(R.id.rgGender);
        rbF=findViewById(R.id.rbF);
        rbM=findViewById(R.id.rbM);

    }

    @Override
    protected void onPause() {
        super.onPause();
        String name=etName.getText().toString();
        int genderID=rgGender.getCheckedRadioButtonId();
        Float gpa=Float.parseFloat(etGPA.getText().toString());
        SharedPreferences pref=getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit=pref.edit();
        prefEdit.putString("name",name);
        prefEdit.putInt("gender",genderID);
        prefEdit.putFloat("gpa",gpa);
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs=getPreferences((MODE_PRIVATE));
        String name=prefs.getString("name","NIA");
        Float gpa=prefs.getFloat("gpa",0);
        int genderID=prefs.getInt("gender",rbM.getId());
        rgGender.check(genderID);
        etGPA.setText(gpa.toString());
        etName.setText(name);

    }
}