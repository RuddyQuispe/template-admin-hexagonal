package edu.bo.uyunicode.template.admin.infrastructure.persistence.repository;

import edu.bo.uyunicode.template.admin.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
}
