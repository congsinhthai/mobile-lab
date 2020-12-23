package Task5;

import com.example.lab2.R;

public class Dish {
    private String name;
    private int thumbnail;
    private boolean promotion;

    public Dish(String dname, int dthumbnail, boolean dpromotion) {
        this.name = dname;
        this.promotion = dpromotion;
        if (dthumbnail == 0) {
            this.thumbnail = R.drawable.first_thumbnail;
        } else if (dthumbnail == 1) {
            this.thumbnail = R.drawable.second_thumbnail;
        } else if (dthumbnail == 2) {
            this.thumbnail = R.drawable.third_thumbnail;
        } else
            this.thumbnail = R.drawable.fourth_thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}