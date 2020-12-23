package Task5;


import com.example.lab2.R;

public enum Thumbnail {
    ThumbnaiL1("Thumbnail 1", R.drawable.first_thumbnail),
    ThumbnaiL2("Thumbnail 2", R.drawable.second_thumbnail),
    ThumbnaiL3("Thumbnail 3", R.drawable.third_thumbnail),
    ThumbnaiL4("Thumbnail 4", R.drawable.fourth_thumbnail);

    private String name;
    private int img;

    Thumbnail(String _name, int _img) {
        this.name = _name;
        this.img = _img;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
