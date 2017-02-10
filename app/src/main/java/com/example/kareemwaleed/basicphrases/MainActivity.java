package com.example.kareemwaleed.basicphrases;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<MediaPlayer> phrases;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       prepare();
    }

    public void buttonClicked(View view)
    {
        stop();
        Object temp = view.getTag();
        int buttonTag = Integer.parseInt(temp.toString());
        phrases.get(buttonTag).start();
    }

    private void prepare()
    {
        phrases = new ArrayList<MediaPlayer>();

        phrases.add(MediaPlayer.create(this, R.raw.hello));
        phrases.add(MediaPlayer.create(this, R.raw.gm));
        phrases.add(MediaPlayer.create(this, R.raw.hru));
        phrases.add(MediaPlayer.create(this, R.raw.excuseme));
        phrases.add(MediaPlayer.create(this, R.raw.please));
        phrases.add(MediaPlayer.create(this, R.raw.cu));
        phrases.add(MediaPlayer.create(this, R.raw.sorry));
        phrases.add(MediaPlayer.create(this, R.raw.goodbye));
    }

    private void stop()
    {
        for(MediaPlayer phrase : phrases)
        {
            if(phrase.isPlaying())
                phrase.stop();
        }
    }
}
