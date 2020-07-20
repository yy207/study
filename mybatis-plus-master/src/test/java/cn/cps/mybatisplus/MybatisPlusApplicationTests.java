package cn.cps.mybatisplus;

import cn.cps.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void contextLoads() {

        //查询
//        List<User> list = userMapper.selectList(null);
//        System.out.println(list.toString());

        //插入
//        User user = new User();
//        user.setUserName("埃索达");
//        user.setUserGender(1);
//        user.setUserPassword("123456");
//        int num = userMapper.insert(user);
//        System.out.println(num);

        //更新 自动填充
//        User user = new User();
//        user.setId(2);
//        user.setUserName("埃索达");
//        user.setUserGender(0);
//        int num = userMapper.updateById(user);
//        System.out.println(num);

        //测试乐观锁：先查询 再修改
//        User user = userMapper.selectById(2);
//        user.setUserName("大哥");
//        int num = userMapper.updateById(user);
//        System.out.println(num);

        //多个id批量查询
//        List<User> userList = userMapper.selectBatchIds(Arrays.asList(1,2,3));
//        System.out.println(userList.toString());

        //分页查询
//        Page<User> userPage = new Page<>(1,3);
//        userPage.setDesc("id");
//        userMapper.selectPage(userPage,null);
//
//        System.out.println(userPage.getCurrent());
//        System.out.println(userPage.getSize());
//        System.out.println(userPage.getTotal());
//        System.out.println(userPage.getRecords().toString());

        //逻辑删除
//        int num = userMapper.deleteById(5);
//        System.out.println(num);
//        //配置逻辑删除插件，查询时会带上is_delete条件
//        List<User> userList = userMapper.selectList(null);
//        System.out.println(userList);

        //复杂查询
//        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
//        //查询条件
//        userQueryWrapper.eq("user_name","采先生i");
//        //查询需要的字段
//        userQueryWrapper.select("id","user_name","create_date_time");
//        //执行查询
//        List<User> userList = userMapper.selectList(userQueryWrapper);
//        System.out.println(userList.toString());

    }

}
