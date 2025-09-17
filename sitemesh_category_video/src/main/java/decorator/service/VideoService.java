package decorator.service;

import java.util.List;

import decorator.entity.Video;

public interface VideoService {
	Video create(Video v);
    Video update(Video v);
    void delete(Long id);
    Video findById(Long id);
    List<Video> findAll();
    List<Video> search(String keyword);
}
