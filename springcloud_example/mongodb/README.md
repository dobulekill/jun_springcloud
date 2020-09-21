# MongoDB

#### 介绍
springboot-MongoDB搭建及增删改查

#### 使用教程

1. elasticsearch6.8.4  <br/>
    - 下载 <br/>
    https://www.elastic.co/cn/downloads/elasticsearch <br/>
    - 配置<br/>
    解压后，打开 ```config/elasticsearch.yml```，对其中两项配置进行修改 <br/>
        - ```cluster.name```集群名称，随便填写，或者使用默认的“my-application”，注意，后面Java链接elasticsearch时，需要该配置。
        - ```network.host```如果此不配置此项，其他机器无法链接当前elasticsearch。配置为：（0.0.0.0代表任何IP都可访问）
        - 启动 <br/>
        Mac/Linux：运行 ```bin/elasticsearch```<br/>
        Windows：运行 ```bin\elasticsearch.bat```
2. analysis-ik 6.8.4 <br/>
    - 安装执行命令： <br/>
    ```bin/elasticsearch-plugin install https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v6.8.4/elasticsearch-analysis-ik-6.8.4.zip```
3. 如果下载太慢先运行：npm config set registry https://registry.npm.taobao.org
4. 默认端口：9200是http访问端口；9300是tcp访问端口

#### 版本说明

1.  jdk1.8
2.  elasticsearch 6.8.4
3.  spring-boot:2.2.1;spring-cloud:Hoxton.RC2

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request

公众号关注一波
![](../5cm.jpg)