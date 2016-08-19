# MPGankIO

> 这个App其实是拿来锻炼架构所用,欢迎大家来指正和讨论，
> App结构采用MVP但是并没有同官方MVP一样写Contract接口来解耦
> 后续如果有需要可以爬一波包包通缉令的数据O(∩_∩)O~~


---

# 详细解读可以进入我的[博客](http://www.mapleslong.com)或者[简书](http://www.jianshu.com/users/0da7bdbfddb2)

第一次写文章，希望大家轻喷哈~~！！

### APP框架搭建：
```
 * 网络框架 
   1. RxJava
   2. Retrofit
   3. Gson
   4. okhttp
  
 * 图片框架
   1. Glide(推荐采用，Google官方推荐)

 * 注入框架
   1. ButterKnife(神器不解释) 
   
 * 内存泄露检测
   1. Leakcanary
```

> 我觉得放代码会印象阅读，所以采用图片贴代码的形式解读

### 目录结构

![MPGankIO目录结构](http://o6kv2wscf.bkt.clouddn.com/16-8-19/78414221.jpg)


  > adapter 放置各个模块的数据适配器 
  
  > config  放置app的一些设置常用变量 
  
  > entity  放置数据对象实例         
  
 > manager 放置自定义的一些全局管理对象(例如AccountManager、ActivityStackManager)
 
 > module  放置我们的app应用模块例如home/main等
 
 > network 放置网络框架我自定义和参考了一些大牛设计集成而来至于是谁我下次翻到的时候把链接打上去（大牛看到不要拍我）
 
 > utils 放置app用到的工具类
 
 > ui 因为这个app没有我自定义的ui所以暂时没有放上去

## MVP架构搭建核心
> BaseMvpActivity.java

![](http://o6kv2wscf.bkt.clouddn.com/16-8-19/49528159.jpg)

后文用到的BaseMvpFragment.java同理可得

---

> BasePresenter.java
 
![](http://o6kv2wscf.bkt.clouddn.com/16-8-19/50537867.jpg)

里面采用了Rxjava的CompositeSubscription请求全局控制
并且将View附加给Presenter来进行与View的沟通

---

#这样一来MVP基本的架构就搭好啦！

有问题可以来我[博客](http://www.mapleslong.com)或者[简书](http://www.jianshu.com/users/0da7bdbfddb2)反馈,谢谢大家的停留在这里时间
 
 [附上源码下载地址](https://github.com/mapleslong/MPGankIO) 