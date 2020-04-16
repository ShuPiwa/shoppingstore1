package controller;

import entity.Admininfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import serviceImp.AdmininfoServiceimpl;

@RestController
public class AdmininfoController {

    @Autowired
    AdmininfoServiceimpl asi;


    @RequestMapping("/adlogin")
    public Boolean adlogin(@RequestParam String username,@RequestParam String password){
        Admininfo ad = asi.selectByUsername(username);
        String md5Pwd= DigestUtils.md5Hex(password.getBytes());
        Boolean flag;
        if(ad!=null&&md5Pwd.equals(ad.getAdPassword())){
           flag = true;
        }else {
           flag = false;
        }

        return flag;
    }


}
