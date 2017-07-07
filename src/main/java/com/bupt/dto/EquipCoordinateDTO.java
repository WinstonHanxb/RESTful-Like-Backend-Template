package com.bupt.dto;

import java.math.BigDecimal;

/**
 * Created by 韩宪斌 on 2017/7/3.
 */
public class EquipCoordinateDTO {
    private String equipId;
    private String equipName;
    private BigDecimal x;
    private BigDecimal y;

    public String getEquipId() {
        return equipId;
    }

    public void setEquipId(String equipId) {
        this.equipId = equipId;
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public BigDecimal getX() {
        return x;
    }

    public void setX(BigDecimal x) {
        this.x = x;
    }

    public BigDecimal getY() {
        return y;
    }

    public void setY(BigDecimal y) {
        this.y = y;
    }
}
