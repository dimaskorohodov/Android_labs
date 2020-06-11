package com.example.myapplication4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    // https://pixabay.com/ru/videos/%D0%BF%D0%B5%D0%B9%D0%B7%D0%B0%D0%B6-%D0%BF%D1%80%D0%B8%D1%80%D0%BE%D0%B4%D0%B0-%D0%B3%D0%BE%D1%80%D1%8B-%D1%80%D1%83%D1%87%D0%B5%D0%B9-%D1%80%D0%B5%D0%BA%D0%B0-757/

    private final int REQUEST_CODE_CHOOSE_MEDIA = 100;

    private TextView fileURIView;
    private VideoView videoView;
    private EditText uriEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView);
        uriEditText = findViewById(R.id.uriEditText);
        fileURIView = findViewById(R.id.currentTextView);
    }

    public void OnPlayButtonClick(View view) {
        videoView.start();
    }

    public void OnPauseButtonClick(View view) {
        videoView.pause();
    }

    public void OnStopButtonClick(View view) {
        videoView.stopPlayback();
        videoView.resume();
    }

    public void OnOpenButtonClick(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_MIME_TYPES, new String[]{ "video/*", "audio/*"});
        startActivityForResult(intent, 100);
    }

    public void OnLoadButtonClick(View view) {
        Uri uri = Uri.parse(uriEditText.getText().toString());

        if (uri == null) {
            fileURIView.setText("Oooops something went wrong!");
            return;
        }

        videoView.setVideoURI(uri);
        fileURIView.setText(uri.getPath());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data == null) return;

        if (requestCode == REQUEST_CODE_CHOOSE_MEDIA) {
            Uri uri = data.getData();

            if (uri == null) {
                fileURIView.setText("Oooops something went wrong!");
                return;
            }

            videoView.setVideoURI(uri);
            fileURIView.setText(uri.getPath());
        }
    }
}
