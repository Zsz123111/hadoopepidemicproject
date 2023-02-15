package com.zszgroup.epidemicbigdata.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewAsymptomatic {
    private String pid;
    private String prov;
    private int nosymins;
}
