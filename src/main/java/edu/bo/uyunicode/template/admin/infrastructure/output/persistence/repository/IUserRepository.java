package edu.bo.uyunicode.template.admin.infrastructure.output.persistence.repository;

import edu.bo.uyunicode.template.admin.infrastructure.output.persistence.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends JpaRepository<UserEntity, Integer> {

    @Query("""
            SELECT u
            FROM UserEntity u
            WHERE (:userId IS NULL OR u.userId = :userId)
                AND (:nickname IS NULL OR u.nickname = :nickname)
                AND (:username IS NULL OR u.username = :username)
                AND (:password IS NULL OR u.password = :password)
                AND (:isEnabled IS NULL OR u.isEnabled = :isEnabled)
            """)
    Page<UserEntity> findAllByFilters(@Param("userId") Integer userId,
                                      @Param("nickname") String nickname,
                                      @Param("username") String username,
                                      @Param("password") String password,
                                      @Param("isEnabled") Boolean isEnabled,
                                      Pageable pageable);
}
