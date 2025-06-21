package edu.bo.uyunicode.template.admin.infrastructure.output.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "t_role")
public class RoleEntity {
    @Id
    @Column(name = "role_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "description", nullable = false, length = 200)
    private String description;
    @Column(name = "isEnabled", nullable = false, length = 1)
    private Boolean isEnabled;
}
