package com.gis.medfind.ServiceImplementationTests;

import java.util.List;

//import static org.assertj.core.api.Assertions.assertThat;

import com.gis.medfind.repository.RegionRepository;
import com.gis.medfind.serviceImplem.SearchByRegionServiceImpl;

import com.gis.medfind.entity.Pharmacy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class SearchByRegionServiceImplTest {
    
    @Autowired
    private SearchByRegionServiceImpl searchService;

    @Autowired
    private RegionRepository regionRepo;


    @Test
    public void testFindPharmaciesWithInRegion() {
        String region = "Bole";
        List<Pharmacy> bole_pharms = searchService
            .findPharmaciesWithInRegion(
                regionRepo.findByName(region).getId(), 
                "Aceon"
            );
        System.out.println(bole_pharms.get(10).getName());
       
    }
}
