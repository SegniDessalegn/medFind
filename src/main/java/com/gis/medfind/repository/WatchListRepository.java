package com.gis.medfind.repository;
import com.gis.medfind.entity.WatchList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchListRepository extends JpaRepository<WatchList, Long> {
}


