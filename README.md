# BigData
大数据-电商项目

## 架构图

![Image](https://github.com/lazy-apple/BigData/blob/master/image/%E6%9E%B6%E6%9E%84%E5%9B%BE.png)

![Image](https://github.com/lazy-apple/BigData/blob/master/image/%E6%95%B0%E6%8D%AE%E5%BA%93.png)

## 项目架构：
Spring MVC + Spring + Hibernate+maven+nginx+tomcat+flume+kafka+hdfs+hive+sqoop+mysql

## 项目描述：
用户访问页面，将用户及其访问的资源进行记录并统计，

## 技术实现：
web部分使用ssh框架。客户端访问网页经过nginx做反向代理（动态资源到达tomcat，静态资源到达nginx）。
Linux开启周期性调度任务，实现日志滚动。
flume进行日志收集。
kafka同一主题不同组创建两个消费者：消费者1将原生数据写入hdfs上；kafka消费者2将原生数据清洗并保存在hive的分区表中。
hive中执行hiveQL脚本进行统计
通过sqoop将统计结果导出到mysql（也使用Linux周期调度任务）
使用jf生成饼图。

## 责任描述：
全程负责，独立完成
