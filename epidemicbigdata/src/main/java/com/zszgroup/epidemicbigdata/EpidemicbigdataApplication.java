package com.zszgroup.epidemicbigdata;

import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.zszgroup.epidemicbigdata.mapper")
public class EpidemicbigdataApplication {

    public static void main(String[] args) {
        SpringApplication.run(EpidemicbigdataApplication.class, args);
    }

}
