package com.zszgroup.epidemicbigdata.service;

import com.zszgroup.epidemicbigdata.pojo.Area;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 910678508
* @description 针对表【area】的数据库操作Service
* @createDate 2023-01-04 19:56:46
*/
public interface AreaService extends IService<Area> {
    List<Area> findAll();

    Area findAreaByName(String name);
}
