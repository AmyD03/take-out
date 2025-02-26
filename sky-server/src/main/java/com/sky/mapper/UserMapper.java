package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface UserMapper {
    /**
     * 根据openid查询用户
     * @param openid
     * @return
     */
    @Select("select * from user where openid = #{openid}")
    User getUserById(String openid);

    /**
     * 插入数据
     * @param user
     * @return
     */
    void insert(User user);

    /**
     *
     * @param map
     * @return
     */
    Integer countByMap(Map map);
}
