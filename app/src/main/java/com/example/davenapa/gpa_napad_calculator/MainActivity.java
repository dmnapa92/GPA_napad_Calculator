package com.example.davenapa.gpa_napad_calculator;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String str;

    Button calculateGPA;

    String t1;
    String t2;
    String t3;
    String t4;
    String t5;

    int g1;
    int g2;
    int g3;
    int g4;
    int g5;

    int sum;

    EditText grade1;
    EditText grade2;
    EditText grade3;
    EditText grade4;
    EditText grade5;

    TextView text1;

    ConstraintLayout cL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    calculateGPA = (Button) findViewById(R.id.button1);

    text1 = (TextView) findViewById(R.id.textView1);

    grade1 = (EditText) findViewById(R.id.editText1);
    grade2 = (EditText) findViewById(R.id.editText2);
    grade3 = (EditText) findViewById(R.id.editText3);
    grade4 = (EditText) findViewById(R.id.editText4);
    grade5 = (EditText) findViewById(R.id.editText5);

    calculateGPA.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!isEmpty(grade1)){
                t1 = grade1.getText().toString();
                g1 = Integer.parseInt(t1);

                sum = g1;
            }
            else{
                grade1.setError("Please enter an integer");
            }

            if(!isEmpty(grade2)){
                t2 = grade2.getText().toString();
                g2 = Integer.parseInt(t2);
                sum += g2;
            }
            else{
                grade2.setError("Please enter an integer");
            }

            if(!isEmpty(grade3)) {
                t3 = grade3.getText().toString();
                g3 = Integer.parseInt(t3);
                sum += g3;
            }
            else {
                grade3.setError("Please enter an integer");
            }

            if(!isEmpty(grade4)){
                t4 = grade4.getText().toString();
                g4 = Integer.parseInt(t4);
                sum += g4;
            }
            else {
                grade4.setError("Please enter an integer");
            }

            if(!isEmpty(grade5)){
                t5 = grade5.getText().toString();
                g5 = Integer.parseInt(t5);
                sum += g5;
            }
            else {
                grade5.setError("Please enter an integer");
            }

            double GPA = sum/5;

            if(GPA < 100) {

                str = "Your GPA is: ";
                str += Double.toString(GPA);

                text1.setText(str);
            }

            else{
                str = "Please enter an integer in between 0 and 100";
                text1.setText(str);
            }

            if(!isEmpty(grade1)) {
                calculateGPA.setText("Clear Form");
                grade1.getText().clear();
                grade2.getText().clear();
                grade3.getText().clear();
                grade4.getText().clear();
                grade5.getText().clear();
            }

            else
                calculateGPA.setText("Calculate GPA");

            cL = (ConstraintLayout) findViewById(R.id.main);

            if(GPA < 61){
                cL.setBackgroundColor(Color.RED);
            }

            else if(GPA > 60 && GPA < 80){
                cL.setBackgroundColor(Color.YELLOW);
            }

            else
                cL.setBackgroundColor(Color.GREEN);

        }
    });
    }
    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();

        return TextUtils.isEmpty(str);
    }
}
