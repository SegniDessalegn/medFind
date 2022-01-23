package com.gis.medfind.repository;

import com.gis.medfind.entity.Server;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<Server,Long> {
}
