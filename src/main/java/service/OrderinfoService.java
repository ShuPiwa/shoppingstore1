package service;

import entity.Orderinfo;

public interface OrderinfoService {
    int deleteByPrimaryKey(String username);

    int insert(Orderinfo record);

    int insertSelective(Orderinfo record);

    Orderinfo selectByPrimaryKey(String username);


}
