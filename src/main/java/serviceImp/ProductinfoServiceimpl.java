package serviceImp;

import entity.Productinfo;
import mapper.ProductinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ProductinfoService;

import java.util.List;
@Service
public class ProductinfoServiceimpl implements ProductinfoService {

    @Autowired
    ProductinfoMapper pm;
    @Override
    public List<Productinfo> selectType() {
        return pm.selectType();
    }

    @Override
    public List<Productinfo> getProductsByPtype(String pType) {
        return pm.getProductsByPtype(pType);
    }

    @Override
    public Productinfo selectByPrimaryKey(Integer pId) {
        return pm.selectByPrimaryKey(pId);
    }

    @Override
    public int updateByUsername( Integer pId, Integer pNum) {
        return pm.updateByUsername(pId,pNum);
    }

    @Override
    public int insert(Productinfo record) {
        return pm.insert(record);
    }
}
