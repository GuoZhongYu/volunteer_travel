package hue.edu.xiong.volunteer_travel.model;

import lombok.Data;

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
@Table(name = "inn")
public class Inn {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "license")
    private String license;

    @Column(name = "id_card")
    private String idCard;

}









