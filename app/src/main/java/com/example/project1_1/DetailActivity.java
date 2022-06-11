package com.example.project1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView, name;
    private ImageView bgImg;
    private ImageView btnBack,btnFav;
    private boolean fav = false;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        
        textView = (TextView) findViewById(R.id.tv_animal_desc);
        name = (TextView) findViewById(R.id.tv_name);
        bgImg = (ImageView) findViewById(R.id.id_bg);
        btnBack = (ImageView) findViewById(R.id.iv_back);
        btnFav = (ImageView) findViewById(R.id.btn_fav);

        btnFav.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        byExtra();

    }

    public void byExtra(){
        Intent intent = getIntent();
        int type = getIntent().getIntExtra("KEY", 0);
        fav = intent.getBooleanExtra("FAV", false);
        String animalName, info;

        if (fav) {
            btnFav.setImageResource(R.drawable.ic_fav_2);
        }else{
            btnFav.setImageResource(R.drawable.ic_fav_1);
        }
        switch (type){
            case R.id.id_elephant:
                bgImg.setImageResource(R.drawable.bg_elephant);
                animalName = "Elephant";
                info = getString(R.string.txt_elephant);
                textView.setText(info);
                name.setText(animalName);
                break;
            case R.id.id_dragon_fly:
                bgImg.setImageResource(R.drawable.bg_dragonfly);
                animalName = "Dragon Fly";
                info = getString(R.string.txt_dragon_fly);
                textView.setText(info);
                name.setText(animalName);
                break;
            case R.id.id_dolphin:
                bgImg.setImageResource(R.drawable.bg_dolphin);
                animalName = "Dolphin";
                info = getString(R.string.txt_dolphin);
                textView.setText(info);
                name.setText(animalName);
                break;
            case R.id.id_dog:
                bgImg.setImageResource(R.drawable.bg_dog);
                animalName = "Dog";
                info = getString(R.string.txt_dog);
                textView.setText(info);
                name.setText(animalName);
                break;
            case R.id.id_pig:
                bgImg.setImageResource(R.drawable.bg_pig);
                animalName = "Pig";
                info = getString(R.string.txt_pig);
                textView.setText(info);
                name.setText(animalName);
                break;
            case R.id.id_goose:
                bgImg.setImageResource(R.drawable.bg_goose);
                animalName = "Goose";
                info = getString(R.string.txt_goose);
                textView.setText(info);
                name.setText(animalName);
                break;
            case R.id.id_ladybug:
                bgImg.setImageResource(R.drawable.bg_ladybug);
                animalName = "Lady Bug";
                info = getString(R.string.txt_lady_bug);
                textView.setText(info);
                name.setText(animalName);
                break;
            case R.id.id_turtle:
                bgImg.setImageResource(R.drawable.bg_turtle);
                animalName = "Turtle";
                info = getString(R.string.txt_turtle);
                textView.setText(info);
                name.setText(animalName);
                break;
            case R.id.id_penguin:
                bgImg.setImageResource(R.drawable.bg_penguin);
                animalName = "Penguin";
                info = getString(R.string.txt_penguin);
                textView.setText(info);
                name.setText(animalName);
                break;
            default:
                break;
        }
    }
    @Override
    public void onClick(View view) {
        Log.d("TAG", "onClick: " + fav);
        if(view.getId() == R.id.iv_back){
            Intent i = getIntent();
            int type = i.getIntExtra("KEY", 0);
            Intent intent = new Intent();
            intent.putExtra("KEY", type);
            intent.putExtra("FAV", fav);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }else if(view.getId() == R.id.btn_fav){
            makeAnimation(btnFav, androidx.appcompat.R.anim.abc_fade_in);
            Intent intent = getIntent();
            fav = intent.getBooleanExtra("FAV", false);
            int type = getIntent().getIntExtra("KEY", 0);
            if (fav){
                btnFav.setImageResource(R.drawable.ic_fav_1);
                fav = false;
            }else{
                btnFav.setImageResource(R.drawable.ic_fav_2);
                fav = true;
            }
        }
    }

    private void makeAnimation(View view, int animID){
        Animation animation = AnimationUtils.loadAnimation(this,animID);
        view.startAnimation(animation);
    }
}