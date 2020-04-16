package serviceImp;

import entity.Admininfo;
import mapper.AdmininfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AdminminfoService;


@Service
public class AdmininfoServiceimpl implements AdminminfoService {


    @Autowired
    AdmininfoMapper af;
    @Override
    public int deleteByPrimaryKey(Integer adId) {
        return af.deleteByPrimaryKey(adId);
    }

    @Override
    public int insert(Admininfo record) {
        return af.insert(record);
    }

    @Override
    public int insertSelective(Admininfo record) {
        return af.insertSelective(record);
    }

    @Override
    public Admininfo selectByPrimaryKey(Integer adId) {
        return af.selectByPrimaryKey(adId);
    }

    @Override
    public int updateByPrimaryKeySelective(Admininfo record) {
        return af.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Admininfo record) {
        return af.updateByPrimaryKey(record);
    }

    @Override
    public Admininfo selectByUsername(String username) {
        return af.selectByUsername(username);
    }
}
