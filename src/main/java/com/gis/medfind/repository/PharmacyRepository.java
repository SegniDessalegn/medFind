package com.gis.medfind.repository;

import java.util.List;
import com.gis.medfind.entity.Pharmacy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy,Long> {
    @Query(value = "SELECT phc.pharmacy_id, *"
                    + "FROM pharmacy phc, region rgn "
                    + "WHERE ST_Within(phc.pharmacy_location, rgn.region_boundary) AND rgn.region_id= :regionId"
    , nativeQuery = true)
    List<Pharmacy> findAllPharmacyWithInRegion(@Param("regionId")  Long regionId);

    @Query(value = "SELECT phc.id, phc.name, phc.location, ST_Distance(phc.location,ST_SetSRID(ST_Point(:userLongitude,:userLatitude),4326)) AS distance "
        + "FROM pharmacy phc "
        + "ORDER BY distance"
        + "LIMIT 45", nativeQuery = true)
    List<Pharmacy> findAllPharmaciesByDistanceFromUser(@Param("userLongitude") Double userLon, @Param("userLatitude")  Double userLat);
    
    
    @Query(value = "SELECT pcy FROM pharmacy pcy WHERE pcy.name = :name", nativeQuery = true)
    Pharmacy getByName(@Param("name") String name);
}
