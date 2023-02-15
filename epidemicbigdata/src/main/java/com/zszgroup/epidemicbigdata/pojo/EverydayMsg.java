package com.zszgroup.epidemicbigdata.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EverydayMsg {
    private int newDiagnosed;
    private int newSecure;
    private int newDead;
    private int newAsymptomatic;
}
