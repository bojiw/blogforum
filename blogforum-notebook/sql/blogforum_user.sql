/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/6/7 0:38:50                             */
/*==============================================================*/


drop table if exists area;

drop table if exists permision;

drop table if exists role;

drop table if exists role_permision;

drop table if exists user;

/*==============================================================*/
/* Table: area                                                  */
/*==============================================================*/
create table area
(
   id                   int not null auto_increment comment '编号',
   name                 varchar(40) comment '区域名',
   parent_id            int comment '上级id',
   del_flag             char(1) comment '删除标记 N为不删除 Y为删除',
   primary key (id)
)
ENGINE = InnoDB;

alter table area comment '区域表';

/*==============================================================*/
/* Table: permision                                             */
/*==============================================================*/
create table permision
(
   id                   int not null auto_increment comment '编号',
   name                 varchar(50) comment '权限名称',
   controller           varchar(255) comment '访问路径',
   primary key (id)
)
ENGINE = InnoDB;

alter table permision comment '权限表';

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   id                   int not null auto_increment comment '编号',
   name                 varchar(20) comment '角色名称',
   create_by            varchar(32) comment '创建者',
   create_date          datetime comment '创建时间',
   update_date          datetime comment '更新时间',
   remarks              varchar(255) comment '备注',
   del_flag             char(1) comment '删除标记 N为不删除 Y为删除',
   primary key (id)
)
ENGINE = InnoDB;

alter table role comment '角色表';

/*==============================================================*/
/* Table: role_permision                                        */
/*==============================================================*/
create table role_permision
(
   id                   int not null auto_increment comment '编号',
   role_id              int,
   permision_id         int,
   primary key (id)
)
ENGINE = InnoDB;

alter table role_permision comment '角色权限对应表';

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   varchar(64) not null comment '编号',
   username             varchar(32) not null comment '登录用户名',
   password             varchar(32) not null comment '密码',
   salt                 varchar(10) not null comment '加盐',
   role                 int not null comment '角色',
   email                varchar(50) comment 'Email邮件',
   iphone               varchar(50) comment '手机号',
   create_date          datetime comment '创建时间',
   update_date          datetime comment '更新时间',
   login_date           datetime comment '最后登录时间',
   login_ip             varchar(20) comment '最后登录ip',
   status               int default 0 comment '状态 0为正常 1为无法登录 2为删除状态',
   image                varchar(100) comment '头像路径',
   update_by            varchar(64) comment '更新人',
   remarks              varchar(255) comment '备注信息',
   province_location    int comment '所在省份',
   city_location        int comment '所在城市',
   birth_province       int comment '出生省份',
   birth_city           int comment '出生城市',
   primary key (id)
)
ENGINE = InnoDB;

alter table user comment '用户表';

