package com.zszgroup.epidemicbigdata.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpidemicAnalysis {
    private int lastDiagnosed;
    private int lastSecure;
    private int lastDead;
    private int lastAsymptomatic;

    private int nowDiagnosed;
    private int nowSecure;
    private int nowDead;
    private int nowAsymptomatic;
}
