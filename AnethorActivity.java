package com.example.laxman.bmi_menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AnethorActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText_weight;
    EditText editText_height;
    Button button_calbmi;
    TextView textView_bmi;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anethor);
        editText_weight=findViewById(R.id.editText_weight);
        editText_height=findViewById(R.id.editText_height);
        button_calbmi=findViewById(R.id.button_calbmi);
        textView_bmi=findViewById(R.id.textView_bmi);
        editText=findViewById(R.id.editText);
        button_calbmi.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String weightstr=editText_weight.getText().toString();
        String heightstr=editText_height.getText().toString();
        if ((heightstr!=null&&!"".equals(heightstr))&&(weightstr!=null&&!"".equals(weightstr))){
            Float heightvalue=Float.parseFloat(heightstr)/100;
            Float weightvalue=Float.parseFloat(weightstr);
            Float bmi=weightvalue/(heightvalue*heightvalue);
            displayBMI(bmi);
        }


    }

    private void displayBMI(Float bmi) {
        String bmilabel="";
        if (Float.compare(bmi,15f)<=0){
            bmilabel=getString(R.string.very_severely_underweight);
        }else if (Float.compare(bmi,15f)>0&&Float.compare(bmi,16f)<=0){
            bmilabel=getString(R.string.severely_underweight);
        }else if (Float.compare(bmi,16f)>0&&Float.compare(bmi,18.5f)<=0){
            bmilabel=getString(R.string.underweight);
        }else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0){
            bmilabel=getString(R.string.normal);
        }else if (Float.compare(bmi,25f)>0&&Float.compare(bmi,30f)<=0){
            bmilabel=getString(R.string.overweight);
        }else if (Float.compare(bmi,30f)>0&&Float.compare(bmi,35f)<=0){
            bmilabel=getString(R.string.obese_class_i);
        }else if (Float.compare(bmi,35f)>0&&Float.compare(bmi,40f)<=0){
            bmilabel=getString(R.string.obese_class_ii);
        }else{
            bmilabel=getString(R.string.obese_class_iii);
        }
        bmilabel="\n"+bmi+"\n"+bmilabel;
        textView_bmi.setText(bmilabel);

    }


}
