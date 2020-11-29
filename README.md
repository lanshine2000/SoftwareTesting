# 项目testCompress

* 姓名：宋龙
* 联系方式：421087409@qq.com
* 完成日期：2020.11.29

## 目录

[TOC]

## 项目开发

* 使用git clone将项目下载到本地，并使用Eclipse、IDEA等集成开发工具打开项目
* 使用Maven自动下载pom.xml中依赖的库

* 在MyCompress类里面实现了方法Files2Zip和Zip2Files，分别对应压缩文件和解压文件
* 在MyCompressTest类里面实现了方法Files2Zip和Zip2Files的单元测试
* 在MockTest类里面实现了桩模块的替换

## 方法

* 在 src/test/java 下编写完测试用例后可以使用Junit等工具进行本地的单元测试
* 在IDEA等集成开发工具内将代码commit并push到GitHub服务器， Jenkins的触发器会自动检测Git仓库代码的更新并自动进行集成测试，生成测试结果
* 在GitHub的Issue模块，提交缺陷管理报告