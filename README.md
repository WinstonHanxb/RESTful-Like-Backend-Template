# RESTful-like-SSM-Template

## 介绍
本项目是一套基于SSM基础组建的J2EE后台基础框架，适用于类`RESTful`风格的后台API开发。按照Ian Robinson博士的成熟度模型，该项目可以满足Level 2等级的`RESTful`成熟度要求。

## 框架组成
#### 主要组件
+ **Spring 4.3.7**
+ **SpringMVC 4.3.7**
+ **Mybatis 3.4.2**
+ **sf4j 1.7.25**
+ **Spring-fox 2.7.0**
+ **Druid 1.0.31**

#### 工具组件
+ **Spring-Test 4.3.7**
+ **Junit 2.9.0**
+ **Mybatis通用Mapper 3.4.0**
+ **Mybatis-Pagehelper 5.0.0**

#### 依赖管理
+ **Gradle 3.5**

##使用说明
#### 安装
```$xslt
git clone https://github.com/WinstonHanxb/RESTful-like-SSM-Template
```
或者下载Zip
```$xslt
#进入项目所在地址
./gradlew clean

./gradlew build
```

#### 更改配置
整个项目的主要配置文件在`src/main/resources`下
```$xslt
#MybatisGenerator配置
generatorConfig.xml
#log4j配置
log4j.properties
#Spring根配置文件
spring.xml
#Spring Beans根配置文件
spring-beans.xml
#springMVC配置文件
spring-mvc.xml
#spring-mybatis配置文件
spring-mybatis.xml
#MybatisMapper文件配置
sqlMapperConfig.xml
```

#### 其他




