package com.example.pccs_0007.youtubetest;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ChannelListResponse;

import java.io.IOException;
import java.util.HashMap;

import static com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import static com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import static com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import static com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import static com.google.android.youtube.player.YouTubePlayer.PlayerStyle;
import static com.google.android.youtube.player.YouTubePlayer.Provider;

public class BasicPlayerActivity extends YouTubeBaseActivity implements OnInitializedListener {
    public static final String API_KEY = "AIzaSyBx7v0YOb140fDO7EbfMx4l87raxezDWFw";

    //https://www.youtube.com/watch?v=<VIDEO_ID>
    public static final String VIDEO_ID = "8bNlffXEcC0";
    public static final String CHANNEL_ID ="UCqwUrj10mAEsqezcItqvwEw";
   // https://www.youtube.com/channel/UCqwUrj10mAEsqezcItqvwEw
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // attaching layout xml
        setContentView(R.layout.activity_basic_player);

        // Initializing YouTube player view
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_view);
        youTubePlayerView.initialize(API_KEY, this);

      //  https://www.googleapis.com/youtube/v3/channels

    }


    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult result) {
        Toast.makeText(this, "Failed to initialize.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
        if(null== player) return;
        // Start buffering
        if (!wasRestored) {
          //  player.cueVideo(VIDEO_ID);
           // player.cueVideos(CHANNEL_ID);

            player.cuePlaylist(CHANNEL_ID);

        }

        // Add listeners to YouTubePlayer instance
        player.setPlayerStateChangeListener(new PlayerStateChangeListener() {
            @Override public void onAdStarted() { }
            @Override public void onError(ErrorReason arg0) { }
            @Override public void onLoaded(String arg0) { }
            @Override public void onLoading() { }
            @Override public void onVideoEnded() { }
            @Override public void onVideoStarted() { }
        });


        player.setPlaybackEventListener(new PlaybackEventListener() {
            @Override public void onBuffering(boolean arg0) { }
            @Override public void onPaused() { }
            @Override public void onPlaying() { }
            @Override public void onSeekTo(int arg0) { }
            @Override public void onStopped() { }
        });
    }

}