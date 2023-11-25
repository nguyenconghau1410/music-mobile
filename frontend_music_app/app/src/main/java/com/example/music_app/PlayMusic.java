package com.example.music_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.ListFragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.music_app.adapter.ViewPagerAdapter1;
import com.example.music_app.fragments.LyricsFragment;
import com.example.music_app.fragments.PlayMusicFragment;
import com.example.music_app.fragments.SongListFragment;
import com.example.music_app.model.Song;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayMusic extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView timeSong, total, title, singer;
    private SeekBar seekBar;
    private ImageButton random, pre, play, next,repeat;
    public static MediaPlayer mediaPlayer;
    private ViewPager viewPager;
    private static ViewPagerAdapter1 viewPagerAdapter1;
    private PlayMusicFragment playMusicFragment = new PlayMusicFragment();
    private SongListFragment songListFragment = new SongListFragment();
    private LyricsFragment lyricsFragment = new LyricsFragment();
    public static List<Song> songs = new ArrayList<>();
    public static Song save = new Song();

    public static int position = 0;
    boolean repeat1 = false;
    boolean checkRandom = false;
    boolean next1 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        init();

        viewPagerAdapter1 = new ViewPagerAdapter1(getSupportFragmentManager());
        viewPagerAdapter1.AddFragment(songListFragment);
        viewPagerAdapter1.AddFragment(playMusicFragment);
        viewPagerAdapter1.AddFragment(lyricsFragment);
        viewPager.setAdapter(viewPagerAdapter1);

        viewPager.setCurrentItem(1);

        eventClick();

    }

    private void eventClick() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(viewPagerAdapter1.getItem(1) != null) {
                    if(songs.size() > 0) {
                        handler.removeCallbacks(this);
                    }
                    else {
                        handler.postDelayed(this, 300);
                    }
                }
            }
        }, 500);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    play.setImageResource(R.drawable.baseline_play_circle_outline_24);
                    PlayMusicFragment.objectAnimator.pause();
                }
                else {
                    mediaPlayer.start();
                    play.setImageResource(R.drawable.outline_pause_circle_24);
                    PlayMusicFragment.objectAnimator.resume();
                }
            }
        });
        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(repeat1 == false) {
                    if(checkRandom == true) {
                        checkRandom = false;
                        repeat.setImageResource(R.drawable.baseline_repeat_24_true);
                        random.setImageResource(R.drawable.baseline_moving_24);
                    }
                    else {
                        repeat.setImageResource(R.drawable.baseline_repeat_24_true);
                        repeat1 = true;
                    }
                }
                else {
                    repeat.setImageResource(R.drawable.baseline_repeat_24);
                    repeat1 = false;
                }
            }
        });
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkRandom == false) {
                    if(repeat1 == true) {
                        repeat1 = false;
                        random.setImageResource(R.drawable.baseline_moving_24_true);
                        repeat.setImageResource(R.drawable.baseline_repeat_24);
                    }
                    else {
                        checkRandom = true;
                        random.setImageResource(R.drawable.baseline_moving_24_true);
                    }
                }
                else {
                    random.setImageResource(R.drawable.baseline_moving_24);
                    checkRandom = false;

                }
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(songs.size() > 0) {
                    if(mediaPlayer.isPlaying() || mediaPlayer != null) {
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                    if(position < (songs.size())) {
                        play.setImageResource(R.drawable.outline_pause_circle_24);
                        ++position;
                        if(repeat1 == true) {
                            if(position == 0) {
                                position = songs.size();
                            }
                            position -= 1;
                        }
                        if(checkRandom == true) {
                            Random random1 = new Random();
                            int index = random1.nextInt(songs.size());
                            if(index == position) {
                                position = index - 1;
                            }
                            position = index;
                        }
                        if(position > songs.size() - 1) {
                            position = 0;
                        }
                        new PlayMP3().execute(songs.get(position).getLink());
                        save = songs.get(position);
                        songListFragment.setInfoSong();
                        title.setText(songs.get(position).getName());
                        singer.setText(songs.get(position).getSinger());
                        updateTime();
                    }
                }
                pre.setClickable(false);
                next.setClickable(false);
                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pre.setClickable(true);
                        next.setClickable(true);
                    }
                }, 5000);
            }
        });
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(songs.size() > 0) {
                    if(mediaPlayer.isPlaying() && mediaPlayer != null) {
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                    if(position < songs.size()) {
                        play.setImageResource(R.drawable.outline_pause_circle_24);
                        --position;
                        if(repeat1 == true) {
                            if(position == 0) {
                                position = songs.size();
                            }
                            position -= 1;
                        }
                        if(checkRandom == true) {
                            Random random1 = new Random();
                            int index = random1.nextInt(songs.size());
                            if(index == position) {
                                position = index - 1;
                            }
                            position = index;
                        }
                        if(position < 0) {
                            position = songs.size() - 1;
                        }
                        new PlayMP3().execute(songs.get(position).getLink());
                        save = songs.get(position);
                        songListFragment.setInfoSong();
                        title.setText(songs.get(position).getName());
                        singer.setText(songs.get(position).getSinger());
                        updateTime();
                    }
                }
                next.setClickable(false);
                pre.setClickable(false);
                Handler handler1  = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        next.setClickable(true);
                        pre.setClickable(true);
                    }
                }, 5000);
            }
        });
    }


    private void init() {
        toolbar = findViewById(R.id.toolbarPlayMusic);
        timeSong = findViewById(R.id.textViewPlayMusicTimeSong);
        total = findViewById(R.id.textViewPlayMusicTotalTimeSong);
        seekBar = findViewById(R.id.seekBarSong);
        random = findViewById(R.id.imageButtonRamdom);
        pre = findViewById(R.id.imageButtonPreView);
        play = findViewById(R.id.imageButtonPlay);
        next = findViewById(R.id.imageButtonNextView);
        repeat = findViewById(R.id.imageButtonRepeat);
        viewPager = findViewById(R.id.viewPagerPlayMusic);
        title = findViewById(R.id.textViewPlayMusicTitle);
        singer = findViewById(R.id.textViewPlayMusicSinger);

        Song song = (Song) getIntent().getSerializableExtra("song");
        songs = (List<Song>) getIntent().getSerializableExtra("songList");
        title.setText(song.getName()); singer.setText(song.getSinger());

        toolbar.setNavigationIcon(R.drawable.baseline_keyboard_arrow_down_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                mediaPlayer.stop();
                songs.clear();
            }
        });


        if(songs.size() > 0) {
            new PlayMP3().execute(song.getLink());
            save = song;
            play.setImageResource(R.drawable.outline_pause_circle_24);
        }

    }

    public class PlayMP3 extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            return strings[0];
        }

        @Override
        protected void onPostExecute(String song) {
            super.onPostExecute(song);
            try {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mediaPlayer.stop();
                        play.setImageResource(R.drawable.baseline_play_circle_outline_24);
                        PlayMusicFragment.objectAnimator.pause();
                    }
                });
                mediaPlayer.setDataSource(song);
                mediaPlayer.prepare();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            mediaPlayer.start();
            TimeSong();
            updateTime();
        }

    }
    private void TimeSong() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        total.setText(simpleDateFormat.format(mediaPlayer.getDuration()));
        seekBar.setMax(mediaPlayer.getDuration());
    }
    private void updateTime() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(mediaPlayer != null) {
                    seekBar.setProgress(mediaPlayer.getCurrentPosition());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
                    timeSong.setText(simpleDateFormat.format(mediaPlayer.getCurrentPosition()));
                    handler.postDelayed(this, 300);
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            next1 = true;
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    });
                }
            }
        }, 300);
        Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(next1 == true) {
                    if(songs.size() > 0) {
                        if(mediaPlayer.isPlaying() || mediaPlayer != null) {
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            mediaPlayer = null;
                        }
                        if(position < (songs.size())) {
                            play.setImageResource(R.drawable.outline_pause_circle_24);
                            ++position;
                            if(repeat1 == true) {
                                if(position == 0) {
                                    position = songs.size();
                                }
                                position -= 1;
                            }
                            if(checkRandom == true) {
                                Random random1 = new Random();
                                int index = random1.nextInt(songs.size());
                                if(index == position) {
                                    position = index - 1;
                                }
                                position = index;
                            }
                            if(position > songs.size() - 1) {
                                position = 0;
                            }
                            new PlayMP3().execute(songs.get(position).getLink());
                            save = songs.get(position);
                            songListFragment.setInfoSong();
                            title.setText(songs.get(position).getName());
                            singer.setText(songs.get(position).getSinger());
                        }
                    }
                    pre.setClickable(false);
                    next.setClickable(false);
                    Handler handler1 = new Handler();
                    handler1.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            pre.setClickable(true);
                            next.setClickable(true);
                        }
                    }, 5000);
                    next1 = false;
                    handler1.removeCallbacks(this);
                } else {
                    handler1.postDelayed(this, 1000);
                }
            }
        },  1000);
    }
}