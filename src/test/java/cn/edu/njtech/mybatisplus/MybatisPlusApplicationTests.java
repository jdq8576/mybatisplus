package cn.edu.njtech.mybatisplus;

import cn.edu.njtech.mybatisplus.entity.User;
import cn.edu.njtech.mybatisplus.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

@SpringBootTest
class MPTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testQueryList() {
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setUserName("Tim");
        user.setPassword("889977");
        int r = userMapper.insert(user);
        System.out.println(r);
    }

    @Test
    public void testDelete() {
        List<Integer> ids = new ArrayList<>();
        ids.add(5);
        ids.add(6);
        ids.add(7);
        int i = userMapper.deleteBatchIds(ids);
        System.out.println(i);
    }

    @Test
    public void testDeleteById() {
        int i = userMapper.deleteById(8);
        System.out.println(i);
    }

    @Test
    public void testDeleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "提姆");
        map.put("age", 22);
        int i = userMapper.deleteByMap(map);
        System.out.println(i);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(2L);
        user.setAge(14);
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    @Test
    public void testWrapper01() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.gt("age", 18);
        wrapper.eq("address", "狐山");
        final List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void testWrapper02() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.in("id", 1, 2, 3);
        wrapper.between("age", 12, 29);
        wrapper.like("address", "山");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testWrapper03() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", 1, 2, 3);
        queryWrapper.gt("age", 10);
        queryWrapper.orderByDesc("age");
        final List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelect01() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "user_name");
        final List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelect02() {
        /**
         * 方法的第一个参数为实体类的字节码对象，第二个参数为Predicate类型，可以使用lambda的写法，过滤要查询的字段 (主键除外) 。
         */
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select(User.class, new Predicate<TableFieldInfo>() {
            @Override
            public boolean test(TableFieldInfo tableFieldInfo) {
                return "user_name".equals(tableFieldInfo.getColumn());
            }
        });
        final List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelect03() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(new User());
        queryWrapper.select(new Predicate<TableFieldInfo>() {
            @Override
            public boolean test(TableFieldInfo tableFieldInfo) {
                return !"address".equals(tableFieldInfo.getColumn());
            }
        });
        final List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testUpdateWrapper() {
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.gt("id", 1);
        userUpdateWrapper.set("age", 99);
        userMapper.update(null, userUpdateWrapper);
    }

    @Test
    public void testLambdaWrapper() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 18);
        queryWrapper.eq("address", "狐山");
        final List<User> users = userMapper.selectList(queryWrapper);
    }

    @Test
    public void testLambdaWrapper2() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.gt(User::getAge, 18);
        queryWrapper.eq(User::getAddressStr, "狐山");
        final List<User> users = userMapper.selectList(queryWrapper);
    }

    @Test
    public void testMyMethod() {
        final User myUser = userMapper.
                findMyUser(4L);
        System.out.println(myUser);
    }

    @Test
    public void testMyMethod2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("id", 2);
        final List<User> users = userMapper.findMyUserByWrapper(queryWrapper);
        users.forEach(System.out::println);
    }
}
