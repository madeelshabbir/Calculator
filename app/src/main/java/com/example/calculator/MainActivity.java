package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity<pubic> extends AppCompatActivity {
    private String val;
    private double num1;
    private double num2;
    private boolean turn = false;
    private char perform;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.val = "0";
        this.num1 = 0;
        this.num2 = 0;
        this.perform = '#';
    }
    private void reset(){
        this.val = "0";
        this.turn = false;
        this.num1 = 0;
        this.num2 = 0;
        this.perform = '#';
    }
    private void ModifyView(String s){
        if(this.val.equals("0") || this.val.indexOf(".") != -1)
            this.val = "";
        TextView textView = findViewById(R.id.textView2);
        textView.setText(this.val += s);
    }
    private boolean performOperation(){
        if(this.perform == '+')
            num1 += num2;
        else if(this.perform == '-')
            num1 -= num2;
        else if(this.perform == '*')
            num1 *= num2;
        else if(this.perform == '/'){
            if(num2 == 0)
                return false;
            num1 /= num2;
        }
        val = String.valueOf(num1);
        return true;
    }
    private void ModifyN(){
        if(this.turn)
            this.num2 = Double.parseDouble(this.val);
        else
            this.num1 = Double.parseDouble(this.val);
        this.turn = true;
        this.val = "0";
    }
    private void undef(){
        TextView textView = findViewById(R.id.textView2);
        textView.setText("Undefined");
        this.reset();
    }
    private void showVal(){
        TextView textView = findViewById(R.id.textView2);
        textView.setText(this.val);
    }
    public void ShowResult(View view) {
        this.ModifyView("1");
    }
    public void ShowResult1(View view) {
        this.ModifyView("2");
    }
    public void ShowResult2(View view) {
        this.ModifyView("3");
    }
    public void ShowResult3(View view) {
        this.ModifyView("4");
    }
    public void ShowResult4(View view) {
        this.ModifyView("5");
    }
    public void ShowResult5(View view) {
        this.ModifyView("6");
    }
    public void ShowResult6(View view) {
        this.ModifyView("7");
    }
    public void ShowResult7(View view) {
        this.ModifyView("8");
    }
    public void ShowResult8(View view) {
        this.ModifyView("9");
    }
    public void ShowResult9(View view) {
        this.ModifyView("0");
    }
    public void backSpace(View view){
        if(this.val.length() <= 1)
            this.val = "0";
        else
            this.val = this.val.substring(0, this.val.length() - 1);
        this.showVal();
    }
    public void clear(View view){
        this.reset();
        this.showVal();
    }
    public void add(View view){
        this.ModifyN();
        if(this.perform != '#') {
            if(!performOperation()){
                undef();
                return;
            }
            showVal();
        }
        this.perform = '+';
    }
    public void subtract(View view){
        this.ModifyN();
        if(this.perform != '#') {
            if(!performOperation()){
                undef();
                return;
            }
            showVal();
        }
        this.perform = '-';
    }
    public void multiply(View view){
        this.ModifyN();
        if(this.perform != '#') {
            if(!performOperation()){
                undef();
                return;
            }
            showVal();
        }
        this.perform = '*';
    }
    public void divide(View view){
        this.ModifyN();
        if(this.perform != '#') {
            if(!performOperation()){
                undef();
                return;
            }
            showVal();
        }
        this.perform = '/';
    }
    public void eql(View view){
        this.ModifyN();
        if(this.perform != '#') {
            if(!performOperation()){
                undef();
                return;
            }
            showVal();
        }
        this.reset();
    }
}