package com.zszgroup.epidemicbigdata.controller;

import com.zszgroup.epidemicbigdata.mapper.AlldataMapper;
import com.zszgroup.epidemicbigdata.pojo.*;
import com.zszgroup.epidemicbigdata.service.AlldataService;
import com.zszgroup.epidemicbigdata.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

@RestController
public class AjaxController {
    @Autowired
    AlldataService alldataService;
    @Autowired
    AreaService areaService;

    @GetMapping("/everydayMsg")
    public EverydayMsg getEverydatMsg(){
        EverydayMsg everydayMsg = new EverydayMsg();
        String dateString = "2022-12-13";
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        everydayMsg.setNewDiagnosed(alldataService.findNewCountDiagnosedByDate(date));
        everydayMsg.setNewSecure(alldataService.findNewCountSecureByDate(date));
        everydayMsg.setNewDead(alldataService.findNewCountDeadByDate(date));
        everydayMsg.setNewAsymptomatic(alldataService.findNewCountAsymptomaticByDate(date));
        return everydayMsg;
    }

    @GetMapping("/provinceMsg")
    public ProvinceMsg getProvinceMsg(){
        ProvinceMsg provinceMsg = new ProvinceMsg();
        String dateString = "2022-12-13";
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        provinceMsg.setBeijingDiagnosed(alldataService.findProvinceDiagnosedByDateAndId(date,110000));
        provinceMsg.setBeijingSecure(alldataService.findProvinceSecureByDateAndId(date,110000));
        provinceMsg.setBeijingDead(alldataService.findProvinceDeadByDateAndId(date,110000));
        provinceMsg.setBeijingAsymptomatic(alldataService.findProvinceAsymptomaticByDateAndId(date,110000));

        provinceMsg.setShanghaiDiagnosed(alldataService.findProvinceDiagnosedByDateAndId(date,310000));
        provinceMsg.setShanghaiSecure(alldataService.findProvinceSecureByDateAndId(date,310000));
        provinceMsg.setShanghaiDead(alldataService.findProvinceDeadByDateAndId(date,310000));
        provinceMsg.setShanghaiAsymptomatic(alldataService.findProvinceAsymptomaticByDateAndId(date,310000));

        provinceMsg.setGuangdongDiagnosed(alldataService.findProvinceDiagnosedByDateAndId(date,440000));
        provinceMsg.setGuangdongSecure(alldataService.findProvinceSecureByDateAndId(date,440000));
        provinceMsg.setGuangdongDead(alldataService.findProvinceDeadByDateAndId(date,440000));
        provinceMsg.setGuangdongAsymptomatic(alldataService.findProvinceAsymptomaticByDateAndId(date,440000));

        provinceMsg.setZhejiangDiagnosed(alldataService.findProvinceDiagnosedByDateAndId(date,330000));
        provinceMsg.setZhejiangSecure(alldataService.findProvinceSecureByDateAndId(date,330000));
        provinceMsg.setZhejiangDead(alldataService.findProvinceDeadByDateAndId(date,330000));
        provinceMsg.setZhejiangAsymptomatic(alldataService.findProvinceAsymptomaticByDateAndId(date,330000));

        return provinceMsg;
    }

    @GetMapping("/epidemicAnalysis")
    public EpidemicAnalysis getEpidemicAnalysis(){
        EpidemicAnalysis epidemicAnalysis = new EpidemicAnalysis();
        String nowString = "2022-12-13";
        Date nowDate = null;
        try {
            nowDate = new SimpleDateFormat("yyyy-MM-dd").parse(nowString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        Date lastDate = calendar.getTime();

        epidemicAnalysis.setNowDiagnosed(alldataService.findNewCountDiagnosedByDate(nowDate));
        epidemicAnalysis.setNowSecure(alldataService.findNewCountSecureByDate(nowDate));
        epidemicAnalysis.setNowDead(alldataService.findNewCountDeadByDate(nowDate));
        epidemicAnalysis.setNowAsymptomatic(alldataService.findNewCountAsymptomaticByDate(nowDate));

        epidemicAnalysis.setLastDiagnosed(alldataService.findNewCountDiagnosedByDate(lastDate));
        epidemicAnalysis.setLastSecure(alldataService.findNewCountSecureByDate(lastDate));
        epidemicAnalysis.setLastDead(alldataService.findNewCountDeadByDate(lastDate));
        epidemicAnalysis.setLastAsymptomatic(alldataService.findNewCountAsymptomaticByDate(lastDate));

        return epidemicAnalysis;
    }

    @GetMapping("/city")
    public City24 getCity24(){
        City24 city24 = new City24();
        Area area = areaService.findAreaByName("北京");
        String dateString = "2022-12-13";
        Calendar ca = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        ca.setTime(date);//获取今天日期
        for (int i=0;i<24;i++){
            Date now = ca.getTime();
            int num = alldataService.findProvinceDiagnosedByDateAndId(now,area.getPid());//查出当日新增人数
            city24.getAlldataList().add(num);
            ca.add(Calendar.DAY_OF_MONTH,-1);
        }
        Collections.reverse(city24.getAlldataList());
        city24.getAlldataList().forEach(System.out::println);
        return city24;
    }

    @GetMapping("/map")
    public EverydayMsg getCityEverydayMsg(String name){
        EverydayMsg everydayMsg = new EverydayMsg();
        Area area = areaService.findAreaByName(name);
        String dateString = "2022-12-13";
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        everydayMsg.setNewDiagnosed(alldataService.findProvinceDiagnosedByDateAndId(date,area.getPid()));
        everydayMsg.setNewSecure(alldataService.findProvinceSecureByDateAndId(date,area.getPid()));
        everydayMsg.setNewDead(alldataService.findProvinceDeadByDateAndId(date,area.getPid()));
        everydayMsg.setNewAsymptomatic(alldataService.findProvinceAsymptomaticByDateAndId(date,area.getPid()));
        return everydayMsg;
    }
}
