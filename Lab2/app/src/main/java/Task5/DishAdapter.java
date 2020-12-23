package Task5;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab2.R;

import java.util.List;

public class DishAdapter extends ArrayAdapter<Dish> {
    private Activity context;
    private int[] thumbnail = {
            R.drawable.first_thumbnail,
            R.drawable.second_thumbnail,
            R.drawable.third_thumbnail,
            R.drawable.fourth_thumbnail
    };
    private String[] thumbnail_title;

    LayoutInflater layoutInflater;

    public DishAdapter(Activity context, int resource, List<Dish> objects) {
        super(context, resource, objects);
        this.context = context;
        layoutInflater = LayoutInflater.from(this.context);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.items_dish, parent, false);

            Dish dish = getItem(position);

            TextView thumbnailLabel = (TextView)convertView.findViewById(R.id.dish_label);
            ImageView thumbnailImage = (ImageView)convertView.findViewById(R.id.dish_view);
            ImageView promotionImage = (ImageView)convertView.findViewById(R.id.item_dish_promotion);

            if (dish.getName() != null) {
                thumbnailLabel.setText(dish.getName());
                thumbnailImage.setImageResource(dish.getThumbnail());
                if (dish.isPromotion()) {
                    promotionImage.setVisibility(convertView.VISIBLE);
                }
            } else {
                thumbnailLabel.setText("");
            }
        }
        return convertView;
    }

}

