package vn.iotstar.service;

import java.util.List;
import java.util.Optional;

import vn.iotstar.entity.Video;
import vn.iotstar.entity.Category;

public interface VideoService {

    List<Video> findAll();

    Optional<Video> findById(Long id);

    Video save(Video video);

    void deleteById(Long id);

    List<Video> findByCategory(Category category);
}
