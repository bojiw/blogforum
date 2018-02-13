/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/6/7 0:38:00                             */
/*==============================================================*/


drop table if exists huishouz;

drop table if exists note;

drop table if exists note_book;

drop table if exists public_node_user;

drop table if exists public_note;

drop table if exists pwd_share_node;

/*==============================================================*/
/* Table: huishouz                                              */
/*==============================================================*/
create table huishouz
(
   id                   varchar(64) not null comment '编号',
   note_title           varchar(255) comment '笔记标题',
   note_body            text comment '笔记内容',
   create_date          datetime comment '创建时间',
   update_date          datetime comment '更新时间',
   user_id              varchar(64) not null comment '用户id',
   notebook_id          varchar(64) comment '笔记本id',
   blog_id              varchar(64) comment '博客笔记id',
   enclosure            varchar(255) comment '附件路径',
   image                varchar(255) comment '存放图片路径',
   imagetext            text comment '图片文字',
   del_flag             char(1) comment '删除标记 N为不删除 Y为删除',
   pwd_share_id         varchar(64) comment '加密共享笔记id',
   small_image          varchar(255) comment '缩略图地址',
   label       		    varchar(255) comment '标签 用;隔开',
   primary key (id)
)
ENGINE = InnoDB;

alter table huishouz comment '回收笔记表';

/*==============================================================*/
/* Table: note                                                  */
/*==============================================================*/
create table note
(
   id                   varchar(64) not null comment '编号',
   note_title           varchar(255) comment '笔记标题',
   note_body            text comment '笔记内容',
   create_date          datetime not null comment '创建时间',
   update_date          datetime not null comment '更新时间',
   user_id              varchar(64) not null comment '用户id',
   notebook_id          varchar(64) comment '笔记本id',
   blog_id              varchar(64) comment '博客笔记id',
   enclosure            varchar(255) comment '附件路径',
   image                varchar(255) comment '存放图片路径',
   imagetext            text comment '图片文字',
   del_flag             char(1) comment '删除标记 N为不删除 Y为删除',
   pwd_share_id         varchar(64) comment '加密共享笔记id',
   small_image          varchar(255) comment '缩略图图片路径',
   label              varchar(255) comment '标签用;隔开',
   primary key (id)
)
ENGINE = InnoDB;

alter table note comment '笔记表';

/*==============================================================*/
/* Table: note_book                                             */
/*==============================================================*/
create table note_book
(
   id                   varchar(64) not null comment '笔记本编号',
   parent_id            varchar(20) comment '父类目ID=0时，代表的是一级的类目',
   name                 varchar(64) not null comment '笔记本名称',
   user_id              varchar(64) not null comment '创建笔记本的用户id',
   create_date          datetime not null comment '创建时间',
   update_date          datetime not null comment '更新时间',
   primary key (id)
)
ENGINE = InnoDB;

alter table note_book comment '笔记本   保存笔记';

/*==============================================================*/
/* Table: public_node_user                                      */
/*==============================================================*/
create table public_node_user
(
   id                   varchar(64) not null comment '编号',
   user_id              varchar(64) not null comment '用户id',
   publicnote_id        varchar(64) not null comment '公共笔记id',
   primary key (id)
)
ENGINE = InnoDB;

alter table public_node_user comment '公共多人协作笔记和用户对应表';

/*==============================================================*/
/* Table: public_note                                           */
/*==============================================================*/
create table public_note
(
   id                   varchar(64) not null comment '编号',
   note_title           varchar(255) comment '笔记标题',
   note_body            text comment '笔记内容',
   create_date          datetime comment '创建时间',
   update_date          datetime comment '更新时间',
   notebook_id          varchar(64) comment '笔记本id',
   enclosure            varchar(255) comment '附件路径',
   imag                 text comment '图片文字',
   del_flag             char(1) comment '删除标记 N为不删除 Y为删除',
   user_id              varchar(64) comment '创建笔记人编号',
   primary key (id)
)
ENGINE = InnoDB;

alter table public_note comment '公共的笔记 可以多人协作写同一个笔记';

/*==============================================================*/
/* Table: pwd_share_node                                        */
/*==============================================================*/
create table pwd_share_node
(
   id                   varchar(64) not null comment '编号',
   user_id              varchar(64) not null comment '用户id',
   node_id              varchar(64) not null comment '笔记id',
   password             varchar(32) not null comment '加密密码',
   create_date          datetime comment '创建时间',
   primary key (id)
)
ENGINE = InnoDB;

alter table pwd_share_node comment '加密访问笔记  用户分享以后会生成一个密码 其他人查看加密的笔记需要输入密码';

