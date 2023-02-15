package com.zszgroup.epidemicbigdata.mapper;

import com.zszgroup.epidemicbigdata.pojo.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
* @author 91067
* @description 针对表【alldata】的数据库操作Mapper
* @createDate 2023-01-05 10:38:26
* @Entity com.zszgroup.epidemicbigdata.pojo.Alldata
*/
@Mapper
public interface AlldataMapper extends BaseMapper<Alldata> {
    int selectSumAllDiagnosedByDate(int year);
    
    int selectSumAllSecureByDate(int year);

    int selectSumAllDeadByDate(int year);

    int selectSumNewDiagnosedByDate(@Param("year") int year,@Param("month") int month,@Param("day") int day);
    int selectSumNewSecureByDate(@Param("year") int year,@Param("month") int month,@Param("day") int day);
    int selectSumNewDeadByDate(@Param("year") int year,@Param("month") int month,@Param("day") int day);
    int selectSumNewAsymptomaticByDate(@Param("year") int year,@Param("month") int month,@Param("day") int day);

    List<NewDiagnosed> selectFiveDiagnosedByDate(@Param("year") int year,@Param("month") int month,@Param("day") int day);
    List<NewSecure> selectFiveSecureByDate(@Param("year") int year, @Param("month") int month, @Param("day") int day);
    List<NewDead> selectFiveDeadByDate(@Param("year") int year, @Param("month") int month, @Param("day") int day);
    List<NewAsymptomatic> selectFiveAsymptomaticByDate(@Param("year") int year, @Param("month") int month, @Param("day") int day);

}




