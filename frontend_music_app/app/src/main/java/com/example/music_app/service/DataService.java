package com.example.music_app.service;

import com.example.music_app.model.Advertisement;
import com.example.music_app.model.Album;
import com.example.music_app.model.Category;
import com.example.music_app.model.Playlist;
import com.example.music_app.model.Song;
import com.example.music_app.model.Topic;
import com.example.music_app.model.User;
import com.example.music_app.model_spotify.PlaylistSpotify;
import com.example.music_app.model_spotify.Token;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface DataService {
    @GET("topic/all")
    Call<List<Topic>> getAllTopic();
    @GET("album/all")
    Call<List<Album>> getAllAlbum();
    @POST("auth/authenticate")
    Call<User> getUser(@Body User user);
    @POST("auth/register")
    Call<User> register(@Body User user);
    @POST("category/{id}")
    Call<List<Category>> getCategoryByTopic(@Path("id") Long id);
    @POST("song/category/{id}")
    Call<List<Song>> getSongByCategory(@Path("id") Long id);
    @POST("song/album/{id}")
    Call<List<Song>> getSongByAlbum(@Path("id") Long id);
    @POST("category/one/{id}")
    Call<Category> findOneByCategoryid(@Path("id") Long id);
    @POST("album/one/{id}")
    Call<Album> findOneByAlbumid(@Path("id") Long id);
    @POST("favorite/{id}")
    Call<Void> insertFavorite(@Path("id") Long id, @Body Song song);
    @DELETE("favorite/{id}")
    Call<Void> deleteFavorite(@Path("id") Long id, @Query("songid") Long songid);
    @POST("playlist/myPlaylist/{id}")
    Call<Playlist> insertPlaylist(@Path("id") Long id, @Body Playlist playlist);
    @POST("playlist/addSong/{id}")
    Call<Song> insertSongOnPlaylist(@Path("id") Long id, @Body Song song);
    @POST("playlist/getSong/{id}")
    Call<List<Song>> getSongsInYourPlaylis(@Path("id") Long id);
    @GET("song/search")
    Call<List<Song>> getSongsByKeyword(@Query("keyword") String keyword);
    @GET("song/top7")
    Call<List<Song>> getTop7Favorite();
    @GET("advertise")
    Call<List<Advertisement>> findAll();
    // call api spotify
    @FormUrlEncoded
    @POST("token")
    Call<Token> getAccessToken(
            @Header("Authorization") String authorization,
            @Field("grant_type") String grantType
    );
    @GET("playlists/{id}")
    Call<PlaylistSpotify> getPlaylistSpotify(
            @Header("Authorization") String authorization,
            @Path("id") String id
    );

}
