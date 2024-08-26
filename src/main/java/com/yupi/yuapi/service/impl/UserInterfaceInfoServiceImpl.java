package com.yupi.yuapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.yuapi.common.ErrorCode;
import com.yupi.yuapi.exception.BusinessException;
import com.yupi.yuapi.exception.ThrowUtils;
import com.yupi.yuapi.mapper.UserInterfaceInfoMapper;
import com.yupi.yuapi.model.dto.userinterfaceinfo.UserInterfaceInfoQueryRequest;
import com.yupi.yuapi.model.entity.UserInterfaceInfo;
import com.yupi.yuapi.service.UserInterfaceInfoService;
import org.springframework.stereotype.Service;

/**
* @author Prospect
* @description 针对表【user_interface_info(接口信息表)】的数据库操作Service实现
* @createDate 2024-08-17 13:11:50
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService{

    @Override
    public QueryWrapper<UserInterfaceInfo> getQueryWrapper(UserInterfaceInfoQueryRequest userInterfaceInfoQueryRequest) {
        QueryWrapper<UserInterfaceInfo> queryWrapper = new QueryWrapper<>();
        Long id = userInterfaceInfoQueryRequest.getId();
        if (id != null) {
            queryWrapper.eq("id", id);
        }
        Long userId = userInterfaceInfoQueryRequest.getUserId();
        if (userId != null) {
            queryWrapper.eq("userId", userId);
        }
        Long interfaceInfoId = userInterfaceInfoQueryRequest.getInterfaceInfoId();
        if (interfaceInfoId != null) {
            queryWrapper.eq("interfaceInfoId", interfaceInfoId);
        }
        Integer totalNum = userInterfaceInfoQueryRequest.getTotalNum();
        if (totalNum != null) {
            queryWrapper.eq("totalNum", totalNum);
        }
        Integer leftNum = userInterfaceInfoQueryRequest.getLeftNum();
        if (leftNum != null) {
            queryWrapper.eq("leftNum", leftNum);
        }
        Integer status = userInterfaceInfoQueryRequest.getStatus();
        if (status != null) {
            queryWrapper.eq("status", status);
        }
        return queryWrapper;
    }

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Long id = userInterfaceInfo.getId();
        Long userId = userInterfaceInfo.getUserId();
        Long interfaceInfoId = userInterfaceInfo.getInterfaceInfoId();
        Integer totalNum = userInterfaceInfo.getTotalNum();
        Integer leftNum = userInterfaceInfo.getLeftNum();
        Integer status = userInterfaceInfo.getStatus();
        // 创建时，参数不能为空
        if (add) {
            ThrowUtils.throwIf(userId <= 0 || interfaceInfoId <= 0, ErrorCode.PARAMS_ERROR);
        }
        if (id != null && id <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        if (userId != null && userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        if (interfaceInfoId != null && interfaceInfoId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        if (totalNum != null && totalNum <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        if (leftNum != null && leftNum < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        if (status != null && status != 0 && status != 1) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
    }

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        if (interfaceInfoId <= 0 || userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("interfaceInfoId", interfaceInfoId);
        updateWrapper.eq("userId", userId);
        updateWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");
        return this.update(updateWrapper);
    }
}




