package com.example.music_app.repository;


import com.example.music_app.dto.SongDTO;
import com.example.music_app.entity.AlbumEntity;
import com.example.music_app.entity.CategoryEntity;
import com.example.music_app.entity.SongsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface SongRepository extends JpaRepository<SongsEntity, Long> {
    List<SongsEntity> findByCategory(CategoryEntity categoryEntity);
    List<SongsEntity> findByAlbum(AlbumEntity albumEntity);
    List<SongsEntity> findByNameContaining(String keyword);
    @Query(value = "SELECT songs.songid AS songid, songs.name AS name, songs.singer AS singer, songs.link AS link, songs.categoryid AS categoryid, songs.albumid AS albumId "
            + "FROM favorite "
            + "INNER JOIN songs ON favorite.songid = songs.songid "
            + "GROUP BY songs.songid "
            + "ORDER BY COUNT(favorite.songid) DESC "
            + "LIMIT 7", nativeQuery = true)
    List<SongsEntity> getTop7Favorite();
}
