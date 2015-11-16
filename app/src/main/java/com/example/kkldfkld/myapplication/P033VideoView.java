package com.example.kkldfkld.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.widget.VideoView;
import android.widget.RelativeLayout;

//import android.media.session.MediaController;
import android.widget.MediaController;

public class P033VideoView extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout=new RelativeLayout(this);

        VideoView videoView=new VideoView(this);
        relativeLayout.addView(videoView);

        setContentView(relativeLayout);

        videoView.setVideoPath("all url address");

        MediaController mediaController=new MediaController(P033VideoView.this);
        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);
        videoView.start();

    }
}

/*
import android.app.Activity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

public class P033VideoView extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout=new RelativeLayout(this);
        VideoView videoView=new VideoView(this);
        MediaController mediaController=new MediaController(this);

        relativeLayout.addView(videoView);

        videoView.setVideoPath("http://www.thenewboston.com/forum/project_files/006_testVideo.mp4");
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();

        setContentView(relativeLayout);


    }

}*/
