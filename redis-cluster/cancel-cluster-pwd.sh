#!/bin/bash

/usr/local/redis-5.0.8/src/redis-cli -p 6380 -a 123456 config set requirepass ''
/usr/local/redis-5.0.8/src/redis-cli -p 6381 -a 123456 config set requirepass ''
/usr/local/redis-5.0.8/src/redis-cli -p 6382 -a 123456 config set requirepass ''
/usr/local/redis-5.0.8/src/redis-cli -p 6383 -a 123456 config set requirepass ''
/usr/local/redis-5.0.8/src/redis-cli -p 6384 -a 123456 config set requirepass ''
/usr/local/redis-5.0.8/src/redis-cli -p 6385 -a 123456 config set requirepass ''
