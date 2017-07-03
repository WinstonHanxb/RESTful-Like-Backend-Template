package com.bupt.service;

import com.bupt.dto.TopologyLinkDTO;

import java.util.List;

/**
 * Created by 韩宪斌 on 2017/7/3.
 */
public interface TopologyLinkService {
    /**
     * 获取所有拓扑连接信息
     * @return
     */
    List<TopologyLinkDTO> listTopologyLink();
}
