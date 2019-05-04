package hue.edu.xiong.volunteer_travel.repository;

import hue.edu.xiong.volunteer_travel.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : orange
 * @date : 2019/5/3
 */
@Repository
public interface PictureRepository extends JpaRepository<Picture, String> {
}
