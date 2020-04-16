package mapper;

import entity.Orderinfo;

public interface OrderinfoMapper {
    int deleteByPrimaryKey(String username);

    int insert(Orderinfo record);

    int insertSelective(Orderinfo record);

    Orderinfo selectByPrimaryKey(String username);
}