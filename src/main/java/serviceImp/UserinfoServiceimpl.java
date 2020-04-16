package serviceImp;

import entity.Userinfo;
import mapper.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserinfoService;

import java.util.List;

@Service
public class UserinfoServiceimpl implements UserinfoService {

    @Autowired
    UserinfoMapper uim;

    @Override
    public int deleteByPrimaryKey(Integer uId) {
        return uim.deleteByPrimaryKey(uId);
    }

    @Override
    public int insert(Userinfo record) {
        return uim.insert(record);
    }

    @Override
    public int insertSelective(Userinfo record) {
        return uim.insertSelective(record);
    }

    @Override
    public Userinfo selectByPrimaryKey(Integer uId) {
        return uim.selectByPrimaryKey(uId);
    }

    @Override
    public int updateByPrimaryKeySelective(Userinfo record) {
        return uim.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Userinfo record) {
        return uim.updateByPrimaryKey(record);
    }

    @Override
    public List<Userinfo> selectAll() {
        return uim.selectAll();
    }

    @Override
    public Userinfo selectByName(String username, String password) {
        return uim.selectByName(username,password);
    }

    @Override
    public Userinfo selectName(String name) {
        return uim.selectName(name);
    }

}
