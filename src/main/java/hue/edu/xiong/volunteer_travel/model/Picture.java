package hue.edu.xiong.volunteer_travel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author : orange
 * @date : 2019/5/3
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "picture")
public class Picture {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "original_name")
    private String originalName;

    @Column(name = "path")
    private String path;

}
