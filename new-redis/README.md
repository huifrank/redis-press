# new-redis

支持redis集群模式  有密码，无密码连接热切换

1 开启testOnBorrow。

2 在执行ping异常后根据配置判断是否需要执行auth操作。

3 如果当前集群无密码，执行auth会抛异常。
## 修改点：

### jedis
`redis.clients.jedis.JedisFactory#validateObject`

