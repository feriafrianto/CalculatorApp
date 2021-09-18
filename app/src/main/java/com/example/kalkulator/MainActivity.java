package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import com.faendir.rhino_android.RhinoAndroidHelper;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    TextView txtHasil, txtHitungan;
    String process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHasil = (TextView) findViewById(R.id.txtHasil);
        txtHitungan = (TextView) findViewById(R.id.txtHitungan);
    }

    public void btnClear(View view) {
        txtHitungan.setText("");
        txtHasil.setText("");
    }
    public void btnEraser(View view) {
        txtHasil.setText("0");
        process = txtHitungan.getText().toString();
        int lenght = process.length();
        txtHitungan.setText(process.substring(0,lenght-1));
    }

    public void btn0(View view) {
        process = txtHitungan.getText().toString();
        txtHitungan.setText(process + "0");
    }

    public void btn1(View view) {
        process = txtHitungan.getText().toString();
        txtHitungan.setText(process + "1");
    }

    public void btn2(View view) {
        process = txtHitungan.getText().toString();
        txtHitungan.setText(process + "2");
    }

    public void btn3(View view) {
        process = txtHitungan.getText().toString();
        txtHitungan.setText(process + "3");
    }

    public void btn4(View view) {
        process = txtHitungan.getText().toString();
        txtHitungan.setText(process + "4");
    }

    public void btn5(View view) {
        process = txtHitungan.getText().toString();
        txtHitungan.setText(process + "5");
    }

    public void btn6(View view) {
        process = txtHitungan.getText().toString();
        txtHitungan.setText(process + "6");
    }

    public void btn7(View view) {
        process = txtHitungan.getText().toString();
        txtHitungan.setText(process + "7");
    }

    public void btn8(View view) {
        process = txtHitungan.getText().toString();
        txtHitungan.setText(process + "8");
    }

    public void btn9(View view) {
        process = txtHitungan.getText().toString();
        txtHitungan.setText(process + "9");
    }

    public void btnTitik(View view) {
        process = txtHitungan.getText().toString();
        txtHitungan.setText(process + ".");
    }

    public void btnPlus(View view) {
        process = txtHitungan.getText().toString();
        txtHitungan.setText(process + " + ");
    }

    public void btnMinus(View view) {
        process = txtHitungan.getText().toString();
        txtHitungan.setText(process + " - ");
    }

    public void btnBagi(View view) {
        process = txtHitungan.getText().toString();
        txtHitungan.setText(process + " / ");
    }

    public void btnKali(View view) {
        process = txtHitungan.getText().toString();
        txtHitungan.setText(process + " x ");
    }

    public void btnPercent(View view) {
        process = txtHitungan.getText().toString();
        txtHitungan.setText(process + "%");
    }

    public void btnSamaDengan(View view) {
        process = txtHitungan.getText().toString();

        process = process.replaceAll("x", "*");
        process = process.replaceAll("%", "/100");

        Context rhino = Context.enter();

        rhino.setOptimizationLevel(-1);

        String finalResult = "";

        try {
            Scriptable scriptable = rhino.initStandardObjects();
            finalResult = rhino.evaluateString(scriptable, process, "javascript", 1, null).toString();
        } catch (Exception e) {
            finalResult = "0";
        }

        txtHasil.setText(finalResult);
    }


}