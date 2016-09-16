package tuyenpx.kidlandstudio.flashgame.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import tuyenpx.kidlandstudio.flashgame.R;
import tuyenpx.kidlandstudio.flashgame.object.AlPhaBe;
import tuyenpx.kidlandstudio.flashgame.util.Util;

public class MainActivity extends AppCompatActivity {

    private ArrayList<AlPhaBe> mHiragana = new ArrayList<>();
    private ArrayList<AlPhaBe> mkatakana = new ArrayList<>();
    private TextView mScore;
    private TextView mTvQuestion;

    private Button mSubmit;

    private AlPhaBe mQuestion;
    private int question_count = 0;
    private TextView mAnwser;
    private int correct = 0;
    private TextView text_result;
    private TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edPwd = (EditText) findViewById(R.id.edt_anwser);
        edPwd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                return false;
            }
        });


        edPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() == mQuestion.getmValue().length()) {
                    View view = MainActivity.this.getCurrentFocus();
                    if (view != null) {
                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        String question = getIntent().getStringExtra(SelectionTestAcivity.QUESTION);
        String[] s = question.split(";");
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("true")) {
                initData(i, Util.isHiRaGaNa);
            }
        }
        mScore = (TextView) findViewById(R.id.txt_score);
        mTvQuestion = (TextView) findViewById(R.id.question);
        mTitle = (TextView) findViewById(R.id.txt_title);
        if (Util.isHiRaGaNa) {
            question_count = mHiragana.size();
            Random random = new Random();
            int select = random.nextInt(mHiragana.size());
            mQuestion = mHiragana.get(select);
            mHiragana.remove(select);
            mScore.setText("0/" + question_count);
            mTvQuestion.setText(mQuestion.getmKey());
            mTitle.setText("HIRAGANA");
        } else {
            question_count = mkatakana.size();
            mScore.setText("0/" + mkatakana.size());
            Random random = new Random();
            int select = random.nextInt(mkatakana.size());
            mQuestion = mkatakana.get(select);
            mkatakana.remove(select);
            mScore.setText("0/" + question_count);
            mTvQuestion.setText(mQuestion.getmKey());
            mTitle.setText("KATAKANA");
        }
        text_result = (TextView) findViewById(R.id.text_result);
        mAnwser = (TextView) findViewById(R.id.edt_anwser);
        mSubmit = (Button) findViewById(R.id.btn_go);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = mAnwser.getText().toString();
                String result = "";
                if (!TextUtils.isEmpty(answer)) {
                    if (answer.equals(mQuestion.getmValue())) {
                        correct++;
                        text_result.setVisibility(View.VISIBLE);
                        result = "Right";
                        mScore.setText(correct + "/" + question_count);
                    } else {
                        text_result.setVisibility(View.VISIBLE);
                        result = "Wrong";
                    }
                    Animation anim = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fadeout);
                    text_result.setText(result);
                    text_result.startAnimation(anim);
                    anim.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            mTvQuestion.setText("");
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            text_result.setVisibility(View.GONE);
                            if (!nextQuestion()) {
                                Intent i = new Intent(getBaseContext(), FinishActivity.class);
                                i.putExtra("value", mScore.getText().toString());
                                startActivity(i);
                                finish();
                            }
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                }
            }
        });
    }

    private boolean nextQuestion() {
        if (Util.isHiRaGaNa) {
            if (mHiragana.size() > 0) {
                Animation anim = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fadein);
                mTvQuestion.startAnimation(anim);
                Random random = new Random();
                int select = random.nextInt(mHiragana.size());
                mQuestion = mHiragana.get(select);
                mHiragana.remove(select);
                text_result.setVisibility(View.GONE);
                mTvQuestion.setText(mQuestion.getmKey());
                mAnwser.setText("");
                return true;
            }
        } else {
            if (mkatakana.size() > 0) {
                Animation anim = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fadein);
                mTvQuestion.startAnimation(anim);
                Random random = new Random();
                int select = random.nextInt(mkatakana.size());
                mQuestion = mkatakana.get(select);
                mkatakana.remove(select);
                text_result.setVisibility(View.GONE);
                mTvQuestion.setText(mQuestion.getmKey());
                mAnwser.setText("");
                return true;
            }
        }
        return false;
    }

    private void initData(int i, boolean isHiragana) {
        switch (i) {
            case 0:
                initR1(isHiragana);
                break;
            case 1:
                initR2(isHiragana);
                break;
            case 2:
                initR3(isHiragana);
                break;
            case 3:
                initR4(isHiragana);
                break;
            case 4:
                initR5(isHiragana);
                break;
            case 5:
                initR6(isHiragana);
                break;
            case 6:
                initR7(isHiragana);
                break;
            case 7:
                initR8(isHiragana);
                break;
            case 8:
                initR9(isHiragana);
                break;
            case 9:
                initR10(isHiragana);
                break;
            case 10:
                initR11(isHiragana);
                break;
            case 11:
                initR12(isHiragana);
                break;
            case 12:
                initR13(isHiragana);
                break;
            case 13:
                initR14(isHiragana);
                break;
            case 14:
                initR15(isHiragana);
                break;
            case 15:
                initR16(isHiragana);
                break;
            case 16:
                initR17(isHiragana);
                break;
            case 17:
                initR18(isHiragana);
                break;
            case 18:
                initR19(isHiragana);
                break;
        }
    }


    private void initR1(boolean isHiragana) {
        if (isHiragana) {
            mHiragana.add(new AlPhaBe("あ", "a"));
            mHiragana.add(new AlPhaBe("い", "i"));
            mHiragana.add(new AlPhaBe("う", "u"));
            mHiragana.add(new AlPhaBe("え", "e"));
            mHiragana.add(new AlPhaBe("お", "o"));
        } else {
            mkatakana.add(new AlPhaBe("ア", "a"));
            mkatakana.add(new AlPhaBe("イ", "i"));
            mkatakana.add(new AlPhaBe("ウ", "u"));
            mkatakana.add(new AlPhaBe("エ", "e"));
            mkatakana.add(new AlPhaBe("オ", "o"));
        }

    }

    private void initR2(boolean isHiragana) {
        if (isHiragana) {
            mHiragana.add(new AlPhaBe("か", "ka"));
            mHiragana.add(new AlPhaBe("き", "ki"));
            mHiragana.add(new AlPhaBe("く", "ku"));
            mHiragana.add(new AlPhaBe("け", "ke"));
            mHiragana.add(new AlPhaBe("こ", "ko"));
        } else {
            mkatakana.add(new AlPhaBe("カ", "ka"));
            mkatakana.add(new AlPhaBe("キ", "ki"));
            mkatakana.add(new AlPhaBe("ク", "ku"));
            mkatakana.add(new AlPhaBe("ケ", "ke"));
            mkatakana.add(new AlPhaBe("コ", "ko"));
        }

    }

    private void initR3(boolean isHiragana) {
        if (isHiragana) {
            mHiragana.add(new AlPhaBe("さ", "sa"));
            mHiragana.add(new AlPhaBe("し", "shi"));
            mHiragana.add(new AlPhaBe("す", "su"));
            mHiragana.add(new AlPhaBe("せ", "se"));
            mHiragana.add(new AlPhaBe("そ", "so"));
        } else {
            mkatakana.add(new AlPhaBe("サ", "sa"));
            mkatakana.add(new AlPhaBe("シ", "shi"));
            mkatakana.add(new AlPhaBe("ス", "su"));
            mkatakana.add(new AlPhaBe("セ", "se"));
            mkatakana.add(new AlPhaBe("そ", "so"));
        }

    }

    private void initR4(boolean isHiragana) {
        if (isHiragana) {
            mHiragana.add(new AlPhaBe("た", "ta"));
            mHiragana.add(new AlPhaBe("ち", "chi"));
            mHiragana.add(new AlPhaBe("つ", "tsu"));
            mHiragana.add(new AlPhaBe("て", "te"));
            mHiragana.add(new AlPhaBe("と", "to"));
        } else {
            mkatakana.add(new AlPhaBe("タ", "ta"));
            mkatakana.add(new AlPhaBe("チ", "chi"));
            mkatakana.add(new AlPhaBe("ツ", "tsu"));
            mkatakana.add(new AlPhaBe("テ", "te"));
            mkatakana.add(new AlPhaBe("ト", "to"));
        }

    }

    private void initR5(boolean isHiragana) {
        if (isHiragana) {
            mHiragana.add(new AlPhaBe("な", "na"));
            mHiragana.add(new AlPhaBe("に", "ni"));
            mHiragana.add(new AlPhaBe("ぬ", "nu"));
            mHiragana.add(new AlPhaBe("ね", "ne"));
            mHiragana.add(new AlPhaBe("の", "no"));
        } else {
            mkatakana.add(new AlPhaBe("ナ", "na"));
            mkatakana.add(new AlPhaBe("ニ", "ni"));
            mkatakana.add(new AlPhaBe("ヌ", "nu"));
            mkatakana.add(new AlPhaBe("ネ", "ne"));
            mkatakana.add(new AlPhaBe("ノ", "no"));
        }

    }

    private void initR6(boolean isHiragana) {
        if (isHiragana) {
            mHiragana.add(new AlPhaBe("は", "ha"));
            mHiragana.add(new AlPhaBe("ひ", "hi"));
            mHiragana.add(new AlPhaBe("ふ", "fu"));
            mHiragana.add(new AlPhaBe("へ", "he"));
            mHiragana.add(new AlPhaBe("ほ", "ho"));
        } else {
            mkatakana.add(new AlPhaBe("ハ", "ha"));
            mkatakana.add(new AlPhaBe("ヒ", "hi"));
            mkatakana.add(new AlPhaBe("フ", "fu"));
            mkatakana.add(new AlPhaBe("ヘ", "he"));
            mkatakana.add(new AlPhaBe("ホ", "ho"));
        }

    }

    private void initR7(boolean isHiragana) {
        if (isHiragana) {
            mHiragana.add(new AlPhaBe("ま", "ma"));
            mHiragana.add(new AlPhaBe("み", "mi"));
            mHiragana.add(new AlPhaBe("む", "mu"));
            mHiragana.add(new AlPhaBe("め", "me"));
            mHiragana.add(new AlPhaBe("も", "mo"));
        } else {
            mkatakana.add(new AlPhaBe("マ", "ma"));
            mkatakana.add(new AlPhaBe("ミ", "mi"));
            mkatakana.add(new AlPhaBe("ム", "mu"));
            mkatakana.add(new AlPhaBe("メ", "me"));
            mkatakana.add(new AlPhaBe("モ", "mo"));
        }

    }

    private void initR8(boolean isHiragana) {
        if (isHiragana) {
            mHiragana.add(new AlPhaBe("や", "ya"));
            mHiragana.add(new AlPhaBe("ゆ", "yu"));
            mHiragana.add(new AlPhaBe("よ", "yo"));
        } else {
            mkatakana.add(new AlPhaBe("ヤ", "ya"));
            mkatakana.add(new AlPhaBe("ユ", "yu"));
            mkatakana.add(new AlPhaBe("ヨ", "yo"));
        }
    }

    private void initR9(boolean isHiragana) {
        if (isHiragana) {
            mHiragana.add(new AlPhaBe("ら", "ra"));
            mHiragana.add(new AlPhaBe("り", "ri"));
            mHiragana.add(new AlPhaBe("る", "ru"));
            mHiragana.add(new AlPhaBe("れ", "re"));
            mHiragana.add(new AlPhaBe("ろ", "ro"));
        } else {
            mkatakana.add(new AlPhaBe("ラ", "ra"));
            mkatakana.add(new AlPhaBe("リ", "ri"));
            mkatakana.add(new AlPhaBe("ル", "ru"));
            mkatakana.add(new AlPhaBe("レ", "re"));
            mkatakana.add(new AlPhaBe("ロ", "ro"));
        }

    }

    private void initR10(boolean isHiragana) {
        if (isHiragana) {
            mHiragana.add(new AlPhaBe("わ", "wa"));
            mHiragana.add(new AlPhaBe("を", "wo"));
            mHiragana.add(new AlPhaBe("ん", "n"));
        } else {
            mkatakana.add(new AlPhaBe("ワ", "wa"));
            mkatakana.add(new AlPhaBe("ヲ", "wo"));
            mkatakana.add(new AlPhaBe("ン", "n"));

        }

    }

    private void initR11(boolean isHiragana) {
        if (isHiragana) {
            mHiragana.add(new AlPhaBe("ひゃ", "kya"));
            mHiragana.add(new AlPhaBe("きゅ", "kyu"));
            mHiragana.add(new AlPhaBe("きょ", "kyo"));
        } else {
            mkatakana.add(new AlPhaBe("キャ", "kya"));
            mkatakana.add(new AlPhaBe("キュ", "kyu"));
            mkatakana.add(new AlPhaBe("キョ", "kyo"));
        }
    }

    private void initR12(boolean isHiragana) {
        if (isHiragana) {
            mHiragana.add(new AlPhaBe("しゃ", "sha"));
            mHiragana.add(new AlPhaBe("しゅ", "shu"));
            mHiragana.add(new AlPhaBe("しょ", "sho"));
        } else {
            mkatakana.add(new AlPhaBe("シャ", "sha"));
            mkatakana.add(new AlPhaBe("シュ", "shu"));
            mkatakana.add(new AlPhaBe("ショ", "sho"));
        }

    }

    private void initR13(boolean isHiragana) {
        if (isHiragana) {
            mHiragana.add(new AlPhaBe("ちゃ", "cha"));
            mHiragana.add(new AlPhaBe("ちゅ", "chu"));
            mHiragana.add(new AlPhaBe("ちょ", "cho"));
        } else {
            mkatakana.add(new AlPhaBe("チャ", "cha"));
            mkatakana.add(new AlPhaBe("チュ", "chu"));
            mkatakana.add(new AlPhaBe("チョ", "cho"));
        }
    }

    private void initR14(boolean isHiragana) {
        if (isHiragana) {
            mHiragana.add(new AlPhaBe("にゃ", "nya"));
            mHiragana.add(new AlPhaBe("にゅ", "nyu"));
            mHiragana.add(new AlPhaBe("にょ", "nyo"));
        } else {
            mkatakana.add(new AlPhaBe("ニャ", "nya"));
            mkatakana.add(new AlPhaBe("ニュ", "nyu"));
            mkatakana.add(new AlPhaBe("ニョ", "nyo"));
        }
    }

    private void initR15(boolean isHiragana) {
        if (isHiragana) {
            mHiragana.add(new AlPhaBe("ひゃ", "hya"));
            mHiragana.add(new AlPhaBe("ひゅ", "hyu"));
            mHiragana.add(new AlPhaBe("ひょ", "hyo"));
        } else {
            mkatakana.add(new AlPhaBe("ヒャ", "hya"));
            mkatakana.add(new AlPhaBe("ヒュ", "hyu"));
            mkatakana.add(new AlPhaBe("ヒョ", "hyo"));
        }
    }

    private void initR16(boolean isHiragana) {
        if (isHiragana) {
            mHiragana.add(new AlPhaBe("みゃ", "mya"));
            mHiragana.add(new AlPhaBe("みゅ", "myu"));
            mHiragana.add(new AlPhaBe("みょ", "myo"));
        } else {
            mkatakana.add(new AlPhaBe("ミャ", "mya"));
            mkatakana.add(new AlPhaBe("ミュ", "myu"));
            mkatakana.add(new AlPhaBe("ミョ", "myo"));
        }
    }

    private void initR17(boolean isHiragana) {
        if (isHiragana) {
            mHiragana.add(new AlPhaBe("りゃ", "rya"));
            mHiragana.add(new AlPhaBe("りゅ", "ryu"));
            mHiragana.add(new AlPhaBe("りょ", "ryo"));
        } else {
            mkatakana.add(new AlPhaBe("リャ", "rya"));
            mkatakana.add(new AlPhaBe("リュ", "ryu"));
            mkatakana.add(new AlPhaBe("リョ", "ryo"));
        }
    }

    private void initR18(boolean isHiragana) {
        if (isHiragana) {
            mHiragana.add(new AlPhaBe("が", "ga"));
            mHiragana.add(new AlPhaBe("ぎ", "gi"));
            mHiragana.add(new AlPhaBe("ぐ", "gu"));
            mHiragana.add(new AlPhaBe("げ", "ge"));
            mHiragana.add(new AlPhaBe("ご", "go"));
            mHiragana.add(new AlPhaBe("ざ", "za"));
            mHiragana.add(new AlPhaBe("じ", "ji"));
            mHiragana.add(new AlPhaBe("ず", "zu"));
            mHiragana.add(new AlPhaBe("ぜ", "ze"));
            mHiragana.add(new AlPhaBe("ぞ", "zo"));
            mHiragana.add(new AlPhaBe("だ", "da"));
            mHiragana.add(new AlPhaBe("で", "de"));
            mHiragana.add(new AlPhaBe("ど", "do"));
            mHiragana.add(new AlPhaBe("ば", "ba"));
            mHiragana.add(new AlPhaBe("び", "bi"));
            mHiragana.add(new AlPhaBe("ぶ", "bu"));
            mHiragana.add(new AlPhaBe("べ", "be"));
            mHiragana.add(new AlPhaBe("ぼ", "bo"));
            mHiragana.add(new AlPhaBe("ぎゃ", "gya"));
            mHiragana.add(new AlPhaBe("ぎゅ", "gyu"));
            mHiragana.add(new AlPhaBe("ぎょ", "gyo"));
            mHiragana.add(new AlPhaBe("じゃ", "ja"));
            mHiragana.add(new AlPhaBe("じゅ", "ju"));
            mHiragana.add(new AlPhaBe("じょ", "jo"));
            mHiragana.add(new AlPhaBe("びゃ", "bya"));
            mHiragana.add(new AlPhaBe("びゅ", "byu"));
            mHiragana.add(new AlPhaBe("びょ", "byo"));

        } else {
            mkatakana.add(new AlPhaBe("ガ", "ga"));
            mkatakana.add(new AlPhaBe("ギ", "gi"));
            mkatakana.add(new AlPhaBe("グ", "gu"));
            mkatakana.add(new AlPhaBe("ゲ", "ge"));
            mkatakana.add(new AlPhaBe("ゴ", "go"));
            mkatakana.add(new AlPhaBe("ザ", "za"));
            mkatakana.add(new AlPhaBe("ジ", "ji"));
            mkatakana.add(new AlPhaBe("ズ", "zu"));
            mkatakana.add(new AlPhaBe("ゼ", "ze"));
            mkatakana.add(new AlPhaBe("ゾ", "zo"));
            mkatakana.add(new AlPhaBe("ダ", "da"));
            mkatakana.add(new AlPhaBe("デ", "de"));
            mkatakana.add(new AlPhaBe("ド", "do"));
            mkatakana.add(new AlPhaBe("バ", "ba"));
            mkatakana.add(new AlPhaBe("ビ", "bi"));
            mkatakana.add(new AlPhaBe("ブ", "bu"));
            mkatakana.add(new AlPhaBe("ベ", "be"));
            mkatakana.add(new AlPhaBe("ボ", "bo"));
            mkatakana.add(new AlPhaBe("ギャ", "gya"));
            mkatakana.add(new AlPhaBe("ギュ", "gyu"));
            mkatakana.add(new AlPhaBe("ギョ", "gyo"));
            mkatakana.add(new AlPhaBe("ジャ", "ja"));
            mkatakana.add(new AlPhaBe("ジュ", "ju"));
            mkatakana.add(new AlPhaBe("ジョ", "jo"));
            mkatakana.add(new AlPhaBe("ビャ", "bya"));
            mkatakana.add(new AlPhaBe("ビュ", "byu"));
            mkatakana.add(new AlPhaBe("ビョ", "byo"));
        }
    }

    private void initR19(boolean isHiragana) {
        if (isHiragana) {
            mHiragana.add(new AlPhaBe("ぱ", "pa"));
            mHiragana.add(new AlPhaBe("ぴ", "pi"));
            mHiragana.add(new AlPhaBe("ぷ", "pu"));
            mHiragana.add(new AlPhaBe("ぺ", "pe"));
            mHiragana.add(new AlPhaBe("ぽ", "po"));
            mHiragana.add(new AlPhaBe("ぴゃ", "pya"));
            mHiragana.add(new AlPhaBe("ぴゅ", "pyu"));
            mHiragana.add(new AlPhaBe("ぴょ", "pyo"));
        } else {
            mkatakana.add(new AlPhaBe("パ", "pa"));
            mkatakana.add(new AlPhaBe("ピ", "pi"));
            mkatakana.add(new AlPhaBe("プ", "pu"));
            mkatakana.add(new AlPhaBe("ペ", "pe"));
            mkatakana.add(new AlPhaBe("ポ", "po"));
            mkatakana.add(new AlPhaBe("ピャ", "pya"));
            mkatakana.add(new AlPhaBe("ピュ", "pyu"));
            mkatakana.add(new AlPhaBe("ピョ", "pyo"));
        }
    }
}
