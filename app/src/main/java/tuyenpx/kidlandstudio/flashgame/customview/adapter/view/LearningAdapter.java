package tuyenpx.kidlandstudio.flashgame.customview.adapter.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import tuyenpx.kidlandstudio.flashgame.R;
import tuyenpx.kidlandstudio.flashgame.object.AlPhaBe;

/**
 * Created by tuyenpx on 16/09/2016.
 */
public class LearningAdapter extends ArrayAdapter<AlPhaBe> {

    private static class ViewHolder {
        private TextView itemKey;
        private TextView itemValue;
    }

    public LearningAdapter(Context context, int textViewResourceId, ArrayList<AlPhaBe> items) {
        super(context, textViewResourceId, items);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext())
                    .inflate(R.layout.item_alphabet, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.itemKey = (TextView) convertView.findViewById(R.id.txt_key);
            viewHolder.itemValue = (TextView) convertView.findViewById(R.id.txt_value);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        AlPhaBe item = getItem(position);
        if (item != null) {
            // My layout has only one TextView
            // do whatever you want with your string and long
            viewHolder.itemKey.setText(item.getmKey());
            viewHolder.itemValue.setText(item.getmValue());
        }
        return convertView;
    }

}
