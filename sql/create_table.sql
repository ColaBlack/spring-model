create database if not exists teaai;

use teaai;

-- 用户表
-- auto-generated definition
create table user
(
    id            bigint auto_increment comment 'id'
        primary key,
    user_account  varchar(256)                                                                                                  not null comment '账号',
    user_password varchar(512)                                                                                                  not null comment '密码',
    user_name     varchar(256)                                                                                                  null comment '用户昵称',
    user_avatar   varchar(1024) default 'https://foruda.gitee.com/avatar/1731663770563828792/14739004_colablack_1731663770.png' null comment '用户头像',
    user_profile  varchar(512)                                                                                                  null comment '用户简介',
    user_role     varchar(256)  default 'user'                                                                                  not null comment '用户角色：user/admin/ban',
    create_time   datetime      default CURRENT_TIMESTAMP                                                                       not null comment '创建时间',
    update_time   datetime      default CURRENT_TIMESTAMP                                                                       not null on update CURRENT_TIMESTAMP comment '更新时间',
    has_deleted   tinyint       default 0                                                                                       not null comment '是否删除'
)
    comment '用户表';