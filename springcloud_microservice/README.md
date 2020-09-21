# springcloud-microservice
Spring Cloud 快速搭建微服务
<br>
spring cloud 为开发人员提供了快速构建分布式系统的一些工具，包括配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等等，下面进行个服务分部搭建源码与测试案例
<br>


## 组织结构

	springcloud-microservice
	├── micro-eureka-server -- Netflix Eureka服务注册中心      [端口 8101]
	| 
	├── micro-service-example -- 服务消费
	|	├── micro-serviceA -- 服务消费A[端口 8201] 
	|	├── micro-serviceB -- 服务消费B[端口 8202] 
	|  
	├── micro-ribbon-server --服务分发（rest+ribbon） [端口 8301] 
    |	
	|── micro-feign-server  --服务分发（feign）       [端口 8302] 
	|
	|── micro-hystrix-example --断路器\服务消费+（Hystrix)+(Hystrix 仪表盘)
   	|	├── micro-ribbon-hystrix -- (ribbon+hystrix)  [端口 8311] 
	|	├── micro-feign-hystrix  -- (feign+hystrix)   [端口 8312]
    |
    |── micro-route-zuul  --路由网关(zuul)            [端口 8401] 



## 开发目录视图
![输入图片说明](https://git.oschina.net/uploads/images/2017/0830/211743_6fec89da_1468963.png "Hystrix-Dev.png")


### 模块清单

- ### [ Netflix Eureka服务注册中心 [端口 8101]](http://git.oschina.net/lishangzhi2012/springcloud-microservice/blob/master/micro-eureka-server/README.md "micro-eureka-server")
- ### [服务消费](http://git.oschina.net/lishangzhi2012/springcloud-microservice/tree/master/micro-service-example)
- ### [服务分发（rest+ribbon） [端口 8301] ](http://git.oschina.net/lishangzhi2012/springcloud-microservice/tree/master/micro-ribbon-client)
- ### [服务分发（feign）  [端口 8302] ](http://git.oschina.net/lishangzhi2012/springcloud-microservice/tree/master/micro-feign-client)
- ### [断路器\服务消费+（Hystrix)+(Hystrix 仪表盘)](http://git.oschina.net/lishangzhi2012/springcloud-microservice/tree/master/micro-hystrix-example)
- ### [路由网关(zuul)](http://git.oschina.net/lishangzhi2012/springcloud-microservice/tree/master/micro-route-zuul)

### 已完成模块简介(参考官网给出的图加)
- **#服务发现——Netflix Eureka**
- ![输入图片说明](https://git.oschina.net/uploads/images/2017/0830/165340_44d3d98a_1468963.png "Netflix Eureka.png")
- **#客服端负载均衡——Netflix Ribbon**
- ![输入图片说明](https://git.oschina.net/uploads/images/2017/0830/165539_d48d8dd2_1468963.png "Netflix Ribbon.png")
- **#断路器——Netflix Hystrix**
- ![输入图片说明](https://git.oschina.net/uploads/images/2017/0830/170046_2f0fb128_1468963.png "Netflix Hystrix.png")
- **#服务网关——Netflix Zuul  (部分已更新)**
- ![输入图片说明](https://git.oschina.net/uploads/images/2017/0830/212842_53dc6eda_1468963.png "zuul.png")



<br>
### 中文官网
[Spring Cloud中文网-官方文档中文版](https://springcloud.cc/)

### 整体进度与计划
![输入图片说明](https://git.oschina.net/uploads/images/2017/0830/213129_35c805e0_1468963.png "Hystrix.png")
<br>
<br>
### 持续更新！！！


