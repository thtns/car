create table if not exists biz_car
(
	id bigint auto_increment comment '主键ID
',
	number_plate varchar(64) null comment '车牌号',
	car_name varchar(64) null comment '车型名称',
	member_id bigint null comment '会员ID',
	create_time datetime default CURRENT_TIMESTAMP null,
	update_time datetime null comment '更新时间',
	constraint biz_car_id_uindex
		unique (id)
)
comment '车';

alter table biz_car
	add primary key (id);

create table if not exists biz_card
(
	id bigint auto_increment comment '主键ID'
		primary key,
	member_id bigint null comment '会员ID',
	type tinyint default 0 not null comment '0=年卡 1=次卡 2=储值卡',
	num int default 0 null comment '次数',
	balance decimal(18,2) default 0.00 null comment '卡内余额',
	car_id bigint null comment '车的ID',
	valid_date date null comment '有效期',
	create_time datetime default CURRENT_TIMESTAMP null,
	update_time datetime null on update CURRENT_TIMESTAMP
)
comment '会员办理的业务卡';

create table if not exists biz_commodity
(
	id bigint auto_increment comment '主键ID',
	name varchar(64) null comment '商品名称',
	create_time datetime default CURRENT_TIMESTAMP null,
	update_time datetime null on update CURRENT_TIMESTAMP,
	constraint biz_commodity_id_uindex
		unique (id)
)
comment '商品';

alter table biz_commodity
	add primary key (id);

create table if not exists biz_commodity_member
(
	id bigint auto_increment comment '主键ID',
	commodity_id bigint null comment '商品ID',
	commodity_name varchar(64) null comment '商品名称',
	member_id bigint null comment '会员ID',
	num int null comment '次数',
	create_time datetime default CURRENT_TIMESTAMP null,
	update_time datetime null on update CURRENT_TIMESTAMP,
	constraint biz_commodity_member_id_uindex
		unique (id)
)
comment '商品';

alter table biz_commodity_member
	add primary key (id);

create table if not exists biz_member
(
	id bigint auto_increment comment '主键ID'
		primary key,
	name varchar(64) not null comment '姓名',
	phone varchar(20) not null comment '手机号码',
	create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
	update_time datetime null on update CURRENT_TIMESTAMP comment '更新时间'
)
comment '会员';

create table if not exists biz_transaction_record
(
	id bigint auto_increment comment '主键ID'
		primary key,
	member_id bigint null comment '会员ID',
	price decimal(18,2) default 0.00 not null comment '交易金额',
	type tinyint default 1 null comment '交易类型 1=消费 2=充值',
	card_id bigint not null comment '业务卡ID',
	card_type tinyint null comment '业务类型',
	trade_time datetime null comment '交易时间',
	car_id bigint null comment '汽车ID',
	remark varchar(512) null comment '备注',
	car_name varchar(64) null comment '车名称',
	number_plate varchar(64) null comment '车牌号',
	create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
	update_time datetime null on update CURRENT_TIMESTAMP comment '更新时间'
)
comment '交易记录';

