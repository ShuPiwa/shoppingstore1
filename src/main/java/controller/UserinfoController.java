package controller;

import entity.Userinfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import serviceImp.UserinfoServiceimpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
public class UserinfoController {

    @Autowired
    UserinfoServiceimpl uis;

    @RequestMapping("/register")
    public int insert(@RequestParam String username,@RequestParam String password,@RequestParam String email){
        Userinfo userinfo = uis.selectName(username);
        if(userinfo==null){
        Userinfo ui = new Userinfo();
        ui.setUsername(username);
        //将密码加密
        String md5Pwd= DigestUtils.md5Hex(password.getBytes());
        ui.setPassword(md5Pwd);
        ui.setEmail(email);
        Date date = new Date();
        //时间类转换
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(date);
        ui.setRegisterTime(format);
        return uis.insert(ui);
        }else {
            return -1;
        }

    }

    @RequestMapping("/login")
    public Boolean selectByName(@RequestParam String username, @RequestParam String password,
                                @RequestParam String fla, HttpServletResponse resp) throws UnsupportedEncodingException {
        System.out.println("**************"+fla);
        String md5Pwd=DigestUtils.md5Hex(password.getBytes());
        Userinfo userinfo = uis.selectByName(username,md5Pwd);
            Boolean flag ;
            if(userinfo!=null&&md5Pwd.equals(userinfo.getPassword())){
                if(fla.equals("yes")){
                    System.out.println(username);
                    Cookie cookie = new Cookie("flag","true");
                    cookie.setMaxAge(1000);
                    resp.addCookie(cookie);

                    Cookie cookie1 = new Cookie("username",username);
                    cookie1.setMaxAge(1000);
                    resp.addCookie(cookie1);

                    Cookie cookie2 = new Cookie("password",password);
                    cookie2.setMaxAge(1000);
                    resp.addCookie(cookie2);

                }else {
                    Cookie cookie=new Cookie("flag","false");
                    cookie.setMaxAge(10000);
                    resp.addCookie(cookie);

                    Cookie cookie1 = new Cookie("username",username);
                    cookie1.setMaxAge(1000);
                    resp.addCookie(cookie1);
                }
                flag = true;
            }else {
                flag = false;
            }
     return flag;
    }

}
