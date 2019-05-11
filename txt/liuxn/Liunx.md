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
##### Liunx 远程管理
检查是否安装OpenSSH: \
apt-cache policy openssh-client openssh-server \
安装OpenSSH server :  sudo  apt-get install openssh-server \
安装OpenSSH client :  sudo  apt-get install openssh-client \
OpenSSH 服务器的主要配置文件为 /etc/ssh/sshd_config 置信息都在此文件中
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
#####Linux 文件权限管理
    -：普通文件
    rw-：说明用户 lusifer 有读写权限，没有运行权限
    r--：表示用户组 lusifer 只有读权限，没有写和运行的权限
    r--：其他用户只有读权限，没有写权限和运行的权限   
    
-rw-r--r-- 	|1 	|lusifer |	lusifer 	|675 	|Oct 26 17:20 |	.profile
 ---- | ----- |  -----  | ----- |----- |----- |----- |
文档类型及权限 |	连接数| 	文档所属用户 |	文档所属组 |	文档大小| 	文档最后被修改日期 	|文档名称
 
(?) - |	rw- 	|r-- |	r--|
---- | ----- |  -----  | -----  |
文档类型| 	文档所有者权限（user） |	文档所属用户组权限（group） |	其他用户权限（other）
- d表示目录
- l表示软连接
- 表示文件
- c表示串行端口字符设备文件
- b表示可供存储的块设备文件
- 余下的字符 3 个字符为一组。r 只读，w 可写，x 可执行，- 表示无此权限

###### 更改操作权限

chmod

改变访问权限

chmod  |	[who] 	|[+、-、=] |[mode] 文件名|
---- | ----- |  -----  | -----  |
chmod | u：用户user、g：用户组group 、 o：表示其他用户、a：表示所有用户是系统默认的| +：表示添加某个权限 -：表示取消某个权限 =：赋予给定的权限，取消文档以前的所有权限 |	表示可执行的权限，可以是 r、w、x
示例 
 
    lusifer@UbuntuBase:~$ ls -al test.txt 
    -rw-rw-r-- 1 lusifer lusifer 6 Nov  2 21:47 test.txt
    lusifer@UbuntuBase:~$ chmod u=rwx,g+r,o+r test.txt 
    lusifer@UbuntuBase:~$ ls -al test.txt 
    -rwxrw-r-- 1 lusifer lusifer 6 Nov  2 21:47 test.txt
    lusifer@UbuntuBase:~$

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

    lusifer@UbuntuBase:~$ chmod 777 test.txt 
    lusifer@UbuntuBase:~$ ls -al test.txt 
    -rwxrwxrwx 1 lusifer lusifer 6 Nov  2 21:47 test.txt    
    lusifer@UbuntuBase:~$ chmod 770 test.txt 
    lusifer@UbuntuBase:~$ ls -al test.txt 
    -rwxrwx--- 1 lusifer lusifer 6 Nov  2 21:47 test.txt

##### Liunx 软件包管理
APT(Advanced Packaging Tool) 是 Debian/Ubuntu 类 Linux 系统中的软件包管理程序, 使用它可以找到想要的软件包, 而且安装、卸载、更新都很简便；也可以用来对 Ubuntu 进行升级; APT 的源文件为 /etc/apt/ 目录下的 sources.list 文件。 \
查看系统版本:lsb_release -a\
编辑数据源: vi /etc/apt/sources.list
删除全部内容并修改为:
``` 
deb http://mirrors.aliyun.com/ubuntu/ xenial main restricted universe multiverse 
deb http://mirrors.aliyun.com/ubuntu/ xenial-security main restricted universe multiverse
deb http://mirrors.aliyun.com/ubuntu/ xenial-updates main restricted universe multiverse 
deb http://mirrors.aliyun.com/ubuntu/ xenial-backports main restricted universe multiverse
``` 
更新数据源:apt-get update \
安装软件包: apt-get install packagename \
删除软件包: apt-get remove packagename \
更新软件包列表: apt-get update \
升级有可用更新的系统（慎用）: apt-get upgrade 

搜索: apt-cache search package    \
获取包信息: apt-cache show package    \
删除包及配置文件: apt-get remove package --purge  \
了解使用依赖: apt-cache depends package   \
查看被哪些包依赖: apt-cache rdepends package   \
安装相关的编译环境: apt-get build-dep package   \
下载源代码: apt-get source package  \
清理无用的包: apt-get clean && apt-get autoclean   \
查看被哪些包依赖: apt-get check    
