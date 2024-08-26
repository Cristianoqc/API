package com.yupi.yuapi.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.yupi.yuapi.model.dto.userinterfaceinfo.UserInterfaceInfoQueryRequest;
import com.yupi.yuapi.model.entity.UserInterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Prospect
* @description 针对表【user_interface_info(接口信息表)】的数据库操作Service
* @createDate 2024-08-17 13:11:50
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    /**
     * 获取查询条件
     * @param userInterfaceInfoQueryRequest
     * @return
     */
    Wrapper<UserInterfaceInfo> getQueryWrapper(UserInterfaceInfoQueryRequest userInterfaceInfoQueryRequest);

    /**
     * 验证数据
     * @param userInterfaceInfo
     * @param add
     */
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);



    /**
     * 调用次数+1
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);
}
