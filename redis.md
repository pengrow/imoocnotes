# 这是 H1
## 这是 H2
###### 这是 H6

redis入门
第1章 课程介绍
1-1 课程介绍

第2章 NoSQL概述
2-1 NoSQL的概述

NoSQL = Not Only SQL 非关系型数据库

为什么需要NoSQL？
    High performance -高并发读写
    Huge Storage -海量数据的高效率存储和访问
    High Scalability && High Availabiliy -高可扩展性和高可用性

NoSQL数据的四大分类
    键值（Key-Value）存储：Redis
    列存储：HBase
    文档数据库：MongoDb
    图形数据库：

NoSQL的特点：
    易扩展
    灵活的数据模型
    大数据量，高性能
    高可用

第3章 Redis概述
3-1 Redis的概述
高性能键值对数据库，支持的键值数据类型：
字符串类型、散列类型、列表类型、集合类型、有序集合类型

Redis应用场景：
缓存
任务队列
应用排行榜
网站访问统计
数据过期处理
分布式集群架构中的session分离

第4章 Redis的安装和使用

第5章 Jedis的入门
5-1 Jedis的入门
   Jedis是Redis官方首选的Java客户端开发包


第9章 Redis的持久化

RDB持久化：每隔一定时间写入磁盘

AOF持久化：日志方式记录服务器的每个操作
优势：每秒同步，每个操作同步，append方式.
AOF可以修改.aof文件，撤销某些操作，进行数据还原

无持久化：缓存
同时使用RDB和AOF

