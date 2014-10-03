package com.example.jamesreilly.simplecalc;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Stack;


public class Calculator extends Activity {

    private String displayFunction = "";
    private String myInt = "";
    private String operators = "+ - * / ^";
    private String strAnswer = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        ActionBar actionBar = getActionBar();
        actionBar.hide();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calculator, menu);
        return true;
    }
    public void onButtonClick(View v) {
        // previously invisible view



        switch (v.getId()) {
            case R.id.imageButton0:
                myInt += "0";
                displayFunction += "0";
                break;
            case R.id.imageButton1:
                myInt += "1";
                displayFunction += "1";
                break;
            case R.id.imageButton2:
                myInt += "2";
                displayFunction += "2";
                break;
            case R.id.imageButton3:
                myInt += "3";
                displayFunction += "3";
                break;
            case R.id.imageButton4:
                myInt += "4";
                displayFunction += "4";
                break;
            case R.id.imageButton5:
                myInt += "5";
                displayFunction += "5";
                break;
            case R.id.imageButton6:
                myInt += "6";
                displayFunction += "6";
                break;
            case R.id.imageButton7:
                myInt += "7";
                displayFunction += "7";
                break;
            case R.id.imageButton8:
                myInt += "8";
                displayFunction += "8";
                break;
            case R.id.imageButton9:
                myInt += "9";
                displayFunction += "9";
                break;
            case R.id.imageButtonminus:

                if(displayFunction.isEmpty()){
                    myInt += "-";
                }
                else {
                    boolean p = displayFunction.charAt(displayFunction.length() - 1) == '+';
                    System.out.println(p);
                    boolean m = displayFunction.charAt(displayFunction.length() - 1) == '-';
                    boolean d = displayFunction.charAt(displayFunction.length() - 1) == '/';
                    boolean t = displayFunction.charAt(displayFunction.length() - 1) == 'x';
                    boolean pw = displayFunction.charAt(displayFunction.length() - 1) == '^';
                    if (p || m || d || t || pw){
                        myInt += "-";
                    }
                    else{
                        myInt += " - ";
                    }
                }


                displayFunction += "-";
                break;
            case R.id.imageButtonMult:
                myInt += " * ";
                displayFunction += "x";
                break;
            case R.id.imageButtonDiv:
                myInt += " / ";
                displayFunction += "/";
                break;
            case R.id.imageButtonplus:
                myInt += " + ";
                displayFunction += "+";

                break;
            case R.id.imageButtonOpen:
                myInt += " ( ";
                displayFunction +="(";
                break;
            case R.id.imageButtonClose:
                myInt += " ) ";
                displayFunction +=")";
                break;
            case R.id.imageButtonPow:
                myInt += " ^ ";
                displayFunction +="^";
                break;
            case R.id.imageButtonTBA:
                myInt+= ".";
                displayFunction+=".";
                break;
            case R.id.imageButtoneq:


                LinkedList<String> postfix = shuntingYard.prefix(myInt);
                Stack<Float> answer= new Stack<Float>();
                try {
                    while (!postfix.isEmpty()) {
                        String current = postfix.remove();
                        if (operators.contains(current)) {
                            Float right = answer.pop();
                            Float left = answer.pop();
                            switch (current.charAt(0)) {
                                case '+':
                                    answer.push(left + right);
                                    break;
                                case '-':
                                    answer.push(left - right);
                                    break;
                                case '*':
                                    answer.push(left * right);
                                    break;
                                case '/':
                                    answer.push(left / right);
                                    break;
                                case '^':
                                    answer.push((float) Math.pow(left,right));

                            }
                        } else {
                            answer.push(Float.parseFloat(current));
                        }
                    }
                    strAnswer = answer.pop().toString();
                } catch(Exception e){
                    strAnswer = "ERROR";
                }
                finally {
                    //Floating Point Check
                    int decimal = strAnswer.indexOf(".");
                    if (strAnswer.charAt(decimal + 1) == '0'){
                        if(decimal + 1 == strAnswer.length()-1){
                            strAnswer = strAnswer.substring(0,decimal);
                        }
                    }
                    displayFunction=strAnswer;
                    if (strAnswer.equals("ERROR")){
                        myInt = "";
                    }
                    else{

                        myInt = strAnswer;
                    }

                }

                break;
            case R.id.imageButtonClr:
                displayFunction = "";
                myInt="";

                break;

        }
        TextView myTextView = (TextView)
                findViewById(R.id.textView);
        myTextView.setText(displayFunction);
    }






    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
