package controller;

import entity.Productinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import serviceImp.ProductinfoServiceimpl;
import sun.awt.SunHints;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@RestController
public class UpLoadProductsController {

    @Autowired
    ProductinfoServiceimpl pfs;

    @RequestMapping("/addProducts")
    public String addProducts(@RequestParam Integer p_code, @RequestParam String p_name, @RequestParam String p_type,
                              @RequestParam String brand, @RequestParam Integer p_num, @RequestParam Double price,
                              @RequestParam String intro, @RequestParam(value="pic")MultipartFile multipartFile, HttpServletRequest req) throws IOException {

      String originalFilename = multipartFile.getOriginalFilename();//获取文件原始名称
        System.out.println("========="+originalFilename);

        long l = System.currentTimeMillis();//获取当前毫秒值
        String newName = l+originalFilename;
        System.out.println("====="+newName);

        String lastName = "/image/"+newName;
        String realPath = req.getSession().getServletContext().getRealPath("/");//获取当前项目名
        InputStream is = multipartFile.getInputStream();

        //在项目根目录下创建image文件夹,用来保存上传的图片
        File file = new File(realPath+"\\image\\"+newName);
        if(!file.exists()){
            file.getParentFile().mkdir();
            file.createNewFile();
        }

        if(!multipartFile.isEmpty()){
            InputStream bfs = new BufferedInputStream(is);
            OutputStream os = new BufferedOutputStream(new FileOutputStream(file));


            int str = 0;
            while((str=bfs.read())!=-1){
                os.write(str);
            }
            os.flush();
            bfs.close();
            os.close();
        }

        Productinfo pf = new Productinfo();
        pf.setpCode(p_code);
        pf.setpName(p_name);
        pf.setpType(p_type);
        pf.setBrand(brand);
        pf.setPic(lastName);
        pf.setpNum(p_num);
        pf.setPrice(price);
        pf.setIntro(intro);

        int insert = pfs.insert(pf);
        if(insert>=1){
            return "ok";
        }else {
            return "no";
        }


    }
}
