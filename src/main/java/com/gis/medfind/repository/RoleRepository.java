package com.gis.medfind.repository;

import com.gis.medfind.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query(value = 
                "SELECT r.name, r.id FROM role r "+
                "INNER JOIN privileges_roles pr "+
                "ON pr.role_id = r.id "+
                "WHERE r.name = :name", nativeQuery = true)
    /**@Query(value = 
                "SELECT r FROM role r "+
                "WHERE r.name = :name", nativeQuery = true)**/
    Role findByName(@Param("name") String name);
}
