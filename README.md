##服务搭建心路历程
持续完善中...

#应用组件
注册中心cloud-eureka  : http://localhost:8761/eureka
网关cloud-zuul
配置中心cloud-config
服务调用cloud-feign
负载cloud-ribbon
熔断cloud-hystrix
消息驱动cloud-stream(rabbitmq)
链路跟踪cloud-Sleuth(zipkin) : http://localhost:9411
#日志搭建方案
打印、保存-logback
分布式日志搜集、图形化查询展示-ELK
    Elasticsearch : http://localhost:9200
    Elasticsearch head: http://localhost:9100
    logstash
    bikana : http://localhost:5601
        坑   ：  集群健康值: 未连接   https://blog.csdn.net/majunzhu/article/details/100105290
#rest接口调试
swagger2 : http://localhost:8767/swagger-ui.html

