package edu.bo.uyunicode.template.admin.infrastructure.output.persistence.repository;

import edu.bo.uyunicode.template.admin.infrastructure.output.persistence.entity.RoleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IRoleRepository extends JpaRepository<RoleEntity, Integer> {

    @Query("""
            SELECT r
            FROM RoleEntity r
            WHERE (:roleId IS NULL OR r.roleId = :roleId) AND
                (:name IS NULL OR r.name = :name) AND
                (:description IS NULL OR r.description = :description) AND
                (:isEnabled IS NULL OR r.isEnabled = :isEnabled)
            """)
    Page<RoleEntity> findByFilter(@Param("roleId") Integer roleId,
                                  @Param("name") String name,
                                  @Param("description") String description,
                                  @Param("isEnabled") Boolean isEnabled,
                                  Pageable pageable);
}
