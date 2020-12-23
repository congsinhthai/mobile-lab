package Task5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lab2.R;

import java.util.ArrayList;

public class task5 extends AppCompatActivity {
    Spinner thumbnailSpin;
    GridView gridView;
    EditText name;
    Button addDishBtn;
    CheckBox promotion;
    ArrayList<Dish> dishList;
    ArrayList<Thumbnail> thumbnailArrayList;
    ThumbnailAdapter thumbnailAdapter;
    DishAdapter dishAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task5);
        setUIReference();
        dishList = new ArrayList<Dish>();

        thumbnailArrayList = new ArrayList<>();
        thumbnailArrayList.add(Thumbnail.ThumbnaiL1);
        thumbnailArrayList.add(Thumbnail.ThumbnaiL2);
        thumbnailArrayList.add(Thumbnail.ThumbnaiL3);
        thumbnailArrayList.add(Thumbnail.ThumbnaiL4);

        int Images[] = {Thumbnail.ThumbnaiL1.getImg(),Thumbnail.ThumbnaiL2.getImg(),
                Thumbnail.ThumbnaiL3.getImg(), Thumbnail.ThumbnaiL4.getImg()};
        String[] Names = {Thumbnail.ThumbnaiL1.getName(), Thumbnail.ThumbnaiL2.getName(),
                Thumbnail.ThumbnaiL3.getName(), Thumbnail.ThumbnaiL4.getName()};

        thumbnailAdapter = new ThumbnailAdapter(this, Images, Names);
        thumbnailSpin.setAdapter(thumbnailAdapter);

        addDishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty()){
                    name.setError("Name is invalid");
                }else{


                dishList.add(new Dish(name.getText().toString(), thumbnailSpin.getSelectedItemPosition(), promotion.isChecked()));
                dishAdapter = new DishAdapter(task5.this, R.id.dish_gridview, dishList);
                gridView.setAdapter(dishAdapter);

                name.getText().clear();
                if (promotion.isChecked()) {
                    promotion.setChecked(false);
                }

                Toast.makeText(task5.this, "Added Successfully", Toast.LENGTH_SHORT).show();
            }
            }

        });
    }

    private void setUIReference() {
        thumbnailSpin = findViewById(R.id.thumbnail_spinner);
        gridView = findViewById(R.id.dish_gridview);
        addDishBtn = findViewById(R.id.add_btn);
        promotion = findViewById(R.id.promotion_checkbox);
        name = findViewById(R.id.name_et);
    }
}