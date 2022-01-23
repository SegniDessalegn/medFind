package com.gis.medfind;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.n52.jackson.datatype.jts.JtsModule;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.annotation.Rollback;
 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class JsonTest {

    @Test
    void testJson() throws IOException {

        var objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JtsModule());

        GeometryFactory gf = new GeometryFactory();
        Point point = gf.createPoint(new Coordinate(18.05, 85.89));

        String geojson = objectMapper.writeValueAsString(point);

        InputStream targetStream = new ByteArrayInputStream(geojson.getBytes());
        Point point2 = objectMapper.readValue(targetStream, Point.class);

        assertThat(point.equals(point2)).isEqualTo(true);
    }
    
}
