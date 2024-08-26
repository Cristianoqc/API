use yuapi;

create table if not exists yuapi.interface_info(
    `id` bigint not null primary key auto_increment comment '主键',
    `name` varchar(256) not null comment '接口名称',
    `description` varchar(256) not null comment '接口描述',
    `url` varchar(512) not null comment '接口地址',
    `method` varchar(256) not null comment '请求类型',
    `requestHeader` text not null comment '请求头',
    `responseHeader` text not null comment '响应头',
    `status` int not null comment '接口状态（0关闭，1开启）',
    `userId` bigint not null comment '创建人',
    `createTime` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `updateTime` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `isDelete` int default 0 not null comment '是否删除'
) comment '接口信息表';

# 帮我往interface_info表中插入伪数据

# 将status字段默认值设置为0
alter table interface_info modify column status int default 0;


# 创建用户-接口关系表
create table if not exists yuapi.user_interface_info(
    `id` bigint not null primary key auto_increment comment '主键',
    `userId` bigint not null comment '调用用户ID',
    `interfaceInfoId` bigint not null comment '调用接口ID',
    `totalNum` int default 0 not null comment '调用次数',
    `leftNum` int default 0 not null comment '剩余调用次数',
    `status` int default 0 not null comment '0-正常,1-暂停调用',
    `createTime` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `updateTime` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `isDelete` int default 0 not null comment '是否删除'
) comment '接口信息表';