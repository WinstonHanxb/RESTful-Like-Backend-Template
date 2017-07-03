package com.bupt.service;

import com.bupt.dto.EquipCordinateDTO;


import java.util.List;

/**
 * Created by 韩宪斌 on 2017/7/3.
 * 设备坐标
 */

public interface EquipCordinateService {

    /**
     * 根据所需的系统名称获取设备坐标
     * @param systemName
     * @return
     */
    List<EquipCordinateDTO> listEquipCordinateBySystemName(String systemName);
}
