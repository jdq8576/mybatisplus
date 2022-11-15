package cn.edu.njtech.mybatisplus.mapper;

import cn.edu.njtech.mybatisplus.entity.User;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tim
 * @date 2022/11/15 17:14
 */
public interface UserMapper extends BaseMapper<User> {

    User findMyUser(Long id);

    List<User> findMyUserByWrapper(@Param(Constants.WRAPPER) Wrapper<User> wrapper);

}
