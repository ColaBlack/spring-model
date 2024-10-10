# springModel

**Read this in English: [English](README_en.md)**

**想看中文文档请点击这里：[中文](README.md)**

#### 介绍
springboot后端项目模版
是与前端项目[vue-model](https://gitee.com/colablack/vue-model)配套的后端项目

#### 软件架构

- 使用spring boot进行项目开发
- 使用mybatis和mybatis plus进行数据访问层开发
- 出于后期可能的用户量激增问题，先使用了spring-session-data-redis实现分布式登录（由于此方案侵入性极低所以才提前使用）
- 为了节省开发成本，使用了apache commons-lang3以及lombok提高开发效率
- 使用Hutool工具箱发送请求到图床以实现上传的头像、题库、判题结果展示图等信息
#### 安装教程

1.  克隆或下载本仓库代码
2. 运行
```bash
mvn dependency:resolve
```
或使用IntelliJ IDEA
安装项目所需的maven依赖
3. 修改application.yml的配置信息如：
   MySQL数据库或其他关系型数据库的驱动、地址、账号和密码
   redis的地址、账号和密码
4.创建src/main/resources/images文件夹，用于存放临时上传的图片
5.本项目默认将图片上传到图床中，为了保证我的图床的安全，我隐藏了我的AUTH_CODE,
如果要正常使用，请建立src/main/java/edu/zafu/teaai/constant/ImageBedConstant.java
内容如下
```java
package edu.zafu.teaai.constant;

/**
 * 图床上传文件需要的常量
 *
 * @author ColaBlack
 */
public class ImageBedConstant {
    public static final String IMAGE_BED_URL = "你的图床地址";

    public static final String IMAGE_BED_UPLOAD_URL = IMAGE_BED_URL + "/upload";

    public static final String AUTH_CODE = "你的图床的AUTH_CODE";
}
```
6.运行sql/create_table.sql里的建表语句创建项目所需的表
7.运行MainApplication启动项目

#### 使用说明

1.  由于你使用的对象存储未必是腾讯云，甚至有可能想把文件存在个人的图床（就是我）或本地，所以调用腾讯云对象存储的代码并不完全，也可以删除需要则自己补全
    其中
- src/main/java/edu/zafu/teaai/config/CosClientConfig.java
- src/main/java/edu/zafu/teaai/constant/FileConstant.java
- src/main/java/edu/zafu/teaai/controller/FileController.java
- src/main/java/edu/zafu/teaai/manager/CosManager.java
  的代码均与之相关

2. 代码中存在很多被注释的接口，那些接口代码是后端开发时为前端预留的接口，但最终并没有使用所以通过注释的方式关闭了

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat分支
3.  提交代码
4.  新建 Pull Request
