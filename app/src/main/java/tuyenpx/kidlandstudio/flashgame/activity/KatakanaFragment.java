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
public class KatakanaFragment extends Fragment {

    private GridView mGridView;
    private LearningAdapter mAdapter;
    private ArrayList<AlPhaBe> mkatakana = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.hiragana_layout, null);
        mGridView = (GridView) v.findViewById(R.id.gridView);
        initData();
        mAdapter = new LearningAdapter(getContext(), R.layout.item_alphabet, mkatakana);
        mGridView.setAdapter(mAdapter);
        return v;
    }

    private void initData() {
        mkatakana.add(new AlPhaBe("ア", "a"));
        mkatakana.add(new AlPhaBe("イ", "i"));
        mkatakana.add(new AlPhaBe("ウ", "u"));
        mkatakana.add(new AlPhaBe("エ", "e"));
        mkatakana.add(new AlPhaBe("オ", "o"));
        mkatakana.add(new AlPhaBe("カ", "ka"));
        mkatakana.add(new AlPhaBe("キ", "ki"));
        mkatakana.add(new AlPhaBe("ク", "ku"));
        mkatakana.add(new AlPhaBe("ケ", "ke"));
        mkatakana.add(new AlPhaBe("コ", "ko"));
        mkatakana.add(new AlPhaBe("サ", "sa"));
        mkatakana.add(new AlPhaBe("シ", "shi"));
        mkatakana.add(new AlPhaBe("ス", "su"));
        mkatakana.add(new AlPhaBe("セ", "se"));
        mkatakana.add(new AlPhaBe("そ", "so"));
        mkatakana.add(new AlPhaBe("タ", "ta"));
        mkatakana.add(new AlPhaBe("チ", "chi"));
        mkatakana.add(new AlPhaBe("ツ", "tsu"));
        mkatakana.add(new AlPhaBe("テ", "te"));
        mkatakana.add(new AlPhaBe("ト", "to"));
        mkatakana.add(new AlPhaBe("ナ", "na"));
        mkatakana.add(new AlPhaBe("ニ", "ni"));
        mkatakana.add(new AlPhaBe("ヌ", "nu"));
        mkatakana.add(new AlPhaBe("ネ", "ne"));
        mkatakana.add(new AlPhaBe("ノ", "no"));
        mkatakana.add(new AlPhaBe("ハ", "ha"));
        mkatakana.add(new AlPhaBe("ヒ", "hi"));
        mkatakana.add(new AlPhaBe("フ", "fu"));
        mkatakana.add(new AlPhaBe("ヘ", "he"));
        mkatakana.add(new AlPhaBe("ホ", "ho"));
        mkatakana.add(new AlPhaBe("マ", "ma"));
        mkatakana.add(new AlPhaBe("ミ", "mi"));
        mkatakana.add(new AlPhaBe("ム", "mu"));
        mkatakana.add(new AlPhaBe("メ", "me"));
        mkatakana.add(new AlPhaBe("モ", "mo"));
        mkatakana.add(new AlPhaBe("ヤ", "ya"));
        mkatakana.add(new AlPhaBe("ユ", "yu"));
        mkatakana.add(new AlPhaBe("ヨ", "yo"));
        mkatakana.add(new AlPhaBe("ラ", "ra"));
        mkatakana.add(new AlPhaBe("リ", "ri"));
        mkatakana.add(new AlPhaBe("ル", "ru"));
        mkatakana.add(new AlPhaBe("レ", "re"));
        mkatakana.add(new AlPhaBe("ロ", "ro"));
        mkatakana.add(new AlPhaBe("ワ", "wa"));
        mkatakana.add(new AlPhaBe("ヲ", "wo"));
        mkatakana.add(new AlPhaBe("ン", "n"));
        mkatakana.add(new AlPhaBe("キャ", "kya"));
        mkatakana.add(new AlPhaBe("キュ", "kyu"));
        mkatakana.add(new AlPhaBe("キョ", "kyo"));
        mkatakana.add(new AlPhaBe("シャ", "sha"));
        mkatakana.add(new AlPhaBe("シュ", "shu"));
        mkatakana.add(new AlPhaBe("ショ", "sho"));
        mkatakana.add(new AlPhaBe("チャ", "cha"));
        mkatakana.add(new AlPhaBe("チュ", "chu"));
        mkatakana.add(new AlPhaBe("チョ", "cho"));
        mkatakana.add(new AlPhaBe("ニャ", "nya"));
        mkatakana.add(new AlPhaBe("ニュ", "nyu"));
        mkatakana.add(new AlPhaBe("ニョ", "nyo"));
        mkatakana.add(new AlPhaBe("ヒャ", "hya"));
        mkatakana.add(new AlPhaBe("ヒュ", "hyu"));
        mkatakana.add(new AlPhaBe("ヒョ", "hyo"));
        mkatakana.add(new AlPhaBe("ミャ", "mya"));
        mkatakana.add(new AlPhaBe("ミュ", "myu"));
        mkatakana.add(new AlPhaBe("ミョ", "myo"));
        mkatakana.add(new AlPhaBe("リャ", "rya"));
        mkatakana.add(new AlPhaBe("リュ", "ryu"));
        mkatakana.add(new AlPhaBe("リョ", "ryo"));
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
