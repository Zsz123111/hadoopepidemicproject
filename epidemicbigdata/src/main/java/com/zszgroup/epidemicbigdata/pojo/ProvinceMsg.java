package com.zszgroup.epidemicbigdata.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceMsg {
    private int beijingDiagnosed;
    private int shanghaiDiagnosed;
    private int guangdongDiagnosed;
    private int zhejiangDiagnosed;

    private int beijingSecure;
    private int shanghaiSecure;
    private int guangdongSecure;
    private int zhejiangSecure;

    private int beijingDead;
    private int shanghaiDead;
    private int guangdongDead;
    private int zhejiangDead;

    private int beijingAsymptomatic;
    private int shanghaiAsymptomatic;
    private int guangdongAsymptomatic;
    private int zhejiangAsymptomatic;
}
