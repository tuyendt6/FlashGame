package tuyenpx.kidlandstudio.flashgame.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import tuyenpx.kidlandstudio.flashgame.R;
import tuyenpx.kidlandstudio.flashgame.util.Util;

/**
 * Created by tuyenpx on 15/09/2016.
 */
public class FinishActivity extends Activity {
    private Button mGo;
    private TextView mValue;
    private TextView mTitle;
    private TextView mPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);
        mGo = (Button) findViewById(R.id.btn_go);
        mValue = (TextView) findViewById(R.id.value);
        mTitle = (TextView) findViewById(R.id.txt_title);
        mPercent = (TextView) findViewById(R.id.textView7);
        if (Util.isHiRaGaNa) {
            mTitle.setText("HIRAGANA");
        } else {
            mTitle.setText("KATAKANA");
        }
        mGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), FirstActivity.class));
                finish();
            }
        });
        String value = getIntent().getStringExtra("value");
        if (!TextUtils.isEmpty(value)) {
            mValue.setText(value);
            String[] s = value.split("/");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int percent = a * 100 / b;
            if (percent >= 50 && percent < 70) {
                mPercent.setText("Good");
            } else if (percent >= 70 && percent < 100) {
                mPercent.setText("Very Good");
            } else if (percent == 100) {
                mPercent.setText("Well done");
            }
        }
    }
}
