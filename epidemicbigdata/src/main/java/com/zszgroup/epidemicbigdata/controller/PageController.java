package com.zszgroup.epidemicbigdata.controller;

import com.zszgroup.epidemicbigdata.pojo.*;
import com.zszgroup.epidemicbigdata.service.AlldataService;
import com.zszgroup.epidemicbigdata.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class PageController {
    @Autowired
    AlldataService alldataService;
    @Autowired
    AreaService areaService;
    /**
     * 界面跳转
     * @param page 界面跳转
     * @return 界面
     */
    @RequestMapping("/index")
    public String page(String page, Map map){
        String dateString = "2022-12-13";
        Calendar ca = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        ca.setTime(date);
        ca.add(Calendar.DAY_OF_MONTH,-1);
        Date lastDate = ca.getTime();


        //这是上方展示栏数据
        int secureNum = alldataService.findAllCountSecureByDate(date);
        int deadNum = alldataService.findAllCountDeadByDate(date);
        int diagnosedNum = alldataService.findAllCountDiagnosedByDate(date);
        int newDiagnosedNum = alldataService.findNewCountDiagnosedByDate(date);
        int newSecureNum = alldataService.findNewCountSecureByDate(date);
        int newDeadNum = alldataService.findNewCountDeadByDate(date);
        int newAsymptomaticNum = alldataService.findNewCountAsymptomaticByDate(date);

        //下方展示栏前五位数据
        List<NewDiagnosed> newDiagnosed = alldataService.findFiveDiagnosed(date);
        List<NewSecure> newSecure = alldataService.findFiveSecure(date);
        List<NewDead> newDead = alldataService.findFiveDead(date);
        List<NewAsymptomatic> newAsymptomatic = alldataService.findFiveAsymptomatic(date);

        //城市选择
        List<Area> areas = areaService.findAll();

        //同比部分昨日数据
        int lastDiagnosed = alldataService.findNewCountDiagnosedByDate(lastDate);
        int lastSecure = alldataService.findNewCountSecureByDate(lastDate);
        int lastDead = alldataService.findNewCountDeadByDate(lastDate);
        int lastAsymptomatic = alldataService.findNewCountAsymptomaticByDate(lastDate);

        String formatDouble;
        double rateDiagnosed = 100.0*Math.abs(1.0*(newDiagnosedNum-lastDiagnosed)/(1.0*lastDiagnosed));
        formatDouble = String.format("%.1f",rateDiagnosed);
        rateDiagnosed = Double.parseDouble(formatDouble);
        double rateSecure = 100.0*Math.abs(1.0*(newSecureNum-lastSecure)/(1.0*lastSecure));
        formatDouble = String.format("%.1f",rateSecure);
        rateSecure = Double.parseDouble(formatDouble);
        double rateDead = 100.0*Math.abs(1.0*(newDeadNum-lastDead)/(1.0*lastDead));
        formatDouble = String.format("%.1f",rateDead);
        rateDead = Double.parseDouble(formatDouble);
        double rateAsymptomatic = 100.0*Math.abs(1.0*(newAsymptomaticNum-lastAsymptomatic)/(1.0*lastAsymptomatic));
        formatDouble = String.format("%.1f",rateAsymptomatic);
        rateAsymptomatic = Double.parseDouble(formatDouble);

        map.put("allSecure",secureNum);
        map.put("allDead",deadNum);
        map.put("allDiagnosed",diagnosedNum);
        map.put("newDiagnosed",newDiagnosedNum);
        map.put("newSecure",newSecureNum);
        map.put("newDead",newDeadNum);
        map.put("newAsymptomatic",newAsymptomaticNum);
        map.put("nDFirst",newDiagnosed.get(0));
        map.put("nDSecond",newDiagnosed.get(1));
        map.put("nDThird",newDiagnosed.get(2));
        map.put("nDFourth",newDiagnosed.get(3));
        map.put("nDFifth",newDiagnosed.get(4));
        map.put("nSFirst",newSecure.get(0));
        map.put("nSSecond",newSecure.get(1));
        map.put("nSThird",newSecure.get(2));
        map.put("nSFourth",newSecure.get(3));
        map.put("nSFifth",newSecure.get(4));
        map.put("nDeadFirst",newDead.get(0));
        map.put("nDeadSecond",newDead.get(1));
        map.put("nDeadThird",newDead.get(2));
        map.put("nDeadFourth",newDead.get(3));
        map.put("nDeadFifth",newDead.get(4));
        map.put("nAFirst",newAsymptomatic.get(0));
        map.put("nASecond",newAsymptomatic.get(1));
        map.put("nAThird",newAsymptomatic.get(2));
        map.put("nAFourth",newAsymptomatic.get(3));
        map.put("nAFifth",newAsymptomatic.get(4));
        map.put("areasList",areas);
        map.put("lastDiagnosed",lastDiagnosed);
        map.put("lastSecure",lastSecure);
        map.put("lastDead",lastDead);
        map.put("lastAsymptomatic",lastAsymptomatic);
        map.put("rateDiagnosed",rateDiagnosed);
        map.put("rateSecure",rateSecure);
        map.put("rateDead",rateDead);
        map.put("rateAsymptomatic",rateAsymptomatic);

        return page;
    }
    /**
     * 防止图标报错
     */
    @RequestMapping("/favicon.ico")
    @ResponseBody
    void returnNOFavicon(){}
}
