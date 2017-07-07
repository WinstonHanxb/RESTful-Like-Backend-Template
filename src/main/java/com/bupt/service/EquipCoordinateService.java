package com.bupt.service;

import com.bupt.dto.EquipCoordinateDTO;


import java.util.List;

/**
 * Created by 韩宪斌 on 2017/7/3.
 * 设备坐标
 */

public interface EquipCoordinateService {

    /**
     * 根据所需的系统名称获取设备坐标
     * @param systemName
     * @return
     */
    List<EquipCoordinateDTO> listEquipCoordinateBySystemName(String systemName);
}
