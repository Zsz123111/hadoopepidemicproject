package com.zszgroup.epidemicbigdata.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zszgroup.epidemicbigdata.pojo.*;
import com.zszgroup.epidemicbigdata.service.AlldataService;
import com.zszgroup.epidemicbigdata.mapper.AlldataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
* @author 91067
* @description 针对表【alldata】的数据库操作Service实现
* @createDate 2023-01-05 10:38:26
*/
@Service
public class AlldataServiceImpl extends ServiceImpl<AlldataMapper, Alldata> implements AlldataService{
    @Autowired
    AlldataMapper alldataMapper;
    @Override
    public int findAllCountDiagnosedByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int num = alldataMapper.selectSumAllDiagnosedByDate(calendar.get(Calendar.YEAR));
        return num;
    }

    @Override
    public int findAllCountSecureByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int num = alldataMapper.selectSumAllSecureByDate(calendar.get(Calendar.YEAR));
        return num;
    }

    @Override
    public int findAllCountDeadByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int num = alldataMapper.selectSumAllDeadByDate(calendar.get(Calendar.YEAR));
        return num;
    }

    @Override
    public int findNewCountDiagnosedByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int num = alldataMapper.selectSumNewDiagnosedByDate(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1,date.getDay()+1);
        return num;
    }

    @Override
    public int findNewCountSecureByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int num = alldataMapper.selectSumNewSecureByDate(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1,date.getDay()+1);
        return num;
    }

    @Override
    public int findNewCountDeadByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int num = alldataMapper.selectSumNewDeadByDate(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1,date.getDay()+1);
        return num;
    }

    @Override
    public int findNewCountAsymptomaticByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int num = alldataMapper.selectSumNewAsymptomaticByDate(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1,date.getDay()+1);
        return num;
    }

    @Override
    public List<NewDiagnosed> findFiveDiagnosed(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        List<NewDiagnosed> list = alldataMapper.selectFiveDiagnosedByDate(calendar.get(Calendar.YEAR),date.getMonth()+1,date.getDay()+1);
        return list;
    }

    @Override
    public List<NewSecure> findFiveSecure(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        List<NewSecure> list = alldataMapper.selectFiveSecureByDate(calendar.get(Calendar.YEAR),date.getMonth()+1,date.getDay()+1);
        return list;
    }

    @Override
    public List<NewDead> findFiveDead(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        List<NewDead> list = alldataMapper.selectFiveDeadByDate(calendar.get(Calendar.YEAR),date.getMonth()+1,date.getDay()+1);
        return list;
    }

    @Override
    public List<NewAsymptomatic> findFiveAsymptomatic(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        List<NewAsymptomatic> list = alldataMapper.selectFiveAsymptomaticByDate(calendar.get(Calendar.YEAR),date.getMonth()+1,date.getDay()+1);
        return list;
    }

    @Override
    public int findProvinceDiagnosedByDateAndId(Date date, int pid) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        QueryWrapper<Alldata> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pid",pid).eq("year",calendar.get(Calendar.YEAR)).eq("month",calendar.get(Calendar.MONTH)+1).eq("day",date.getDay()+1);
        List<Alldata> alldata = alldataMapper.selectList(queryWrapper);
        return alldata.get(0).getConfins();
    }

    @Override
    public int findProvinceSecureByDateAndId(Date date, int pid) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        QueryWrapper<Alldata> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pid",pid).eq("year",calendar.get(Calendar.YEAR)).eq("month",calendar.get(Calendar.MONTH)+1).eq("day",date.getDay()+1);
        List<Alldata> alldata = alldataMapper.selectList(queryWrapper);
        return alldata.get(0).getHealins();
    }

    @Override
    public int findProvinceDeadByDateAndId(Date date, int pid) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        QueryWrapper<Alldata> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pid",pid).eq("year",calendar.get(Calendar.YEAR)).eq("month",calendar.get(Calendar.MONTH)+1).eq("day",date.getDay()+1);
        List<Alldata> alldata = alldataMapper.selectList(queryWrapper);
        return alldata.get(0).getDeadins();
    }

    @Override
    public int findProvinceAsymptomaticByDateAndId(Date date, int pid) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        QueryWrapper<Alldata> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pid",pid).eq("year",calendar.get(Calendar.YEAR)).eq("month",calendar.get(Calendar.MONTH)+1).eq("day",date.getDay()+1);
        List<Alldata> alldata = alldataMapper.selectList(queryWrapper);
        return alldata.get(0).getNosymins();
    }
}




