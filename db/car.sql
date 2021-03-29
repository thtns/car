create table biz_member
(
    id           bigint auto_increment comment '主键ID'
        primary key,
    name         varchar(64)                              not null comment '姓名',
    number_plate varchar(64)                              not null comment '车牌号',
    phone        varchar(20)                              not null comment '手机号码',
    balance      decimal(18, 2) default 0.00              null comment '卡内余额',
    type         tinyint                                  not null comment '会员类型',
    create_time  datetime       default CURRENT_TIMESTAMP null comment '创建时间',
    update_time  datetime                                 null on update CURRENT_TIMESTAMP comment '更新时间'
)
    comment '会员' auto_increment = 10000 ;

create table biz_transaction_record
(
    id          bigint auto_increment comment '主键ID'
        primary key,
    member_id   bigint                                   null comment '会员ID',
    price       decimal(18, 2) default 0.00              not null comment '交易金额',
    type        tinyint        default 1                 null comment '交易类型 1=消费 2=充值',
    remark      varchar(512)                             null comment '备注',
    create_time datetime       default CURRENT_TIMESTAMP null comment '创建时间',
    update_time datetime                                 null on update CURRENT_TIMESTAMP comment '更新时间'
)
    comment '交易记录' auto_increment = 10000 ;