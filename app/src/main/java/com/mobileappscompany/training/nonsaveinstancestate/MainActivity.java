package com.mobileappscompany.training.nonsaveinstancestate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText eT;
    TextView tV;
    MyClass mC = new MyClass();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eT = (EditText) findViewById(R.id.editText);
        tV = (TextView) findViewById(R.id.textView);
        if(savedInstanceState==null) return;
        mC = (MyClass) savedInstanceState.getParcelable("K");
        tV.setText(mC.getString());
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("K", mC);
    }
    public void onClick(View view) {
        mC.setString(eT.getText().toString());
        tV.setText(eT.getText().toString());
    }
}
