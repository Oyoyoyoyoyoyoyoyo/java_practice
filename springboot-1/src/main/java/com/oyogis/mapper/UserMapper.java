/*
package com.oyogis.mapper;

import com.oyogis.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;
import org.springframework.data.repository.query.Param;

@Mapper
public interface UserMapper {
    */
/**
     * 根据name查询用户
     * @param name
     * @return
     *//*

    @Select("SELECT * FROM USER WHERE NAME=#{name}")
    User findByName(@Param("name") String name);

    */
/**
     * 新建用户
     * @param name
     * @param age
     * @return
     *//*

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);
}
*/
