package com.zszgroup.epidemicbigdata.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName alldata
 */
@TableName(value ="alldata")
@Data
public class Alldata implements Serializable {
    /**
     * 时间
     */
    private String dt;

    /**
     * 省份
     */
    private Area pid;

    /**
     * 累计确诊
     */
    private Integer confall;

    /**
     * 累计死亡
     */
    private Integer deadall;

    /**
     * 累计治愈
     */
    private Integer healall;

    /**
     * 累计无症状
     */
    private Integer nosymall;

    /**
     * 新增确诊
     */
    private Integer confins;

    /**
     * 新增治愈
     */
    private Integer healins;

    /**
     * 新增死亡
     */
    private Integer deadins;

    /**
     * 新增本土确诊
     */
    private Integer confinsbt;

    /**
     * 新增无症状
     */
    private Integer nosymins;

    /**
     * 年
     */
    private Integer year;

    /**
     * 月
     */
    private Integer month;

    /**
     * 日
     */
    private Integer day;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Alldata other = (Alldata) that;
        return (this.getDt() == null ? other.getDt() == null : this.getDt().equals(other.getDt()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getConfall() == null ? other.getConfall() == null : this.getConfall().equals(other.getConfall()))
            && (this.getDeadall() == null ? other.getDeadall() == null : this.getDeadall().equals(other.getDeadall()))
            && (this.getHealall() == null ? other.getHealall() == null : this.getHealall().equals(other.getHealall()))
            && (this.getNosymall() == null ? other.getNosymall() == null : this.getNosymall().equals(other.getNosymall()))
            && (this.getConfins() == null ? other.getConfins() == null : this.getConfins().equals(other.getConfins()))
            && (this.getHealins() == null ? other.getHealins() == null : this.getHealins().equals(other.getHealins()))
            && (this.getDeadins() == null ? other.getDeadins() == null : this.getDeadins().equals(other.getDeadins()))
            && (this.getConfinsbt() == null ? other.getConfinsbt() == null : this.getConfinsbt().equals(other.getConfinsbt()))
            && (this.getNosymins() == null ? other.getNosymins() == null : this.getNosymins().equals(other.getNosymins()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getMonth() == null ? other.getMonth() == null : this.getMonth().equals(other.getMonth()))
            && (this.getDay() == null ? other.getDay() == null : this.getDay().equals(other.getDay()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDt() == null) ? 0 : getDt().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getConfall() == null) ? 0 : getConfall().hashCode());
        result = prime * result + ((getDeadall() == null) ? 0 : getDeadall().hashCode());
        result = prime * result + ((getHealall() == null) ? 0 : getHealall().hashCode());
        result = prime * result + ((getNosymall() == null) ? 0 : getNosymall().hashCode());
        result = prime * result + ((getConfins() == null) ? 0 : getConfins().hashCode());
        result = prime * result + ((getHealins() == null) ? 0 : getHealins().hashCode());
        result = prime * result + ((getDeadins() == null) ? 0 : getDeadins().hashCode());
        result = prime * result + ((getConfinsbt() == null) ? 0 : getConfinsbt().hashCode());
        result = prime * result + ((getNosymins() == null) ? 0 : getNosymins().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getMonth() == null) ? 0 : getMonth().hashCode());
        result = prime * result + ((getDay() == null) ? 0 : getDay().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dt=").append(dt);
        sb.append(", pid=").append(pid);
        sb.append(", confall=").append(confall);
        sb.append(", deadall=").append(deadall);
        sb.append(", healall=").append(healall);
        sb.append(", nosymall=").append(nosymall);
        sb.append(", confins=").append(confins);
        sb.append(", healins=").append(healins);
        sb.append(", deadins=").append(deadins);
        sb.append(", confinsbt=").append(confinsbt);
        sb.append(", nosymins=").append(nosymins);
        sb.append(", year=").append(year);
        sb.append(", month=").append(month);
        sb.append(", day=").append(day);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}