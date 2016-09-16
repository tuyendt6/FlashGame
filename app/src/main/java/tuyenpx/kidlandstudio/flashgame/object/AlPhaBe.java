package tuyenpx.kidlandstudio.flashgame.object;

/**
 * Created by tuyenpx on 12/09/2016.
 */
public class AlPhaBe {
    private String mKey;
    private String mValue;

    public AlPhaBe(String mKey, String mValue) {
        this.mKey = mKey;
        this.mValue = mValue;
    }

    public String getmKey() {
        return mKey;
    }

    public String getmValue() {
        return mValue;
    }

    @Override
    public String toString() {
        return "mkey = " + mKey + "mValue = " + mValue;
    }
}
