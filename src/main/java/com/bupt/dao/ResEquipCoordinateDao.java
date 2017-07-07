package com.bupt.dao;



import com.bupt.entity.ResEquipCoordinate;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by 韩宪斌 on 2017/7/3.
 */
@Repository
public interface ResEquipCoordinateDao extends Mapper<ResEquipCoordinate> {
    @Select("select equip_id as equipId,equip_name as equipName,x,y from res_equip_coordinate where " +
            "equip_system_name=#{systemName}")
    List<ResEquipCoordinate> listEquipCoordinateBySystemName(String systemName);
}
