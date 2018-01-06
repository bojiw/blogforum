# blogforum
博记系统

## 前言
博记系统是一款笔记加博客结合的一款系统，其实主要是为了借着这个系统来学习新的技术，从零开始搭建整个分布式系统的架构，而且是自己的系统，所以只要有什么好的想法都可以加进去，通过实践来快速积累技术经验

## 项目介绍
项目的核心为两块 一块为笔记系统 一块为博客系统，笔记系统核心功能就是可以记录笔记并且可以搜索笔记，相当于印象笔记，而博客系统则类似于CSDN，可以发布博客让人观看学习，和上面的两个主要的区别为笔记和博客系统之间的数据是打通的，可以直接把笔记一键分享到博客平台，也可以记录自己的私人笔记而不进行共享


## 技术架构
- blogforum-parent  ------------------------ 父工程
- blogforum-common  ----------------------  公共工具模块
- blogforum-manager -----------------------后台管理系统(主要管理整个网站的后台)
- - blogforum-manager-web -------------------后台前端层
- - blogforum-manager-service -----------------后台服务层
- - blogforum-manager-pojo -------------------后台模型层
- - blogforum-manager-dao ------------------- 后台数据库层
- - blogforum-manager-common ---------------后台工具层
- - blogforum-manager-facade -----------------后台对外接口层
- - blogforum-manager-integration -------------后台接入接口层
- blogorum-sso------------------------------单点登录系统(登录系统,除管理系统外所有系统统一的登录入口)
- - blogforum-sso-web ------------------------单点前端层
- - blogforum-sso-service --------------------- 单点服务层
- - blogforum-sso-pojo ------------------------单点模型层
- - blogforum-sso-dao ------------------------ 单点数据库层
- - blogforum-sso-common --------------------单点工具层
- - blogforum-sso-facade ----------------------单点对外接口层
- - blogforum-sso-integration ------------------单点接入接口层
- blogforum-notebook------------------------笔记系统(核心笔记系统,可以让人记录和搜索笔记)
- - blogforum-notebook-web -------------------笔记前端层
- - blogforum-notebook-service ---------------- 笔记服务层
- - blogforum-notebook-pojo ------------------ 笔记模型层
- - blogforum-notebook-dao ------------------- 笔记数据库层
- - blogforum-notebook-common ---------------笔记工具层
- - blogforum-notebook-facade -----------------笔记对外接口层
- - blogforum-notebook-integration -------------笔记接入接口层
- blogforum-docking------------------------对接第三方系统(所有调用第三方系统对接的统一放在这个系统中如短信,邮箱)
- - blogforum-docking-web ---------------------第三方前端层
- - blogforum-docking-service ------------------ 第三方服务层
- - blogforum-docking-pojo ---------------------第三方模型层
- - blogforum-docking-dao --------------------- 第三方数据库层
- - blogforum-docking-common -----------------第三方工具层
- - blogforum-docking-facade -------------------第三方对外接口层
- - blogforum-docking-integration ---------------第三方接入接口层
- blogforum-search------------------------搜索系统(提供整个网站所有的搜索服务)
- - blogforum-search-web ----------------------搜索前端层
- - blogforum-search-service ------------------- 搜索服务层
- - blogforum-search-pojo --------------------- 搜索模型层
- - blogforum-search-dao ----------------------搜索数据库层
- - blogforum-search-common ----------------- 搜索工具层
- - blogforum-search-facade ------------------- 搜索对外接口层
- - blogforum-search-integration --------------- 搜索接入接口层
- blogforum-blog------------------------ 博客系统(核心博客系统,主要为查看他人博客)
- - blogforum-blog-web ----------------------- 博客前端层
- - blogforum-blog-service ---------------------博客服务层
- - blogforum-blog-pojo -----------------------博客模型层
- - blogforum-blog-dao ----------------------- 博客数据库层
- - blogforum-blog-common -------------------博客工具层
- - blogforum-blog-facade ---------------------博客对外接口层
- - blogforum-blog-integration -----------------博客接入接口层

## 系统架构

![](http://ouqhxmwfh.bkt.clouddn.com/20181/201816143147图片.png)

## 系统功能

![](http://ouqhxmwfh.bkt.clouddn.com/20181/201816144226图片.png)


## 各项目详细介绍地址

[单点登录系统](https://github.com/MrNiceWangwendi/blogforum-sso "单点登录系统")

[笔记系统](https://github.com/MrNiceWangwendi/blogforum-notebook "笔记系统")

[第三方对接系统](https://github.com/MrNiceWangwendi/blogforum-docking "第三方对接系统")

[搜索系统](https://github.com/MrNiceWangwendi/blogforum-search "搜索系统")


## 技术选型
#### java框架使用：
spring mvc、spring、mybatis、为了学习单点登录系统使用了spring boot
#### 数据库
mysql
#### 数据库中间件
druid、后期打算上mycat
#### 消息中间件
rabbitmq
#### rpc框架
dubbo、zookeeper
#### 搜索引擎
solr、IK分词器
#### 配置中心
后期打算用阿波罗
#### 富文本
wangeditor编辑器、editor.md
#### 图片服务器
七牛云
#### 图片转文字
百度ocr识别
#### 短信
阿里大于
#### 邮箱
网易
#### 前端
bootstrap、jquery 后期打算用vue.js
#### 服务器
阿里云、docker、nginx、jenkins、nexus
#### 后期打算用到的技术
kafak配合elasticsearch做日志管理系统

Hadoop做用户搜索分析系统

Python做爬取博客系统

recat做移动端

鹰眼做分布式跟踪系统

异步命令框架
