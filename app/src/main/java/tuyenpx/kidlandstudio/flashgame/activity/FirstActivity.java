package tuyenpx.kidlandstudio.flashgame.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tuyenpx.kidlandstudio.flashgame.R;
import tuyenpx.kidlandstudio.flashgame.util.Util;

/**
 * Created by tuyenpx on 07/09/2016.
 */
public class FirstActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_first_activity);
        Button mHiragana = (Button) findViewById(R.id.btn_hiragana);
        mHiragana.setOnClickListener(this);
        Button mKatakana = (Button) findViewById(R.id.btn_katakana);
        mKatakana.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_hiragana:
                Util.isHiRaGaNa = true;
                startActivity(new Intent(getBaseContext(), SelectionTestAcivity.class));
                finish();
                break;
            case R.id.btn_katakana:
                Util.isHiRaGaNa = false;
                startActivity(new Intent(getBaseContext(), SelectionTestAcivity.class));
                finish();
                break;
        }
    }
}
