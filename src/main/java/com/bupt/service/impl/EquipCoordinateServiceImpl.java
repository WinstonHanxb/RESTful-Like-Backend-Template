package com.bupt.service.impl;

import com.bupt.dao.ResEquipCoordinateDao;
import com.bupt.dto.EquipCoordinateDTO;
import com.bupt.entity.ResEquipCoordinate;
import com.bupt.service.EquipCoordinateService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 韩宪斌 on 2017/7/3.
 */
@Service("equipCoordinateService")
public class EquipCoordinateServiceImpl implements EquipCoordinateService {
    @Resource
    private ResEquipCoordinateDao resEquipCoordinateDao;

    @Override
    public List<EquipCoordinateDTO> listEquipCoordinateBySystemName(String systemName) {
        List<ResEquipCoordinate> listDao= resEquipCoordinateDao.listEquipCoordinateBySystemName(systemName);
        List<EquipCoordinateDTO> listDTO=new ArrayList<EquipCoordinateDTO>();
        Iterator<ResEquipCoordinate> daoIterator = listDao.iterator();

        while(daoIterator.hasNext()){
            listDTO.add(this.convertToDTO(daoIterator.next()));
        }
        return listDTO;
    }


    private EquipCoordinateDTO convertToDTO(ResEquipCoordinate resEquipCoordinate) {
        if (resEquipCoordinate == null) {
            return null;
        }
        EquipCoordinateDTO equipCoordinateDTO = new EquipCoordinateDTO();
        BeanUtils.copyProperties(resEquipCoordinate, equipCoordinateDTO);
        return equipCoordinateDTO;
    }
}
