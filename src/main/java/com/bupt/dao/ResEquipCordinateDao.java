package com.bupt.dao;



import com.bupt.entity.ResEquipCordinate;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by 韩宪斌 on 2017/7/3.
 */
@Repository
public interface ResEquipCordinateDao extends Mapper<ResEquipCordinate> {
    @Select("select equip_id as equipId,equip_name as equipName,x,y from res_equip_cordinate where equip_system_name=#{systemName}")
    public List<ResEquipCordinate> listEquipCordinateBySystemName(String systemName);
}
