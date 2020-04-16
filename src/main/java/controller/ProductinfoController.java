package controller;


import entity.Productinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import serviceImp.ProductinfoServiceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductinfoController {

    @Autowired
    ProductinfoServiceimpl pfs;

    @RequestMapping("selectType")
    public List<Productinfo> selectType(){
        return pfs.selectType();
    }

    @RequestMapping("getProductByPtype")
    public List<Productinfo> getProductByPtype(@RequestParam String pType){
        List<Productinfo> productsByPtype = pfs.getProductsByPtype(pType);
        System.out.println(productsByPtype.get(3).getPic()+"******************");

        return productsByPtype;
    }

    @RequestMapping("/getMy")
    public Map<String,List<Productinfo>> getProduct(){
        Map<String,List<Productinfo>> map = new HashMap<>();
        List<Productinfo> pf = pfs.selectType();
        for(int i = 0; i<pf.size();i++){
            List<Productinfo> list = new ArrayList<>();
           list =  pfs.getProductsByPtype(pf.get(i).getpType());
           map.put(pf.get(i).getpType(),list);
        }

        return map;
    }

}
