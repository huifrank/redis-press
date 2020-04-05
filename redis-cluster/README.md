
启动集群
docker-compose up -d

查看节点ip地址
docker inspect --format='{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' node-80

初始化集群
docker exec -it  node-80 redis-cli -p 6380 --cluster create {node-80 ip}:6380  {node-81 ip}:6381  {node-82 ip}:6382  {node-83 ip}:6383  {node-84 ip}:6384  {node-85 ip}:6385 --cluster-replicas 1


