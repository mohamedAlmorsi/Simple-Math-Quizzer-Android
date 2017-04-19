package com.example.mohamedalshaer.mathquizzer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private  char[] operators = {'+','-' , 'X','%'};

    private int current_points =0;
    private int current_answer=0; ;
    private char operator ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main)
        ;
        update_problem();
        update_points();

    }
    private String createProblem( ){

        int first_operand = ((int)(Math.random()*191))+1;
        int second_operand = ((int)(Math.random()*640))+1;
        int position = (int)(Math.random()*3) ;
         operator =operators[position];
        String problem ;

        switch (operator){
            case '+': current_answer = (first_operand) + (second_operand);
                  problem =  first_operand + " " +  operator+ " " +  second_operand ;
                return problem ;
            case '-': current_answer = (first_operand) - (second_operand);
                 problem =  first_operand + " " +  operator+ " " +  second_operand ;
                return problem ;
            case 'X': current_answer = (first_operand) * (second_operand);
                problem =  first_operand + " " +  operator+ " " +  second_operand ;
                return problem ;
            case '%': current_answer = (first_operand) % (second_operand);
                 problem =  first_operand + " " +  operator+ " " +  second_operand ;
                return problem ;
            default: current_answer = current_answer;
                  problem =  first_operand + " " +  operator+ " " +  second_operand ;
                return problem ;
        }

    }

    private boolean checkAnswer(String s ){
        if( Integer.parseInt(s) == current_answer){
            return  true;
        }
        else {
            return  false ;
        }
    }
    public void onSubmitClick(View view) {
        EditText user_answer = (EditText) findViewById(R.id.editText);
        String answer = user_answer.getText().toString();
        if(checkAnswer(answer)){
            current_points++;

            update_points();
            update_problem();
        }
        else {
            current_points--;
            update_points();
            Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show();
        }

    }

    private void update_points(){
        TextView points = (TextView) findViewById(R.id.textView_score);
            points.setText("Current points : "+Integer.toString(current_points));
    }
    private void update_problem(){
        TextView problem = (TextView) findViewById(R.id.textView_problem);
        problem.setText(createProblem());

    }




}
