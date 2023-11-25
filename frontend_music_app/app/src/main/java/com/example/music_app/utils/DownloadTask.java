package com.example.music_app.utils;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.Manifest;
import android.os.Environment;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.music_app.DownloadSong;
import com.example.music_app.model.Song;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DownloadTask {
    public static void startDownloading(Context context, String url, String title) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED) {
                String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                ActivityCompat.requestPermissions((Activity) context, permissions, 1000);
            } else {
                performDownload(context, url, title);
            }
        } else {
            performDownload(context, url, title);
        }
    }

    private static void performDownload(Context context, String url, String title) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle(title);
        request.setDescription("Downloading file ...");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, title);

        DownloadManager manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    public static void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults, Context context) {
        switch (requestCode) {
            case 1000:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    Toast.makeText(context, "Permission Denied...!", Toast.LENGTH_SHORT).show();
                }
        }
    }

    public static void getSongFile(Context context, Activity activity) {
        if(ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 999);
            return;
        }
        List<File> files = new ArrayList<>();

        String downloadsPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();

        File downloadDir = new File(downloadsPath);

        if(downloadDir.exists() && downloadDir.isDirectory()) {
            File[] files1 = downloadDir.listFiles();
            if(files1 != null) {
                files.addAll(Arrays.asList(files1));
            }
        }
        List<Song> songs = new ArrayList<>();
        for (File file : files) {
            Song song = new Song();
            String str = file.getName();
            String[] parts = str.split("-");
            song.setName(parts[0].trim());
            song.setSinger(parts[1].trim());
            song.setLink(file.getAbsolutePath());
            songs.add(song);
        }
        Utility.downloadFavorite = songs;
    }

    public static void deleteSong(Context context, Activity activity, Song song) {
        if(ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 999);
            return;
        }
        List<File> files = new ArrayList<>();

        String downloadsPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();

        File downloadDir = new File(downloadsPath);

        if(downloadDir.exists() && downloadDir.isDirectory()) {
            File[] files1 = downloadDir.listFiles();
            if(files1 != null) {
                files.addAll(Arrays.asList(files1));
            }
        }
        String text = song.getName() + " - " + song.getSinger();
        for (File file : files) {
            if(file.getName().equals(text)) {
                if(file.delete()) {
                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context, "Xóa không thành công", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }
}
