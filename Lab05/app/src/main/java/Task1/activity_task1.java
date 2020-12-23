package Task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lab05.MainActivity;
import com.example.lab05.R;

import Task2.activity_task2;

public class activity_task1 extends AppCompatActivity {

    private Button btnFadeInXml, btnFadeInCode;
    private ImageView imageViewUIT;
    private Animation.AnimationListener animationListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);
        setUIReference();
        initVariable();
        //handler click animation xml
        //load the animation
        final Animation animation= AnimationUtils.loadAnimation(activity_task1.this,R.anim.anim_fade_in);
        animation.setAnimationListener(animationListener);


        //add event on button fadein from xml file
        btnFadeInXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewUIT.startAnimation(animation);
            }
        });

        imageViewUIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity_task1.this, activity_task2.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });
        hanldeClickAnimationCode(btnFadeInCode,initFadeInAnimation());
    }


    private void hanldeClickAnimationCode(Button btn, final Animation animation) {
        //hanlder onclick listener to tart animation
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewUIT.startAnimation(animation);
            }
        });
    }
    private Animation initFadeInAnimation(){
        AlphaAnimation animation =new AlphaAnimation(0f,1f);
        animation.setDuration(5000);
        animation.setFillAfter(true);
        animation.setAnimationListener(animationListener);
        return animation;
    }

    private void initVariable() {
        animationListener=new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(getApplicationContext(),"Animation Stopped",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };
    }

    private void setUIReference() {
    btnFadeInCode=(Button) findViewById(R.id.btn_fade_in_code);
    btnFadeInXml=(Button)findViewById(R.id.btn_fade_in_xml);
    imageViewUIT=(ImageView)findViewById(R.id.iv_uit_logo);

    }

}