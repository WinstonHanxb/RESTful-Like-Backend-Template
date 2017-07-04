package com.bupt.controller;

import com.bupt.dto.TopologyLinkDTO;
import com.bupt.service.TopologyLinkService;
import com.bupt.util.exception.controller.result.NoneGetException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 韩宪斌 on 2017/7/3.
 */
@RestController
@Api(tags = "TopologyLink",description = "拓扑连接相关操作")
@RequestMapping("/topolinks")
public class TopologyLinkController {
    @Resource
    private TopologyLinkService topologyLinkService;

    @ApiOperation(value = "获取所有拓扑连接信息")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TopologyLinkDTO> listTopologyLink(){
        List<TopologyLinkDTO> listDTO=topologyLinkService.listTopologyLink();
        if(listDTO.size()==0){
            throw new NoneGetException();
        }
        return listDTO;
    }
}
