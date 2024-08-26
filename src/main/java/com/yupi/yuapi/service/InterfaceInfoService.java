package com.yupi.yuapi.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.yuapi.model.dto.interfaceinfo.InterfaceInfoQueryRequest;
import com.yupi.yuapicommon.model.entity.InterfaceInfo;

/**
* @author Prospect
* @description 针对表【interface_info(接口信息表)】的数据库操作Service
* @createDate 2024-08-15 12:09:48
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    /**
     * 校验数据
     * @param interfaceInfo
     * @param add
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

    /**
     * 获取查询条件
     * @param interfaceInfoQueryRequest
     * @return
     */
    QueryWrapper<InterfaceInfo> getQueryWrapper(InterfaceInfoQueryRequest interfaceInfoQueryRequest);
}
