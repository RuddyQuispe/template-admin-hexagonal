package edu.bo.uyunicode.template.admin.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_user")
@Getter
@Setter
public class UserEntity {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(name = "nickname", nullable = false, length = 100)
    private String nickname;
    @Column(name = "username", nullable = false, length = 200)
    private String username;
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Column(name = "is_enabled", nullable = false)
    private Boolean isEnabled;
}
