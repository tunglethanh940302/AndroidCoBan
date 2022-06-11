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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView iv_elephant, iv_dragon_fly, iv_dolphin, iv_dog, iv_pig, iv_goose, iv_lady_bug, iv_turtle, iv_penguin;
    private boolean elephantFav, dragonFlyFav, dolphinFav, dogFav, pigFav, gooseFav, ladyBugFav, turtleFav, penguinFav;
    private ImageView elephant_fav_icon,dragon_fly_fav_icon,dolphin_fav_icon,dog_fav_icon,pig_fav_icon,goose_fav_icon,lady_bug_fav_icon,turtle_fav_icon,penguin_fav_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_elephant = findViewById(R.id.id_elephant);
        iv_dragon_fly = findViewById(R.id.id_dragon_fly);
        iv_dolphin = findViewById(R.id.id_dolphin);
        iv_dog = findViewById(R.id.id_dog);
        iv_pig = findViewById(R.id.id_pig);
        iv_goose = findViewById(R.id.id_goose);
        iv_lady_bug = findViewById(R.id.id_ladybug);
        iv_turtle = findViewById(R.id.id_turtle);
        iv_penguin = findViewById(R.id.id_penguin);

        elephant_fav_icon = (ImageView) findViewById(R.id.id_elephant_fav);
        dragon_fly_fav_icon = (ImageView) findViewById(R.id.id_dragon_fly_fav);
        dolphin_fav_icon = (ImageView) findViewById(R.id.id_dolphin_fav);
        dog_fav_icon = (ImageView) findViewById(R.id.id_dog_fav);
        pig_fav_icon = (ImageView) findViewById(R.id.id_pig_fav);
        goose_fav_icon = (ImageView) findViewById(R.id.id_goose_fav);
        lady_bug_fav_icon = (ImageView) findViewById(R.id.id_lady_bug_fav);
        turtle_fav_icon = (ImageView) findViewById(R.id.id_turtle_fav);
        penguin_fav_icon = (ImageView) findViewById(R.id.id_penguin_fav);

        iv_elephant.setOnClickListener(this);
        iv_dragon_fly.setOnClickListener(this);
        iv_dolphin.setOnClickListener(this);
        iv_dog.setOnClickListener(this);
        iv_pig.setOnClickListener(this);
        iv_goose.setOnClickListener(this);
        iv_lady_bug.setOnClickListener(this);
        iv_turtle.setOnClickListener(this);
        iv_penguin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.id_elephant:
                makeAnimation(iv_elephant,R.anim.anim_alpha);
                showDetail(R.id.id_elephant, elephantFav);
                break;
            case R.id.id_dragon_fly:
                makeAnimation(iv_dragon_fly,R.anim.anim_alpha);
                showDetail(R.id.id_dragon_fly, dragonFlyFav);
                break;
            case R.id.id_dolphin:
                makeAnimation(iv_dolphin,R.anim.anim_alpha);
                showDetail(R.id.id_dolphin, dolphinFav);
                break;
            case R.id.id_dog:
                makeAnimation(iv_dog,R.anim.anim_alpha);
                showDetail(R.id.id_dog, dogFav);
                break;
            case R.id.id_pig:
                makeAnimation(iv_pig,R.anim.anim_alpha);
                showDetail(R.id.id_pig, pigFav);
                break;
            case R.id.id_goose:
                makeAnimation(iv_goose,R.anim.anim_alpha);
                showDetail(R.id.id_goose, gooseFav);
                break;
            case R.id.id_ladybug:
                makeAnimation(iv_lady_bug,R.anim.anim_alpha);
                showDetail(R.id.id_ladybug, ladyBugFav);
                break;
            case R.id.id_turtle:
                makeAnimation(iv_turtle,R.anim.anim_alpha);
                showDetail(R.id.id_turtle, turtleFav);
                break;
            case R.id.id_penguin:
                makeAnimation(iv_penguin,R.anim.anim_alpha);
                showDetail(R.id.id_penguin, penguinFav);
                break;
            default:
                break;
        }
    }


    private void makeAnimation(View view, int animId){
        Animation animation = AnimationUtils.loadAnimation(this, animId);
        view.startAnimation(animation);
    }

    private void showDetail(int type, boolean fav){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("KEY", type);
        intent.putExtra("FAV", fav);
        startActivityForResult(intent, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {

            if (resultCode == Activity.RESULT_OK) {
                int key = data.getIntExtra("KEY", -1);
                boolean fav = data.getBooleanExtra("FAV", false);
                Log.d("TAG", "onActivityResult: " + key);
                Log.d("TAG", "boolean: " + fav);
                ImageView favIcon = getAnimal(key);
                setVisibility(favIcon, fav);
                switch (key) {
                    case R.id.id_elephant:
                        elephantFav = fav;
                        break;
                    case R.id.id_dragon_fly:
                        dragonFlyFav = fav;
                        break;
                    case R.id.id_dolphin:
                        dolphinFav = fav;
                        break;
                    case R.id.id_dog:
                        dogFav = fav;
                        break;
                    case R.id.id_pig:
                        pigFav = fav;
                        break;
                    case R.id.id_goose:
                        gooseFav = fav;
                        break;
                    case R.id.id_ladybug:
                        ladyBugFav = fav;
                        break;
                    case R.id.id_turtle:
                        turtleFav = fav;
                        break;
                    case R.id.id_penguin:
                        penguinFav = fav;
                        break;
                }
            }
        }
    }
    private ImageView getAnimal(int id) {
        switch (id) {
            case R.id.id_elephant:
                return elephant_fav_icon;
            case R.id.id_dragon_fly:
                return dragon_fly_fav_icon;
            case R.id.id_dolphin:
                return dolphin_fav_icon;
            case R.id.id_dog:
                return dog_fav_icon;
            case R.id.id_pig:
                return pig_fav_icon;
            case R.id.id_goose:
                return goose_fav_icon;
            case R.id.id_ladybug:
                return lady_bug_fav_icon;
            case R.id.id_turtle:
                return turtle_fav_icon;
            case R.id.id_penguin:
                return penguin_fav_icon;
        }
        return null;
    }
    private void setVisibility(View view, boolean visible){
        if (visible){
            view.setVisibility(View.VISIBLE);
        }else{
            view.setVisibility(View.INVISIBLE);
        }
    }
}