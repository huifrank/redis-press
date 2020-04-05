#!/bin/bash

sudo mkdir -p /var/redis/6380
sudo mkdir -p /var/redis/6381
sudo mkdir -p /var/redis/6382
sudo mkdir -p /var/redis/6383
sudo mkdir -p /var/redis/6384
sudo mkdir -p /var/redis/6385

sudo mkdir -p /var/log/redis/


sudo /usr/local/redis-5.0.8/src/redis-server /Users/lihui/playground/redis-cluster/conf/redis-6380.conf &
sudo /usr/local/redis-5.0.8/src/redis-server /Users/lihui/playground/redis-cluster/conf/redis-6381.conf &
sudo /usr/local/redis-5.0.8/src/redis-server /Users/lihui/playground/redis-cluster/conf/redis-6382.conf &
sudo /usr/local/redis-5.0.8/src/redis-server /Users/lihui/playground/redis-cluster/conf/redis-6383.conf &
sudo /usr/local/redis-5.0.8/src/redis-server /Users/lihui/playground/redis-cluster/conf/redis-6384.conf &
sudo /usr/local/redis-5.0.8/src/redis-server /Users/lihui/playground/redis-cluster/conf/redis-6385.conf &

sleep 1

sudo echo yes | /usr/local/redis-5.0.8/src/redis-cli -p 6380 --cluster create 127.0.0.1:6380  127.0.0.1:6381  127.0.0.1:6382  127.0.0.1:6383  127.0.0.1:6384  127.0.0.1:6385 --cluster-replicas 1

/usr/local/redis-5.0.8/src/redis-cli -p 6380 cluster nodes