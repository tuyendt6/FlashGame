package tuyenpx.kidlandstudio.flashgame.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import tuyenpx.kidlandstudio.flashgame.R;

/**
 * Created by tuyenpx on 07/09/2016.
 */
public class SelectionTestAcivity extends Activity {


    private CheckBox cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10, cb11, cb12, cb13, cb14, cb15, cb16, cb17, cb18, cb19;
    private Button mOk;
    public static final String QUESTION = "question";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_selection_activity);
        cb1 = (CheckBox) findViewById(R.id.rd1);
        cb2 = (CheckBox) findViewById(R.id.rd2);
        cb3 = (CheckBox) findViewById(R.id.rd3);
        cb4 = (CheckBox) findViewById(R.id.rd4);
        cb5 = (CheckBox) findViewById(R.id.rd5);
        cb6 = (CheckBox) findViewById(R.id.rd6);
        cb7 = (CheckBox) findViewById(R.id.rd7);
        cb8 = (CheckBox) findViewById(R.id.rd8);
        cb9 = (CheckBox) findViewById(R.id.rd9);
        cb10 = (CheckBox) findViewById(R.id.rd10);
        cb11 = (CheckBox) findViewById(R.id.r11);
        cb12 = (CheckBox) findViewById(R.id.r12);
        cb13 = (CheckBox) findViewById(R.id.r13);
        cb14 = (CheckBox) findViewById(R.id.r14);
        cb15 = (CheckBox) findViewById(R.id.r15);
        cb16 = (CheckBox) findViewById(R.id.r16);
        cb17 = (CheckBox) findViewById(R.id.r17);
        cb18 = (CheckBox) findViewById(R.id.r19);
        cb19 = (CheckBox) findViewById(R.id.r20);

        mOk = (Button) findViewById(R.id.btn_ok);
        mOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(cb1.isChecked() || cb2.isChecked()
                        || cb3.isChecked() || cb4.isChecked()
                        || cb5.isChecked() || cb6.isChecked()
                        || cb7.isChecked() || cb8.isChecked()
                        || cb9.isChecked() || cb10.isChecked()
                        || cb11.isChecked() || cb12.isChecked()
                        || cb13.isChecked() || cb14.isChecked()
                        || cb15.isChecked() || cb16.isChecked()
                        || cb17.isChecked() || cb18.isChecked() || cb19.isChecked())) {
                    Toast.makeText(getBaseContext(), " Must select item to start ... ", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                i.putExtra(QUESTION, cb1.isChecked() + ";" + cb2.isChecked() + ";" + cb3.isChecked() + ";" + cb4.isChecked() + ";" + cb5.isChecked() + ";" +
                        cb6.isChecked() + ";" + cb7.isChecked() + ";" + cb8.isChecked() + ";" + cb9.isChecked() + ";" + cb10.isChecked() + ";" + cb11.isChecked() + ";" +
                        cb12.isChecked() + ";" + cb13.isChecked() + ";" + cb14.isChecked() + ";" + cb15.isChecked() + ";" + cb16.isChecked() + ";" + cb17.isChecked() + ";" +
                        cb18.isChecked() + ";" + cb19.isChecked() + ";");
                startActivity(i);
                finish();
            }
        });
    }

}
