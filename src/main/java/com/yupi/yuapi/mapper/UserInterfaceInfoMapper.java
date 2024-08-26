package com.yupi.yuapi.mapper;

import com.yupi.yuapi.model.entity.UserInterfaceInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author Prospect
* @description 针对表【user_interface_info(接口信息表)】的数据库操作Mapper
* @createDate 2024-08-17 13:11:50
* @Entity com.yupi.yuapi.model.entity.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);
}




