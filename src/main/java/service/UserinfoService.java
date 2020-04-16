package service;

import entity.Userinfo;

import java.util.List;

public interface UserinfoService {

    int deleteByPrimaryKey(Integer uId);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);

    List<Userinfo> selectAll();

    Userinfo selectByName(String username,String password);

    Userinfo selectName(String name);



}
