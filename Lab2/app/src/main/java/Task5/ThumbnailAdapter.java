package Task5;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab2.R;

public class ThumbnailAdapter extends BaseAdapter {
    private Activity context;
    int Images[];
    String[] thumbnail_labels;
    LayoutInflater inflater;

    public ThumbnailAdapter(Activity context, int[] Images, String[] thumbnail_names) {
        this.context = context;
        this.Images = Images;
        this.thumbnail_labels = thumbnail_names;
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return Images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.items_thumbnails, null);
        ImageView icon = (ImageView) convertView.findViewById(R.id.thumbnail_img);
        TextView name = (TextView) convertView.findViewById(R.id.thumbnail_text);
        icon.setImageResource(Images[position]);
        name.setText(thumbnail_labels[position]);

        return convertView;
    }
}
