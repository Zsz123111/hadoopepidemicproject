package com.zszgroup.epidemicbigdata.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zszgroup.epidemicbigdata.pojo.Area;
import com.zszgroup.epidemicbigdata.service.AreaService;
import com.zszgroup.epidemicbigdata.mapper.AreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 910678508
* @description 针对表【area】的数据库操作Service实现
* @createDate 2023-01-04 19:56:46
*/
@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements AreaService{
    @Autowired
    AreaMapper areaMapper;

    @Override
    public List<Area> findAll() {
        List<Area> areas = areaMapper.selectList(null);
        return areas;
    }

    @Override
    public Area findAreaByName(String name) {
        QueryWrapper<Area> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("prov",name);
        List<Area> areas = areaMapper.selectList(queryWrapper);
        return areas.get(0);
    }
}




