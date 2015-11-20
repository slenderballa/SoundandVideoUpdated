package com.example.gswe4645.soundandvideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.*;
import android.net.Uri;


public class VideoActivity extends Activity
{

    private VideoView myPlayer;
    private Button returnButton;
    private MediaController myVideoController;
    private Uri videoLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        myPlayer = (VideoView) findViewById(R.id.videoView);
        returnButton = (Button) findViewById(R.id.homeButton);

        videoLocation = Uri.parse("android.resource://" + getPackageCodePath() + "/" + R.raw.basketballvine);
        myVideoController = new MediaController(this);

        setupMedia();
        setupListeners();
    }

    private void setupMedia()
    {

        myPlayer.setMediaController(myVideoController);
        myPlayer.setVideoURI(videoLocation);

    }

    private void setupListeners()
    {
    returnButton.setOnClickListener(new View.OnClickListener() {
        @Override
                public void onClick(View currentView) {

            Intent returnIntent = new Intent();

            setResult(RESULT_OK, returnIntent);

            finish();
        } });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sound, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
