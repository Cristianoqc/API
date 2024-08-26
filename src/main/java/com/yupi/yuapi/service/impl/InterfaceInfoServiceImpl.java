package com.yupi.yuapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.yuapi.common.ErrorCode;
import com.yupi.yuapi.exception.BusinessException;
import com.yupi.yuapi.exception.ThrowUtils;
import com.yupi.yuapi.mapper.InterfaceInfoMapper;
import com.yupi.yuapi.model.dto.interfaceinfo.InterfaceInfoQueryRequest;
import com.yupi.yuapi.service.InterfaceInfoService;
import com.yupi.yuapicommon.model.entity.InterfaceInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
* @author Prospect
* @description 针对表【interface_info(接口信息表)】的数据库操作Service实现
* @createDate 2024-08-15 12:09:48
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService{

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String name = interfaceInfo.getName();
        String description = interfaceInfo.getDescription();
        String url = interfaceInfo.getUrl();
        String method = interfaceInfo.getMethod();
        String requestHeader = interfaceInfo.getRequestHeader();
        String responseHeader = interfaceInfo.getResponseHeader();
        Integer status = interfaceInfo.getStatus();
        Long userId = interfaceInfo.getUserId();
        // 创建时，参数不能为空
        if (add) {
            ThrowUtils.throwIf(StringUtils.isAnyBlank(name, description, url, method, requestHeader, responseHeader), ErrorCode.PARAMS_ERROR);
        }
        // 有参数则校验
        if (StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }
        if (StringUtils.isNotBlank(description) && description.length() > 8192) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "内容过长");
        }
        if (StringUtils.isNotBlank(url) && url.length() > 2048) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "url过长");
        }
        if (StringUtils.isNotBlank(method) && !"GET".equals(method) && !"POST".equals(method)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "method错误");
        }
        if (StringUtils.isNotBlank(requestHeader) && requestHeader.length() > 8192) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "requestHeader过长");
        }
        if (StringUtils.isNotBlank(responseHeader) && responseHeader.length() > 8192) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "responseHeader过长");
        }
        if (status != null && (status < 0 || status > 1)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "status错误");
        }
        if (userId != null && userId < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "userId错误");
        }
    }

    @Override
    public QueryWrapper<InterfaceInfo> getQueryWrapper(InterfaceInfoQueryRequest interfaceInfoQueryRequest) {
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        String name = interfaceInfoQueryRequest.getName();
        if (StringUtils.isNotBlank(name)) {
            queryWrapper.like("name", name);
        }
        Integer status = interfaceInfoQueryRequest.getStatus();
        if (status != null) {
            queryWrapper.eq("status", status);
        }
        Long userId = interfaceInfoQueryRequest.getUserId();
        if (userId != null) {
            queryWrapper.eq("userId", userId);
        }
        String description = interfaceInfoQueryRequest.getDescription();
        if (StringUtils.isNotBlank(description)) {
            queryWrapper.like("description", description);
        }
        String url = interfaceInfoQueryRequest.getUrl();
        if (StringUtils.isNotBlank(url)) {
            queryWrapper.like("url", url);
        }
        String method = interfaceInfoQueryRequest.getMethod();
        if (StringUtils.isNotBlank(method)) {
            queryWrapper.eq("method", method);
        }
        String requestHeader = interfaceInfoQueryRequest.getRequestHeader();
        if (StringUtils.isNotBlank(requestHeader)) {
            queryWrapper.like("requestHeader", requestHeader);
        }
        String responseHeader = interfaceInfoQueryRequest.getResponseHeader();
        if (StringUtils.isNotBlank(responseHeader)) {
            queryWrapper.like("responseHeader", responseHeader);
        }
        return queryWrapper;
    }
}




