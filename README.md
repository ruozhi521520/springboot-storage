# 基于SpringBoot+Mybatis+MySQL8的仓储管理系统

## 主要用到的技术：

* 使用maven进行项目构建
* 使用Springboot+Mybatis搭建整个系统
* 使用ajax连接前后端
* 使用框架thymeleaf、JQuery开发前端界面
* 使用MySQL存储数据

## 主要分为六个模块

* **今日出库**：库存出库管理
* **今日入库**：库存入库管理
* **库存管理**：库存清单数据
* **库存盘点**：库存盘点数据
* **基础数据**：物资编码、仓库管理、买家管理
## 问题：如何启动本系统？

1. 将sql文件在MySQL运行生成表和数据
2. 最后直接启动LrpApplication类后访问http://localhost:8080/login 就可以进入本系统！

   github地址：https://github.com/ruozhi521520/springboot-storage

## 功能展示

* 登录页

![image](https://github.com/ruozhi521520/springboot-storage/blob/master/image/login.png?raw=true)

* 首页

![image](https://github.com/ruozhi521520/springboot-storage/blob/master/image/index.png?raw=true)


* 今日出库

![image](https://github.com/ruozhi521520/springboot-storage/blob/master/image/out.png?raw=true)


* 库存管理

![image](https://github.com/ruozhi521520/springboot-storage/blob/master/image/inv.png?raw=true)

