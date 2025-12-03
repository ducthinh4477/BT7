package vn.iotstar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.entity.Video;
import vn.iotstar.entity.Category;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

    List<Video> findByCategory(Category category);

}
