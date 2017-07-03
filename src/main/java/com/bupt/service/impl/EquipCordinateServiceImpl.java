package com.bupt.service.impl;

import com.bupt.dao.ResEquipCordinateDao;
import com.bupt.dto.EquipCordinateDTO;
import com.bupt.entity.ResEquipCordinate;
import com.bupt.service.EquipCordinateService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 韩宪斌 on 2017/7/3.
 */
@Service("equipCordinateService")
public class EquipCordinateServiceImpl implements EquipCordinateService {
    @Resource
    private ResEquipCordinateDao resEquipCordinateDao;

    @Override
    public List<EquipCordinateDTO> listEquipCordinateBySystemName(String systemName) {
        List<ResEquipCordinate> listDao=resEquipCordinateDao.listEquipCordinateBySystemName(systemName);
        List<EquipCordinateDTO> listDTO=new ArrayList<EquipCordinateDTO>();
        Iterator<ResEquipCordinate> daoIterator = listDao.iterator();

        while(daoIterator.hasNext()){
            listDTO.add(this.convertToDTO(daoIterator.next()));
        }
        return listDTO;
    }


    private EquipCordinateDTO convertToDTO(ResEquipCordinate resEquipCordinate) {
        if (resEquipCordinate == null) {
            return null;
        }
        EquipCordinateDTO equipCordinateDTO = new EquipCordinateDTO();
        BeanUtils.copyProperties(resEquipCordinate, equipCordinateDTO);
        return equipCordinateDTO;
    }
}
