package com.bupt.service.impl;

import com.bupt.dao.ResTopologyLinkDao;
import com.bupt.dto.TopologyLinkDTO;
import com.bupt.entity.ResTopologyLink;
import com.bupt.service.TopologyLinkService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 韩宪斌 on 2017/7/3.
 */
@Service("topologyLinkService")
public class TopologyLinkServiceImpl implements TopologyLinkService{
    @Resource
    private ResTopologyLinkDao resTopologyLinkDao;

    @Override
    public List<TopologyLinkDTO> listTopologyLink() {
        List<ResTopologyLink> listDao=resTopologyLinkDao.selectAll();
        List<TopologyLinkDTO> listDTO=new ArrayList<TopologyLinkDTO>();
        Iterator<ResTopologyLink> daoIterator=listDao.iterator();
        while(daoIterator.hasNext()){
            listDTO.add(this.convertToDTO(daoIterator.next()));
        }
        return listDTO;
    }




    private TopologyLinkDTO convertToDTO(ResTopologyLink resTopologyLink) {
        if (resTopologyLink == null) {
            return null;
        }
        TopologyLinkDTO topologyLinkDTO = new TopologyLinkDTO();
        BeanUtils.copyProperties(resTopologyLink, topologyLinkDTO);
        return topologyLinkDTO;
    }
}
