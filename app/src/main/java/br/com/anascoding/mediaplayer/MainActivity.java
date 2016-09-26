package br.com.anascoding.mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnTocar = null;
    private MediaPlayer mediaPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTocar = (Button) findViewById(R.id.btnTocar);
        mediaPlayer = MediaPlayer.create(this, R.raw.music);

        btnTocar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    pausarMusica();
                } else {
                    tocarMusica();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release(); //liberar os recursos de memória utilizado pelo MediaPlayer
            mediaPlayer = null;
        }

        super.onDestroy();
    }

    private void tocarMusica() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
            btnTocar.setText(R.string.pausar);
        }
    }

    private void pausarMusica() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            btnTocar.setText(R.string.tocar);
        }
    }
}