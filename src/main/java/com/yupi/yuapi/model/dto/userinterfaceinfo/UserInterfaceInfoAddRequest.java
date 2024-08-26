package com.yupi.yuapi.model.dto.userinterfaceinfo;

import lombok.Data;

import java.io.Serializable;



/**
 * 创建请求
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@Data
public class UserInterfaceInfoAddRequest implements Serializable {
    /**
     * 调用用户ID
     */
    private Long userId;

    /**
     * 调用接口ID
     */
    private Long interfaceInfoId;

    /**
     * 调用次数
     */
    private Integer totalNum;

    /**
     * 剩余调用次数
     */
    private Integer leftNum;
}