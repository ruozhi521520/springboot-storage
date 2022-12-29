/*CREATE DATABASE lrpdb;

CREATE USER 'lrp'@'localhost' IDENTIFIED BY 'lrp';


Grant all privileges on lrpdb.* to 'lrp'@'localhost';*/

drop table if exists lrp_user;

create table lrp_user
(
    id         int auto_increment primary key,
    userName   varchar(45) not null,
    password   varchar(45) not null,
    realName   varchar(45) null,
    addDate    datetime    null,
    updateDate datetime    null
);

insert into lrp_user(userName, password, realName)
VALUES ('admin', 'admin', '管理员');

drop table if exists lrp_item;

create table lrp_item
(
    id          int auto_increment primary key comment '序号',
    itemName    varchar(45)  not null comment '物资名称',
    orderUnit   varchar(45)  not null comment '订购单位',
    issueUnit   varchar(45)  not null comment '销售单位',
    issueCost   float        not null comment '销售单价',
    unitFloor   float comment '单价底价',
    lineFloor   float comment '总价底价',
    coeffiCient float        not null comment '转换系数',
    remark      varchar(100) null comment '备注',
    status      boolean      not null comment '是否启用',
    addDate     datetime     not null comment '添加时间',
    updateDate  datetime     not null comment '修改时间'
);


drop table if exists lrp_store;

create table lrp_store
(
    id        int auto_increment primary key comment '序号',
    storeName varchar(45)  not null comment '物资名称',
    contacts  varchar(45)  null comment '联系人',
    phone     varchar(45)  null comment '联系方式',
    remark    varchar(100) null comment '备注',
    status    boolean      not null comment '是否启用',
    addDate   datetime     not null comment '添加时间'
);

drop table if exists lrp_buyer;

create table lrp_buyer
(
    id        int auto_increment primary key comment '序号',
    buyerName varchar(45)  not null comment '买家名称',
    phone     varchar(45)  not null comment '联系方式',
    address   varchar(45)  not null comment '地址',
    remark    varchar(100) null comment '备注',
    addDate   datetime     not null comment '添加时间'
);

drop table if exists lrp_inventory;

create table lrp_inventory
(
    id       int auto_increment primary key comment '序号',
    itemId   int         not null comment '物资编号',
    orderQty int         not null comment '订购数量',
    issueQty int         not null comment '销售数量',
    storeId  varchar(45) not null comment '仓库编号'
);

drop table if exists lrp_inbound;

create table lrp_inbound
(
    id       int auto_increment primary key comment '序号',
    itemId   int          not null comment '物资编号',
    orderQty int          not null comment '订购数量',
    issueQty int          not null comment '销售数量',
    storeId  varchar(45)  not null comment '仓库编号',
    remark   varchar(100) null comment '备注',
    addDate  datetime     not null comment '添加时间'
);

drop table if exists lrp_outbound;

create table lrp_outbound
(
    id        int auto_increment primary key comment '序号',
    itemId    int          not null comment '物资编号',
    buyerId   int          not null comment '买家编号',
    orderQty  int          not null comment '订购数量',
    issueQty  int          not null comment '销售数量',
    issueCost double       not null comment '单价',
    lineCost  double       not null comment '总价',
    storeId   int          not null comment '仓库编号',
    isCheck   boolean comment '是否结账',
    isPayment boolean comment '是否待收',
    remark    varchar(200) null comment '备注',
    addDate   datetime     not null comment '添加时间'
) comment '出库';

drop table if exists lrp_order;

create table lrp_order
(
    id             int auto_increment primary key comment '序号',
    subject_matter varchar(400) comment '事由',
    expenditure    double comment '支出',
    income         double comment '收入',
    remark         varchar(200) null comment '备注',
    addDate        datetime     not null comment '添加时间'
) comment '账单';

drop table if exists lrp_pd;

create table lrp_pd
(
    id      int auto_increment primary key comment '序号',
    year    int comment '年份',
    month   int comment '月份',
    storeId int comment '仓库编号',
    pdName  varchar(400) not null comment '盘点名称',
    remark  varchar(200) null comment '备注',
    addDate datetime     not null comment '添加时间'
) comment '盘点表';

drop table if exists lrp_pdline;

create table lrp_pdline
(
    id       int auto_increment primary key comment '序号',
    pdId     int,
    itemId   int         not null comment '物资编号',
    orderQty int         not null comment '订购数量',
    issueQty int         not null comment '销售数量',
    storeId  varchar(45) not null comment '仓库编号'
) comment '盘点子表';










