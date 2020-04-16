package serviceImp;

import entity.Orderinfo;
import mapper.OrderinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.OrderinfoService;


@Service
public class OrderinfoServiceimpl implements OrderinfoService {

    @Autowired
    OrderinfoMapper of;

    @Override
    public int deleteByPrimaryKey(String username) {
        return of.deleteByPrimaryKey(username);
    }

    @Override
    public int insert(Orderinfo record) {
        return of.insert(record);
    }

    @Override
    public int insertSelective(Orderinfo record) {
        return of.insertSelective(record);
    }

    @Override
    public Orderinfo selectByPrimaryKey(String username) {
        return of.selectByPrimaryKey(username);
    }


}
