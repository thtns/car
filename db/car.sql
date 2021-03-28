create table biz_member
(
    id           bigint                             not null comment '主键ID'
        primary key,
    name         varchar(64)                        not null comment '姓名',
    number_plate varchar(64)                        not null comment '车牌号',
    phone        varchar(20)                        not null comment '手机号码',
    balance      decimal(18, 2)                     null comment '卡内余额',
    type         tinyint                            not null comment '会员类型',
    create_time  datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_time  datetime                           null on update CURRENT_TIMESTAMP comment '更新时间'
) comment '会员';

create table biz_transaction_record
(
    id          bigint                             not null comment '主键ID'
        primary key,
    member_id   bigint                             null comment '会员ID',
    price       decimal(18, 2)                     not null comment '交易金额',
    remark      varchar(512)                       null comment '备注',
    create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_time datetime                           null on update CURRENT_TIMESTAMP comment '更新时间'
) comment '交易记录';

create table sys_menu
(
    id          bigint                             not null comment '菜单ID'
        primary key,
    name        varchar(32)                        not null comment '菜单名称',
    permission  varchar(32)                        null comment '菜单权限标识',
    path        varchar(128)                       null comment '前端URL',
    parent_id   bigint                             null comment '父菜单ID',
    icon        varchar(32)                        null comment '图标',
    component   varchar(64)                        null comment 'VUE页面',
    sort        int      default 1                 null comment '排序值',
    keep_alive  char     default '0'               null comment '0-开启，1- 关闭',
    type        char                               null comment '菜单类型 （0菜单 1按钮）',
    create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_time datetime                           null on update CURRENT_TIMESTAMP comment '更新时间'
) comment '菜单权限表' charset = utf8;

create table sys_role
(
    id          bigint                             not null
        primary key,
    role_name   varchar(64)                        not null,
    role_code   varchar(64)                        not null,
    role_desc   varchar(255)                       null,
    create_time datetime default CURRENT_TIMESTAMP not null,
    update_time datetime                           null on update CURRENT_TIMESTAMP,
    constraint role_idx1_role_code
        unique (role_code)
) comment '系统角色表';

create table sys_role_menu
(
    role_id bigint not null comment '角色ID',
    menu_id bigint not null comment '菜单ID',
    primary key (role_id, menu_id)
) comment '角色菜单表' charset = utf8;

create table sys_user
(
    id          bigint                             not null comment '主键ID'
        primary key,
    username    varchar(64)                        not null comment '用户名',
    password    varchar(255)                       not null,
    salt        varchar(255)                       null comment '随机盐',
    phone       varchar(20)                        null comment '简介',
    avatar      varchar(255)                       null comment '头像',
    create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_time datetime                           null on update CURRENT_TIMESTAMP comment '修改时间'
) comment '用户表';

create
    index user_idx1_username
    on sys_user (username);

create table sys_user_role
(
    user_id bigint not null comment '用户ID',
    role_id bigint not null comment '角色ID',
    primary key (user_id, role_id)
) comment '用户角色表' charset = utf8;

