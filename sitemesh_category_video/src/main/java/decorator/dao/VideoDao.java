package decorator.dao;

import java.util.List;

import decorator.entity.Video;

public interface VideoDao {
	Video create(Video v);
    Video update(Video v);
    void delete(Long id);
    Video findById(Long id);
    List<Video> findAll();
    List<Video> searchByTitle(String keyword);
}
