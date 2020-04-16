package service;

import entity.Productinfo;

import java.util.List;

public interface ProductinfoService {

    List<Productinfo> selectType();


    List<Productinfo> getProductsByPtype(String pType);
    Productinfo selectByPrimaryKey(Integer pId);

    int updateByUsername(Integer pId,Integer pNum);

    int insert(Productinfo record);



}
