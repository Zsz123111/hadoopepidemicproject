package com.zszgroup.epidemicbigdata.service;

import com.zszgroup.epidemicbigdata.pojo.*;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;

/**
* @author 91067
* @description 针对表【alldata】的数据库操作Service
* @createDate 2023-01-05 10:38:26
*/
public interface AlldataService extends IService<Alldata> {
    int findAllCountDiagnosedByDate(Date date);
    int findAllCountSecureByDate(Date date);
    int findAllCountDeadByDate(Date date);

    int findNewCountDiagnosedByDate(Date date);
    int findNewCountSecureByDate(Date date);
    int findNewCountDeadByDate(Date date);
    int findNewCountAsymptomaticByDate(Date date);

    List<NewDiagnosed> findFiveDiagnosed(Date date);
    List<NewSecure> findFiveSecure(Date date);
    List<NewDead> findFiveDead(Date date);
    List<NewAsymptomatic> findFiveAsymptomatic(Date date);

    int findProvinceDiagnosedByDateAndId(Date date,int pid);
    int findProvinceSecureByDateAndId(Date date,int pid);
    int findProvinceDeadByDateAndId(Date date,int pid);
    int findProvinceAsymptomaticByDateAndId(Date date,int pid);
}
