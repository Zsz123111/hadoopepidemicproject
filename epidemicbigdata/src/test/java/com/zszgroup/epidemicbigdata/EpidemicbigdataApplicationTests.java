package com.zszgroup.epidemicbigdata;

import com.zszgroup.epidemicbigdata.pojo.Area;
import com.zszgroup.epidemicbigdata.service.AlldataService;
import com.zszgroup.epidemicbigdata.service.AreaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class EpidemicbigdataApplicationTests {
    @Autowired
    AlldataService alldataService;
    @Autowired
    AreaService areaService;
    @Test
    void contextLoads() {
        Area area = areaService.findAreaByName("北京");
        System.out.println(area);
    }

}
