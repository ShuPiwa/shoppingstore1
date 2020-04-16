package mapper;

import entity.Productinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductinfoMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Productinfo record);

    int insertSelective(Productinfo record);

    Productinfo selectByPrimaryKey(Integer pId);

    List<Productinfo> selectType();

    List<Productinfo> getProductsByPtype(String pType);
    int updateByPrimaryKeySelective(Productinfo record);

    int updateByPrimaryKey(Productinfo record);

    int updateByUsername(@Param("pId") Integer pId, @Param("pNum") Integer pNum);


}