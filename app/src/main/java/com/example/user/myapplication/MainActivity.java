package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mEdtSex, mEdtAge;
    private Button mBtnOK;
    private TextView mTxtR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtSex = (EditText) findViewById(R.id.edtSex);
        mEdtAge = findViewById(R.id.edtAge);
        mBtnOK = findViewById(R.id.btnOK);
        mTxtR = findViewById(R.id.txtR);

        mBtnOK.setOnClickListener(btnOKOnCLick);
    }

    private View.OnClickListener btnOKOnCLick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String strSex = mEdtSex.getText().toString();
            int iAge = Integer.parseInt(mEdtAge.getText().toString());

            String strSug = getString(R.string.suggestion);
            if(strSex.equals(getString(R.string.sex_male)))
                if(iAge < 30)
                    strSug = getString(R.string.sug_not_hurry);
                else if (iAge > 35)
                    strSug = getString(R.string.sug_get_married);
                else
                    strSug = getString(R.string.sug_find_couple);
            else
                if(iAge < 28)
                    strSug = getString(R.string.sug_not_hurry);
                else if (iAge > 32)
                    strSug = getString(R.string.sug_get_married);
                else
                    strSug = getString(R.string.sug_find_couple);

            mTxtR.setText(strSug);
        }
    };
}
