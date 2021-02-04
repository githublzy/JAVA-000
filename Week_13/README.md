Week13 作业题目：

周四作业：
### 1.（必做）搭建 ActiveMQ 服务，基于 JMS，写代码分别实现对于 queue 和 topic 的消息生产和消费，代码提交到 github。

启动ActiveMQ
```
./activemq console
http://127.0.0.1:8161/admin/
Login: admin
Passwort: admin
```

queue
连接
```
Destination destination = new ActiveMQQueue("gaol.test.queue");
ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
ActiveMQConnection conn = (ActiveMQConnection) factory.createConnection();
conn.start();
Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
```

生产
```
MessageProducer producer = session.createProducer(destination);
for (int i = 0; i < 10; i++) {
    TextMessage message = session.createTextMessage(i + " message.");
    producer.send(message);
}
```

消费
```
MessageConsumer consumer = session.createConsumer( destination );
final AtomicInteger count = new AtomicInteger(0);
consumer.setMessageListener(message -> {
    System.out.println(count.incrementAndGet() + " => receive from " + destination.toString() + ": " + message);
});
```

周六作业：
### 1.（必做）搭建一个 3 节点 Kafka 集群，测试功能和性能；实现 spring kafka 下对 kafka 集群的操作，将代码提交到 github。

启动zookeeper
```
mv conf/zoo_sample.cfg conf/zoo.cfg
vim conf/zoo.cfg
mkdir data
dataDir=/Users/a/Downloads/apache-zookeeper-3.6.2-bin/data
bin/zkServer.sh start
bin/zkCli.sh -server 127.0.0.1:2181
```

```
[zk: 127.0.0.1:2181(CONNECTED) 0] ls /
[zookeeper]
[zk: 127.0.0.1:2181(CONNECTED) 1] ls /zookeeper 
[config, quota]
[zk: 127.0.0.1:2181(CONNECTED) 2] 
```

启动kafka
```
vim config/server.properties
listeners=PLAINTEXT://localhost:9092
bin/kafka-server-start.sh config/server.properties 
```

```
[zk: 127.0.0.1:2181(CONNECTED) 4] ls /
[admin, brokers, cluster, config, consumers, controller, controller_epoch, feature, isr_change_notification, latest_producer_id_block, log_dir_event_notification, zookeeper]
```
