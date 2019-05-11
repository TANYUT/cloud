##### Liunx Ubuntu
设置 Root 账户密码 :  sudo passwd root 

设置允许远程登录 Root:
 ```
 vi /etc/ssh/sshd_config
 Authentication:
 LoginGraceTime 120
 #PermitRootLogin without-password     //注释此行
 PermitRootLogin yes                             //加入此行
 StrictModes yes
 重启服务
 service ssh restart
 ```
 
 
 #
 
 
##### Liunx 目录说明
 目录  |  说明
 ---- | ----- |
 bin  | 存放二进制可执行文件(ls,cat,mkdir等) 
 boot  | 存放用于系统引导时使用的各种文件   
 dev  | 用于存放设备文件   
 ect  | 存放系统配置文件   
 home  |    存放所有用户文件的根目录
 lib  | 存放跟文件系统中的程序运行所需要的共享库及内核模块   
 mnt  | 系统管理员安装临时文件系统的安装点   
 opt  | 额外安装的可选应用程序包所放置的位置   
 proc  | 虚拟文件系统，存放当前内存的映射   
 root  | 超级用户目录 
 sbin  | 存放二进制可执行文件，只有root才能访问
 tmp  | 用于存放各种临时文件 
 usr  | 用于存放系统应用程序，比较重要的目录/usr/local 本地管理员软件安装目录 
 var  | 用于存放运行时需要改变数据的文件 
 
 #
 
##### Liunx 远程管理
检查是否安装OpenSSH: `apt-cache policy openssh-client openssh-server `

安装OpenSSH server : ` sudo  apt-get install openssh-server `

安装OpenSSH client : ` sudo  apt-get install openssh-client` 

OpenSSH 服务器的主要配置文件为：` /etc/ssh/sshd_config 置信息都在此文件中`

#

##### Liunx 命令
 命令  |  说明 | 语法   | 参数说明
 ---- | ----- |  -----  | ----- |
 mkdir  | 创建目录 | mkdir [-p] dirName | -p上级不存在生成上级 
 touch  | 生成一个空文件 
 cat  | 显示文本文件内容  |cat  fileName
 cp  | 复制文件或者目录  | cp [options]   target| options拷贝的文件或文件夹 target目标文件夹
 rm  | 删除文件  | rm [-f] [-r] [options] name |  -f 强制删除 -r同时删除该目录下的所有文件
 mv  | 移动文件|   mv  fileName destination|fileName(文件名文件夹) destination(移动到哪里)
 find  | 在文件系统中查找指定的文件| find -name | -name文件名
 grep  | 在指定的文本文件中查找指定的字符串|
 tree  | 用于以树状图列出目录的内容|
 pwd  | 显示当前工作目录|
 ln  | 建立软链接|
 tail  | 显示文件结尾内容|
 vi  | 编辑文件 | vi [n] [-r] [/str] filename| 光标置于n行首   -r在上次正用vi编辑时发生系统崩溃,恢复filename 光标置于第一个与str匹配处 
  vi   |  按ESC键 到命令模式 然后 | :w保存文件但不退出 - :w file将修改另外保存到file中，不退出- :w!强制保存,不退出 |:wq 保存文件并退出  -:wq! 强制保存文件,并退出 q:不保存文件,退出vi:q! 不保存文件，强制退出vi  :e! 放弃所有修改，从上次保存文件开始再编辑
 stat  | 显示指定文件的相关信息
 who  | 显示在线登录用户
 hostname  | 显示主机名称
 uname  | 显示系统信息
 top 	|显示当前系统中耗费资源最多的进程
 ps 	|显示瞬间的进程状态
 du 	|显示指定的文件（目录）已使用的磁盘空间的总量
 df 	|显示文件系统磁盘空间的使用情况
 free 	|显示当前内存和交换空间的使用情况
 ifconfig | 	显示网络接口信息
 ping | 	测试网络的连通性
 netstat |	显示网络状态信息
 clear |	清屏
 kill -9	|杀死一个进程 
 shutdown	| 关机 |shutdown [-t seconds] [-rkhncfF] time [message]|-t设定在几秒钟之后进行关机程序   -k并不会真的关机,只是将警告讯息传送给所有只用者 -r关机后重新开机（重启）-h关机后停机 -n不采用正常程序来关机，用强迫的方式杀掉所有执行中的程序后自行关机 -c取消目前已经进行中的关机动作 -f关机时，不做 fcsk 动作(检查 Linux 档系统) -F关机时，强迫进行 fsck 动作 time设定关机的时间  message传送给所有使用者的警告讯息
 tar	| tar 压缩命令  压缩文件夹：tar -zcvf test.tar.gz test\  解压文件夹：tar -zxvf test.tar.gz |tar [-cxzjvf] 压缩打包文档的名称 欲打包目录|-c建立一个归档文件的参数指令  -x解开一个归档文件的参数指令 -z是否需要用 gzip 压缩 -j是否需要用 bzip2 压缩 -v压缩的过程中显示文件 -f使用档名，在 f 之后要立即接档名 -tf查看归档文件里面的文件
 
 重启:reboot     shutdown -r now
 关机:shutdown -h now
##### Linux 文件权限管理
    -：普通文件
    rw-：说明用户 user 有读写权限，没有运行权限
    r--：表示用户组 user 只有读权限，没有写和运行的权限
    r--：其他用户只有读权限，没有写权限和运行的权限   
    
-rw-r--r-- 	|1 	|user |	user 	|675 	|Oct 26 17:20 |	.profile
 ---- | ----- |  -----  | ----- |----- |----- |----- |
文档类型及权限 |	连接数| 	文档所属用户 |	文档所属组 |	文档大小| 	文档最后被修改日期 	|文档名称
 
(?) - |	rw- 	|r-- |	r--|
---- | ----- |  -----  | -----  |
文档类型| 	文档所有者权限（user） |	文档所属用户组权限（group） |	其他用户权限（other）
- d 表示目录
- l 表示软连接
- (-)表示文件
- c 表示串行端口字符设备文件
- b 表示可供存储的块设备文件
- 余下的字符 3 个字符为一组。r 只读，w 可写，x 可执行，- 表示无此权限
##### 更改操作权限
改变访问权限

chmod  |	[who] 	|[+、-、=] |[mode] 文件名|
---- | ----- |  -----  | -----  |
chmod | u：用户user、g：用户组group 、 o：表示其他用户、a：表示所有用户是系统默认的| +：表示添加某个权限 -：表示取消某个权限 =：赋予给定的权限，取消文档以前的所有权限 |	表示可执行的权限，可以是 r、w、x

示例 
 ```
user@UbuntuBase:~$ ls -al test.txt 
-rw-rw-r-- 1 user user 6 Nov  2 21:47 test.txt
user@UbuntuBase:~$ chmod u=rwx,g+r,o+r test.txt 
user@UbuntuBase:~$ ls -al test.txt 
-rwxrw-r-- 1 user user 6 Nov  2 21:47 test.txt
user@UbuntuBase:~$
```
数字设定法
- 0 表示没有任何权限
- 1 表示有可执行权限 = x
- 2 表示有可写权限 = w
- 4 表示有可读权限 = r

r w x | r – x | r - x |
---- | ----- |  -----  |
4 2 1 |	4 - 1 |4 - 1
user |	group |	others

若要 rwx 属性则 4+2+1=7 

若要 rw- 属性则 4+2=6  

若要 r-x 属性则 4+1=5  
   ` user@UbuntuBase:~$ chmod 777 test.txt 
    user@UbuntuBase:~$ ls -al test.txt 
    -rwxrwxrwx 1 user user 6 Nov  2 21:47 test.txt    
    user@UbuntuBase:~$ chmod 770 test.txt 
    user@UbuntuBase:~$ ls -al test.txt 
    -rwxrwx--- 1 user user 6 Nov  2 21:47 test.txt`


#


##### Liunx 软件包管理
APT(Advanced Packaging Tool) 是 Debian/Ubuntu 类 Linux 系统中的软件包管理程序, 使用它可以找到想要的软件包, 而且安装、卸载、更新都很简便；也可以用来对 Ubuntu 进行升级; APT 的源文件为 /etc/apt/ 目录下的 sources.list 文件。 \
查看系统版本:`lsb_release -a `

编辑数据源:` vi /etc/apt/sources.list`

删除全部内容并修改为:
``` 
deb http://mirrors.aliyun.com/ubuntu/ xenial main restricted universe multiverse 
deb http://mirrors.aliyun.com/ubuntu/ xenial-security main restricted universe multiverse
deb http://mirrors.aliyun.com/ubuntu/ xenial-updates main restricted universe multiverse 
deb http://mirrors.aliyun.com/ubuntu/ xenial-backports main restricted universe multiverse
``` 
更新数据源:`apt-get update` 

安装软件包: `apt-get install packagename`  

删除软件包: `apt-get remove packagename` 

更新软件包列表: `apt-get update` 

升级有可用更新的系统（慎用）: `apt-get upgrade `

搜索:  `apt-cache search package`  

获取包信息: `apt-cache show package  ` 

删除包及配置文件: ` apt-get remove package --purge`  

了解使用依赖: `apt-cache depends package ` 

查看被哪些包依赖: `apt-cache rdepends package ` 

安装相关的编译环境: `apt-get build-dep package ` 

下载源代码: `apt-get source package ` 

清理无用的包: `apt-get clean && apt-get autoclean` 

查看被哪些包依赖:` apt-get check `    

#

##### Linux 安装 MySQL
安装 MySQL:   `apt-get install mysql-server`  

系统将提示您在安装过程中创建 root 密码。选择一个安全的密码，并确保你记住它，因为你以后需要它。接下来，我们将完成 MySQL 的配置。

###### 配置 
因为是全新安装，您需要运行附带的安全脚本。这会更改一些不太安全的默认选项，例如远程 root 登录和示例用户。在旧版本的 MySQL 上，您需要手动初始化数据目录，但 Mysql 5.7 已经自动完成了
```mysql_secure_installation``` 

这将提示您输入您在之前步骤中创建的 root 密码。您可以按 Y，然后 ENTER 接受所有后续问题的默认值，但是要询问您是否要更改 root 密码。您只需在之前步骤中进行设置即可，因此无需现在更改。
###### 测试
按上边方式安装完成后，MySQL 应该已经开始自动运行了。要测试它，请检查其状态。
```
user@ubuntu:~$ systemctl status mysql.service
● mysql.service - MySQL Community Server
   Loaded: loaded (/lib/systemd/system/mysql.service; enabled; vendor preset: enabled)
   Active: active (running) since Tue 2017-11-21 13:04:34 CST; 3min 24s ago
 Main PID: 2169 (mysqld)
   CGroup: /system.slice/mysql.service
           └─2169 /usr/sbin/mysqld

Nov 21 13:04:33 ubuntu systemd[1]: Starting MySQL Community Server...
Nov 21 13:04:34 ubuntu systemd[1]: Started MySQL Community Server.

```
查看 MySQL 版本：`mysqladmin -p -u root version`

 ###### 配置远程访问
- 修改配置文件: `/etc/mysql/mysql.conf.d/mysqld.cnf`
- 注释掉(语句前面加上 # 即可): `bind-address = 127.0.0.1  `
- 或改为: `bind-address = 0.0.0.0 `
- 重启 MySQL: `service mysql restart`
- 登录 MySQL: `mysql -u root -p`
- 授权 root 用户允许所有人连接: `grant all privileges on *.* to 'root'@'%' identified by '你的 mysql root 账户密码';`

###### 因弱口令无法成功授权解决步骤
- 查看和设置密码安全级别:
```
select @@validate_password_policy; 
set global validate_password_policy=0;
 ```
- 查看和设置密码长度限制
```
select @@validate_password_length;
set global validate_password_length=1;
 ```
###### 常用命令
启动：`service mysql start` 

停止：`service mysql stop` 

重启：`service mysql restart`
###### 其它配置
修改配置 mysqld.cnf 配置文件: `/etc/mysql/mysql.conf.d/mysqld.cnf`

```
配置默认字符集:
        在 [mysqld] 节点上增加如下配置
        [client]
        default-character-set=utf8
        在 [mysqld] 节点底部增加如下配置
        default-storage-engine=INNODB
        character-set-server=utf8
        collation-server=utf8_general_ci
 配置忽略数据库大小写敏感: 
        在 [mysqld] 节点底部增加如下配置
        lower-case-table-names = 1
```
##### Linux 安装 Java

解压缩:` tar -zxvf jdk-8u152-linux-x64.tar.gz`

创建目录: `mkdir -p /usr/local/java` 

移动安装包: `mv jdk1.8.0_152/ /usr/local/java/`

设置所有者: `chown -R root:root /usr/local/java/`

### 配置系统环境变量

系统环境变量配置文件: `/etc/environment`

JAVA环境变量:
```$xslt
PATH="/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games"
export JAVA_HOME=/usr/local/java/jdk1.8.0_152 # 此处为自己本地目录
export JRE_HOME=/usr/local/java/jdk1.8.0_152/jre
export CLASSPATH=$CLASSPATH:$JAVA_HOME/lib:$JAVA_HOME/jre/lib
```
用户环境变量配置文件: `/etc/profile`

添加如下语句
 ```
if [ "$PS1" ]; then
  if [ "$BASH" ] && [ "$BASH" != "/bin/sh" ]; then
    # The file bash.bashrc already sets the default PS1.
    # PS1='\h:\w\$ '
    if [ -f /etc/bash.bashrc ]; then
      . /etc/bash.bashrc
    fi
  else
    if [ "`id -u`" -eq 0 ]; then
      PS1='# '
    else
      PS1='$ '
    fi
  fi
fi

export JAVA_HOME=/usr/local/java/jdk1.8.0_152 #注意本机地址
export JRE_HOME=/usr/local/java/jdk1.8.0_152/jre
export CLASSPATH=$CLASSPATH:$JAVA_HOME/lib:$JAVA_HOME/jre/lib
export PATH=$JAVA_HOME/bin:$JAVA_HOME/jre/bin:$PATH:$HOME/bin

if [ -d /etc/profile.d ]; then
  for i in /etc/profile.d/*.sh; do
    if [ -r $i ]; then
      . $i
    fi
  done
  unset i
fi
```
#### 使用户环境变量生效
```
source /etc/profile
```
测试是否安装成功: `java -version`

为其他用户更新用户环境变量:
```$xslt
su user
source /etc/profile
```
#####[Linux LVM 磁盘扩容](LVM.md)
#### 附：Linux LVM 磁盘扩容





