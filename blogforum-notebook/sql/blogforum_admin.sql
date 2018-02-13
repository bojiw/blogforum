/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/6/7 0:39:05                             */
/*==============================================================*/


drop table if exists admin_user;

drop table if exists permision;

drop table if exists role;

drop table if exists role_permision;

drop table if exists visitor;

/*==============================================================*/
/* Table: admin_user                                            */
/*==============================================================*/
create table admin_user
(
   id                   int not null auto_increment comment '编号',
   username             varchar(32) not null comment '登录用户名',
   password             varchar(32) not null comment '密码',
   salt                 varchar(10) not null comment '加盐',
   role                 int not null comment '角色',
   create_date          datetime not null comment '创建时间',
   primary key (id)
)
ENGINE = InnoDB;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES ('21', 'admin', '676d58c2465f9f07a5df53252715dcaa', '5ZUthcz@', '1', '2017-02-26 19:36:34');
INSERT INTO `admin_user` VALUES ('22', 'pxp', '47bfa59a515bc726b79176d3bd3b5827', 'cfrGc#pS', '1', '2017-02-26 19:47:38');

alter table admin_user comment '管理员用户表';

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

-- ----------------------------
-- Records of permision
-- ----------------------------
INSERT INTO `permision` VALUES ('1', '首页页面', '/index.jsp');
INSERT INTO `permision` VALUES ('3', '首页请求', '/index.action');
INSERT INTO `permision` VALUES ('4', '主页页面', '/index_v1.jsp');
INSERT INTO `permision` VALUES ('6', '退出请求', '/loginout.action');
INSERT INTO `permision` VALUES ('7', '管理员用户设置页面', '/usermanager/adminUserShow.jsp');

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
-- ----------------------------
-- Records of role_permision
-- ----------------------------
INSERT INTO `role_permision` VALUES ('1', '1', '1');
INSERT INTO `role_permision` VALUES ('2', '1', '3');
INSERT INTO `role_permision` VALUES ('3', '1', '4');
INSERT INTO `role_permision` VALUES ('5', '1', '6');
INSERT INTO `role_permision` VALUES ('6', '1', '7');


alter table role_permision comment '角色权限对应表';

/*==============================================================*/
/* Table: visitor                                               */
/*==============================================================*/
create table visitor
(
   id                   varchar(64) not null comment '编号',
   user_id              varchar(64) not null comment '用户id',
   visit_date           datetime not null comment '访问开始时间',
   left_date            datetime comment '访问结束时间',
   ip                   varchar(10) comment '访问ip地址',
   client               varchar(32) comment '访问客户端设备',
   primary key (id)
)
ENGINE = InnoDB;

alter table visitor comment '网站访问记录';

