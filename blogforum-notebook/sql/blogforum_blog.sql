/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/6/7 0:36:29                             */
/*==============================================================*/


drop table if exists blog_comment;

drop table if exists blog_note;

drop table if exists reply;

drop table if exists user_blog_history;

/*==============================================================*/
/* Table: blog_comment                                          */
/*==============================================================*/
create table blog_comment
(
   id                   varchar(64) not null comment '编号',
   user_id              varchar(64) not null comment '用户编号',
   blognode_id          varchar(64) not null comment '博客笔记编号',
   content              text not null comment '评论内容',
   create_date          datetime not null comment '创建时间',
   storey               char(1) comment '是否有回复N代表没有 Y代表有',
   release_flat         char(1) comment '是否发布 N代表不发布 Y代表发布',
   primary key (id)
)
ENGINE = InnoDB;

alter table blog_comment comment '博客评论表';

/*==============================================================*/
/* Table: blog_note                                             */
/*==============================================================*/
create table blog_note
(
   id                   varchar(64) not null comment '编号',
   note_title           varchar(255) not null comment '笔记标题',
   note_body            text comment '笔记内容',
   user_id              varchar(64) comment '用户id',
   enclosure            varchar(64) comment '附件路径',
   notebook_id          varchar(64) comment '笔记本id',
   image                varbinary(255) comment '图片路径',
   imagetext            text comment '图片文字内容',
   del_flag             char(1) comment '删除标记 N为不删除 Y为删除',
   create_date          datetime not null comment '创建时间',
   update_date          datetime not null comment '更新时间',
   comment_num          int comment '评论数量',
   small_image          varchar(255) comment '缩略图路径',
   lasttime             datetime comment '最后回复时间',
   last_userid          varchar(64) comment '最后回复人',
   release_flat         char(1) comment '是否发布  N为不发布 Y为发布',
   visit                int comment '访问次数',
   primary key (id)
)
ENGINE = InnoDB;

alter table blog_note comment '博客笔记 存放发布到博客的笔记';

/*==============================================================*/
/* Table: reply                                                 */
/*==============================================================*/
create table reply
(
   id                   varchar(64) not null comment '编号',
   user_id              varchar(64) not null comment '用户编号',
   blognode_id          varchar(64) not null comment '博客笔记编号',
   content              text not null comment '评论内容',
   create_date          datetime not null comment '创建时间',
   release_flat         char(1) comment '是否发布 N为不发布 Y为发布',
   primary key (id)
)
ENGINE = InnoDB;

alter table reply comment '楼层回复表';

/*==============================================================*/
/* Table: user_blog_history                                     */
/*==============================================================*/
create table user_blog_history
(
   id                   varchar(64) not null comment '编号',
   user_id              varchar(64) not null comment '用户id',
   blog_note_id         varchar(64) not null comment '博客id',
   create_date          datetime not null comment '访问时间',
   primary key (id)
)
ENGINE = InnoDB;

alter table user_blog_history comment '博客访问历史记录';

