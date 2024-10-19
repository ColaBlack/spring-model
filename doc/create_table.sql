create database if not exists user_center;

use user_center;

create table user
(
    user_id       bigint auto_increment
        primary key,
    user_nickname varchar(256) default '快来设置昵称吧'  null comment '用户昵称',
    user_account  varchar(256)                           null comment '用户账号',
    user_avatar   varchar(1024)                          null comment '用户头像',
    user_password varchar(512)                           not null comment '密码',
    user_role     int          default 0                 null comment '状态 0-正常 1-vip 2-ban 3-管理员',
    create_time   datetime     default CURRENT_TIMESTAMP null comment '记录创建时间',
    update_time   datetime     default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '记录更新时间',
    is_delete     tinyint      default 0                 not null comment '是否删除',
    user_profile  text                                   null comment '用户简介'
);

create index user_user_account_index
    on user (user_account);
