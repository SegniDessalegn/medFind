package com.gis.medfind.RepositoryTests;

import static org.assertj.core.api.Assertions.assertThat;

import com.gis.medfind.entity.Pharmacy;
import com.gis.medfind.entity.Server;
import com.gis.medfind.entity.User;
import com.gis.medfind.repository.PharmacyRepository;

import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class PharmacyRepositoryTest {
 
    @Autowired
    private TestEntityManager entityManager;
     
    @Autowired
    private PharmacyRepository pharmRepo;
     
    @Autowired
    private GeometryFactory geometryFactory;
     
    @Test
    public void testCreatePharmacy() {
        
        Pharmacy pharm = new Pharmacy();
        Coordinate loc = new Coordinate(52.003, 25.478);
        pharm.setLocation(geometryFactory.createPoint(loc));
        pharm.setAddress("Addis Ababa");
        pharm.setName("ST. Markos");
        pharm.setOwner(new User());
        pharm.setPharmacyServer(new Server());
        Pharmacy savedPharmacy = pharmRepo.save(pharm);
        
        Pharmacy existPharmacy = entityManager.find(Pharmacy.class, savedPharmacy.getId());
        
        assertThat(pharm.getName()).isEqualTo(existPharmacy.getName());
        
    }
}
