

### MyBatis-Plus

> Mybatis-Plus（简称MP）是一个 Mybatis 的增强工具，在 Mybatis 的基础上只做增强不做改变，为简化开发、提高效率而生 

```
<!--mybatis-plus-->
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.0.5</version>
</dependency>

<!--mysql-->
<!--mysql6以及以上是com.mysql.cj.jdbc.Driver 并且在url之后要指定时区-->
<!--如果你的配置数据库文件是 com.mysql.jdbc.Driver 这个jar包版本换成5.1.8的-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.8</version>
</dependency>

mapper 继承 BaseMapper<Entity>
```



> 主键生成策略

```java
/*
    AUTO、INPUT、NONE、
    mp自带策略：ID_WORKER(19位数字)、ID_WORKER_STR(19位字符)
*/
@TalbleId(type=IdType.AUTO)
private Loing id;

1.自动增长
	AUTO_INCREMENT
2.UUID
	每次生成随机唯一的值
3.Redis实现
    可以使用Redis集群来获职更高的贡吐里。假如一个集群中有5台Redis.
    可以初始化每台Redis的值分别是1,2,3,4,5,然后步长都是S。备个Redis生成的ID为:
        A: 1,6,11,16,21
        B: 2,7,12,17,22
        C: 1,3,8,13,18,23
        D: 4,9,14,19,24
        E: 5,10,15,20,25
4.mp自带策略
	snowflake算法
	核心思想是:
		使用41bit作为毫秒数，10bit作为机器的ID (5个bit是数据中心，5个bit的机器ID)
		12bit作为毫秒内的流水号意昧着每个节点在每毫秒可以产生4096个ID)
```



> 自动填充

```java
1.在实体类属性添加注解
	@TableField(fill=Field.INSERT)
	private Date createTime;
	@TableField(file=Field.INSERT_UPDATE)
	private Date updateTime;
2.创建类，实现MetaObjectHandle实现接口的方法
    @Component
    public class MyMetaObjectHandler implements MetaObjectHandler {
        //自动填充：执行插入操作
        @Override
        public void insertFill(MetaObject metaObject) {
            this.setFieldValByName("version",1,metaObject);
            this.setFieldValByName("createDateTime",new Date(),metaObject);
            this.setFieldValByName("updateDateTime",new Date(),metaObject);
        }

        //自动填充：执行更新操作
        @Override
        public void updateFill(MetaObject metaObject) {
            this.setFieldValByName("updateDateTime",new Date(),metaObject);
        }
    }
```



> 乐观锁

```
悲观锁 乐观锁是一种思想。

悲观锁这是一种对数据的修改抱有悲观态度的并发控制方式。我们一般认为数据被并发修改的概率比较大，所以需要在修改之前先加锁。但是在效率方面，处理加锁的机制会让数据库产生额外的开销，还有增加产生死锁的机会。使用的话，先将自动提交事务关闭，开启事务，select…for update会把数据给锁住，更新数据，关闭事务

乐观锁在对数据库进行处理的时候，乐观锁并不会使用数据库提供的锁机制。一般的实现乐观锁的方式就是记录数据版本。解决丢失更新，更新时带上版本号条件。使用的话update items set age = 2where id = 1 and version = 3;
```



> 乐观锁：MyBatisPlus实现

```java
1.再实体类属性添加注解
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;
2.添加乐观锁插件
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
3.代码实现
    //测试乐观锁：先查询 再修改
    User user = userMapper.selectById(2);
    user.setUserName("二哥");
    int num = userMapper.updateById(user);
    System.out.println(num);
```



> 分页查询

```java
1.添加分页插件
    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
2.代码实现
    Page<User> userPage = new Page<>(1,3);
    userPage.setDesc("id");
    userMapper.selectPage(userPage,null);

    System.out.println(userPage.getCurrent());
    System.out.println(userPage.getSize());
    System.out.println(userPage.getTotal());
    System.out.println(userPage.getRecords().toString());
```



> 逻辑删除

```java
1.再实体类属性添加注解
    @TableLogic
	private Integer is_delete;
2.添加逻辑删除插件
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }
3.实现代码
    //逻辑删除，底层执行的更新操作
    int num = userMapper.deleteById(2);
	//配置逻辑删除插件，查询时会带上is_delete条件，想查询删除的数据，只能通过.xml查询
    List<User> userList = userMapper.selectList(null);
```



> 性能分析

```java
1.添加性能分析插件
    @Bean
    @Profile({"dev","test"})// 设置 dev test 环境开启
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(500);//ms，超过此处设置的ms则sql不执行
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }
```



> 复杂查询

```java
//Wrapper实现类
QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
//查询条件
userQueryWrapper.eq("user_name","采先生i");
//查询需要的字段
userQueryWrapper.select("id","user_name","create_date_time");
//执行查询
List<User> userList = userMapper.selectList(userQueryWrapper);
```

