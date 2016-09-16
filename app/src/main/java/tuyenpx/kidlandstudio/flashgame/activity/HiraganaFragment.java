package tuyenpx.kidlandstudio.flashgame.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

import tuyenpx.kidlandstudio.flashgame.R;
import tuyenpx.kidlandstudio.flashgame.customview.adapter.view.LearningAdapter;
import tuyenpx.kidlandstudio.flashgame.object.AlPhaBe;

/**
 * Created by tuyenpx on 16/09/2016.
 */
public class HiraganaFragment extends Fragment {

    private GridView mGridView;
    private LearningAdapter mAdapter;
    private ArrayList<AlPhaBe> mHiragana = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.hiragana_layout, null);
        mGridView = (GridView) v.findViewById(R.id.gridView);
        initData();
        mAdapter = new LearningAdapter(getContext(), R.layout.item_alphabet, mHiragana);
        mGridView.setAdapter(mAdapter);
        return v;
    }

    private void initData() {
        mHiragana.add(new AlPhaBe("あ", "a"));
        mHiragana.add(new AlPhaBe("い", "i"));
        mHiragana.add(new AlPhaBe("う", "u"));
        mHiragana.add(new AlPhaBe("え", "e"));
        mHiragana.add(new AlPhaBe("お", "o"));
        mHiragana.add(new AlPhaBe("か", "ka"));
        mHiragana.add(new AlPhaBe("き", "ki"));
        mHiragana.add(new AlPhaBe("く", "ku"));
        mHiragana.add(new AlPhaBe("け", "ke"));
        mHiragana.add(new AlPhaBe("こ", "ko"));
        mHiragana.add(new AlPhaBe("さ", "sa"));
        mHiragana.add(new AlPhaBe("し", "shi"));
        mHiragana.add(new AlPhaBe("す", "su"));
        mHiragana.add(new AlPhaBe("せ", "se"));
        mHiragana.add(new AlPhaBe("そ", "so"));
        mHiragana.add(new AlPhaBe("た", "ta"));
        mHiragana.add(new AlPhaBe("ち", "chi"));
        mHiragana.add(new AlPhaBe("つ", "tsu"));
        mHiragana.add(new AlPhaBe("て", "te"));
        mHiragana.add(new AlPhaBe("と", "to"));
        mHiragana.add(new AlPhaBe("な", "na"));
        mHiragana.add(new AlPhaBe("に", "ni"));
        mHiragana.add(new AlPhaBe("ぬ", "nu"));
        mHiragana.add(new AlPhaBe("ね", "ne"));
        mHiragana.add(new AlPhaBe("の", "no"));
        mHiragana.add(new AlPhaBe("は", "ha"));
        mHiragana.add(new AlPhaBe("ひ", "hi"));
        mHiragana.add(new AlPhaBe("ふ", "fu"));
        mHiragana.add(new AlPhaBe("へ", "he"));
        mHiragana.add(new AlPhaBe("ほ", "ho"));
        mHiragana.add(new AlPhaBe("ま", "ma"));
        mHiragana.add(new AlPhaBe("み", "mi"));
        mHiragana.add(new AlPhaBe("む", "mu"));
        mHiragana.add(new AlPhaBe("め", "me"));
        mHiragana.add(new AlPhaBe("も", "mo"));
        mHiragana.add(new AlPhaBe("や", "ya"));
        mHiragana.add(new AlPhaBe("ゆ", "yu"));
        mHiragana.add(new AlPhaBe("よ", "yo"));
        mHiragana.add(new AlPhaBe("ら", "ra"));
        mHiragana.add(new AlPhaBe("り", "ri"));
        mHiragana.add(new AlPhaBe("る", "ru"));
        mHiragana.add(new AlPhaBe("れ", "re"));
        mHiragana.add(new AlPhaBe("ろ", "ro"));
        mHiragana.add(new AlPhaBe("わ", "wa"));
        mHiragana.add(new AlPhaBe("を", "wo"));
        mHiragana.add(new AlPhaBe("ん", "n"));

        mHiragana.add(new AlPhaBe("ひゃ", "kya"));
        mHiragana.add(new AlPhaBe("きゅ", "kyu"));
        mHiragana.add(new AlPhaBe("きょ", "kyo"));

        mHiragana.add(new AlPhaBe("しゃ", "sha"));
        mHiragana.add(new AlPhaBe("しゅ", "shu"));
        mHiragana.add(new AlPhaBe("しょ", "sho"));

        mHiragana.add(new AlPhaBe("ちゃ", "cha"));
        mHiragana.add(new AlPhaBe("ちゅ", "chu"));
        mHiragana.add(new AlPhaBe("ちょ", "cho"));

        mHiragana.add(new AlPhaBe("にゃ", "nya"));
        mHiragana.add(new AlPhaBe("にゅ", "nyu"));
        mHiragana.add(new AlPhaBe("にょ", "nyo"));

        mHiragana.add(new AlPhaBe("ひゃ", "hya"));
        mHiragana.add(new AlPhaBe("ひゅ", "hyu"));
        mHiragana.add(new AlPhaBe("ひょ", "hyo"));

        mHiragana.add(new AlPhaBe("みゃ", "mya"));
        mHiragana.add(new AlPhaBe("みゅ", "myu"));
        mHiragana.add(new AlPhaBe("みょ", "myo"));

        mHiragana.add(new AlPhaBe("りゃ", "rya"));
        mHiragana.add(new AlPhaBe("りゅ", "ryu"));
        mHiragana.add(new AlPhaBe("りょ", "ryo"));
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
        mHiragana.add(new AlPhaBe("ぱ", "pa"));
        mHiragana.add(new AlPhaBe("ぴ", "pi"));
        mHiragana.add(new AlPhaBe("ぷ", "pu"));
        mHiragana.add(new AlPhaBe("ぺ", "pe"));
        mHiragana.add(new AlPhaBe("ぽ", "po"));
        mHiragana.add(new AlPhaBe("ぴゃ", "pya"));
        mHiragana.add(new AlPhaBe("ぴゅ", "pyu"));
        mHiragana.add(new AlPhaBe("ぴょ", "pyo"));
    }


}
