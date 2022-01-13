package com.example.q1_basicapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DigitalClock;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Date;
import java.time.Clock;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Button submit_bt;
    TextView name_tv;
    EditText name;
    RadioButton male,female;
    DigitalClock clock;
    Spinner city;
    StringBuffer add;

    String[] city_name={"Pune","Mumbai","Buldhana","Jalgaon","Nagpur"};




        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = (Spinner) findViewById(R.id.city);
        city.setOnItemSelectedListener(this);

            ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,city_name);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        city.setAdapter(aa);

        clock= (DigitalClock) findViewById(R.id.clock);


            }


    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        String select;
        select=city_name[position];
        StringBuffer addcity  = new StringBuffer();
        addcity.append("City :-");
        addcity.append(select);
        add=addcity;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //nothing
    }

    public void  register(View view)
    {
        name_tv=(TextView)findViewById(R.id.name_tv);//find id
        name=(EditText)findViewById(R.id.name);
        male=(RadioButton)findViewById(R.id.male);
        female=(RadioButton)findViewById(R.id.female);

        String getName=name.getText().toString();//to get value from editText

        StringBuffer info  = new StringBuffer();

        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if(timeOfDay >= 0 && timeOfDay < 12){
            info.append("Good Morning ");
        }else if(timeOfDay >= 12 && timeOfDay < 16){
            info.append("Good Afternoon ");
        }else if(timeOfDay >= 16 && timeOfDay < 21){
            info.append("Good Evening ");
        }else if(timeOfDay >= 21 && timeOfDay < 24){
            info.append("Good Night ");
        }
        info.append(getName);

        info.append("\nYour Information is :-\n");
        info.append("Name :- ");

        info.append(getName);

        if(male.isChecked()==true){
            info.append("\nGendar :- male \n");
        }
        if(female.isChecked()==true){
            info.append("\nGendar :- female \n");
        }

        StringBuffer total_msg=info.append(add);



        Toast.makeText(MainActivity.this,total_msg.toString(),Toast.LENGTH_SHORT).show();




    }

}