# RESTful-Like-Backend-Template

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

## 使用说明
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
本项目在运行以后有两个地址：
```apple js
#Swagger生成API页面地址
http://IP(localhost):Port(8080)//swagger-ui.html

#Druid连接池后台配置地址
http://IP(localhost):Port(8080)/druid/login.html
```
其中Druid默认的登陆账户和密码为：
```apple js
userName:admin
password:123456
```
可以在webapp/WEB-INF/web.xml中更改


## 未来更新
+ 支持跨域访问
+ 为MybatisSQL注解添加一些常见的LanguageDriver
+ 扩展通用Mapper接口



