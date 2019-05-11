#### Docker 
##### Docker 的整个生命周期。
- 镜像 `Image`
- 容器 `Container`
- 仓库 `Repository`

Docker  |	面向对象|
|----|----|
容器 	| 对象
镜像 	| 类

标题   |	说明 |
|----|----|
镜像(Images) |	Docker 镜像是用于创建 Docker 容器的模板。
容器(Container) 	|容器是独立运行的一个或一组应用。
客户端(Client) |	Docker 客户端通过命令行或者其他工具使用 Docker API (https://docs.docker.com/reference/api/docker_remote_api ) 与 Docker 的守护进程通信。
主机(Host) |	一个物理或者虚拟的机器用于执行 Docker 守护进程和容器。
仓库(Registry) 	|Docker 仓库用来保存镜像，可以理解为代码控制中的代码仓库。Docker Hub(https://hub.docker.com ) 提供了庞大的镜像集合供使用。
Docker Machine |	Docker Machine是一个简化Docker安装的命令行工具，通过一个简单的命令行即可在相应的平台上安装Docker，比如VirtualBox、 Digital Ocean、Microsoft Azure。


#####  Docker 镜像

[Docker Hub官方镜像地址](https://hub.docker.com/search/?q=&type=image)

###### Docker 获取镜像
```
docker pull [选项] [Docker Registry 地址[:端口号]/]仓库名[:标签]
```
具体的选项可以通过 docker pull --help 命令看到，这里我们说一下镜像名称的格式。
- Docker 镜像仓库地址：地址的格式一般是 <域名/IP>[:端口号]。默认地址是 Docker Hub。
- 仓库名：如之前所说，这里的仓库名是两段式名称，即 <用户名>/<软件名>。对于 Docker Hub，如果不给出用户名，则默认为 library，也就是官方镜像
比如：`$ docker pull ubuntu:16.04` 

从官方镜像 library/ubuntu 仓库中标签为 16.04 的镜像。不写版本 默认拉取 latest 版

仓库名 |  标签(版本) |   镜像 ID   |  创建时间       |   所占用的空间   |  
|----|----|----|----|----|
REPOSITORY |  TAG |   IMAGE ID     |  CREATED      |   SIZE   |  
redis  |  latest  |  5f515359c7f8  |  5 days ago   |  183 MB  |   
nginx  |  latest  |  05a60462f8ba  |  5 days ago   |  181 MB  |   
mongo  |  3.2     |  fe9198c04d62  |  5 days ago   |  342 MB  |   
ubuntu |  16.04   |  f753707788c5  |  4 weeks ago  |  127 MB  |   
ubuntu |  latest  |  f753707788c5  |  4 weeks ago  |  127 MB  |  
<none> |  <none>  |  00285df0df87  |  5 days ago   |  342 MB  | 
    
镜像体积 你可以通过以下命令来便捷的查看镜像、容器、数据卷所占用的空间。
 
```$xslt
$ docker system df

TYPE                TOTAL               ACTIVE              SIZE                RECLAIMABLE
Images              24                  0                   1.992GB             1.992GB (100%)
Containers          1                   0                   62.82MB             62.82MB (100%)
Local Volumes       9                   0                   652.2MB             652.2MB (100%)
Build Cache     
```

查看虚悬镜像: `ocker image ls -f dangling=true`
```$xslt
<none>               <none>              00285df0df87        5 days ago          342 MB
```
###### Docker 镜像加速
 Ubuntu 16.04+
 
 请在 /etc/docker/daemon.json 中写入如下内容（如果文件不存在请新建该文件）
 ```$xslt
{
  "registry-mirrors": [
    "https://registry.docker-cn.com"
  ]
}
```
之后重新启动服务
```$xslt
$ sudo systemctl daemon-reload
$ sudo systemctl restart docker
```


##### 安装 Docker

卸载旧版本:`sudo apt-get remove docker docker-engine docker.io`

使用脚本自动安装
```
$ curl -fsSL get.docker.com -o get-docker.sh
# 可能会出现 404 错误，请移步下面的特别说明
$ sudo sh get-docker.sh --mirror Aliyun
```

启动 Docker CE
```
$ sudo systemctl enable docker
$ sudo systemctl start docker
```

##### Docker 命令API

命令  |	说明 |
|----- |  -----  |
docker images [ls] 	| 看docker 程序镜像
docker image prune  | 刪除虚悬镜像
docker image ls -a  | 中间层镜像
docker image ls ubuntu  | 根据仓库名列出镜像
docker image ls ubuntu:16.04 | 列出特定的某个镜像
docker image ls --digests  | 列出镜像镜像摘要 
docker rmi [IMAGE ID] 	| 删除[IMAGE ID]镜像
docker ps -a  | 查看镜像被那个容器占用  CONTAINER ID  容器ID 
docker stop [CONTAINER ID]| 停止容器 [CONTAINER ID] 
docker rm [CONTAINER ID]  | 删除容器 [CONTAINER ID] 
docker start    |redis-server 
docker exec -d  |redis-server --port 6379  













