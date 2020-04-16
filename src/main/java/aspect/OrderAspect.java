package aspect;


import entity.Orderdetail;
import entity.Orderinfo;
import entity.Productinfo;
import entity.Userinfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.beans.factory.annotation.Autowired;
import serviceImp.OrderinfoServiceimpl;
import serviceImp.OrdertdetailServiceimlp;
import serviceImp.ProductinfoServiceimpl;
import serviceImp.UserinfoServiceimpl;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderAspect {


    @Autowired
    UserinfoServiceimpl usi;

    @Autowired
    OrderinfoServiceimpl osi;

    @Autowired
    OrdertdetailServiceimlp odi;

    @Autowired
    ProductinfoServiceimpl pfs;

    /** 前置通知
     **/
    public void beforeCheck(JoinPoint joinPoint) {
//        Signature sig=joinPoint.getSignature();
//        System.out.println("before at "+sig.getName()+"and arg[0] is ");

    }

     /**后置通知
     *无法获取返回值 。可以通过返回通知获取返回值
     *且后置通知无论方法是不是异常都会执行
     **/

    public void afterCheck(JoinPoint joinPoint) {
//        Signature sig=joinPoint.getSignature();
//joinPoint.getArgs()[0]
//        System.out.println("After at "+sig.getName()+"and arg[0] is ");

    }

     /** 返回通知
     **/

    public void afterReturn(JoinPoint joinPoint,Object res) {

        if(res.toString().equals("yes")){
            System.out.println("ssssssssssssssssssss");

            System.out.println("**********"+joinPoint.getArgs()[0]);
            System.out.println("*********"+joinPoint.getArgs()[1]);
            System.out.println("***********"+joinPoint.getArgs()[2]);


            Orderinfo oi = osi.selectByPrimaryKey((String) joinPoint.getArgs()[0]);

            if (oi==null) {
                oi = new Orderinfo();
                oi.setUsername(((String) joinPoint.getArgs()[0]));
                osi.insert(oi);


                Orderdetail od = new Orderdetail();
                System.out.println(usi.selectName((String) joinPoint.getArgs()[0]).getuId()+"******************");
                od.setUsername((String) joinPoint.getArgs()[0]);
                od.setpId((Integer) joinPoint.getArgs()[1]);
                od.setOrderbh(System.currentTimeMillis()+(String) joinPoint.getArgs()[0]);
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                od.setOrdertime(sdf.format(date));
                Productinfo p = pfs.selectByPrimaryKey((Integer) joinPoint.getArgs()[1]);
                od.setpName(p.getpName());
                od.setpPrice(p.getPrice());
                od.setOdNum((Integer) joinPoint.getArgs()[2]);
                odi.insert(od);

            }else {
                Orderdetail od = new Orderdetail();
                System.out.println(usi.selectName((String) joinPoint.getArgs()[0]).getuId()+"******************");
                od.setUsername((String) joinPoint.getArgs()[0]);
                od.setpId((Integer) joinPoint.getArgs()[1]);
                od.setOrderbh(System.currentTimeMillis()+(String) joinPoint.getArgs()[0]);
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                od.setOrdertime(sdf.format(date));
                Productinfo p = pfs.selectByPrimaryKey((Integer) joinPoint.getArgs()[1]);
                od.setpName(p.getpName());
                od.setpPrice(p.getPrice());
                od.setOdNum((Integer) joinPoint.getArgs()[2]);
                odi.insert(od);
            }


        }


        Signature sig=joinPoint.getSignature();
        System.out.println("After at "+sig.getName()+"return. res= "+res);
        }






     /** 异常通知
     * 注意如果这个方法的参数：假设异常类型为数学除零的异常
     * afterThrow(JoinPoint joinPoint,空指针异常类 ex) 然后我这里写了空指针异常
     * 那afterThrow这个方法就执行不了 因为类型不对
     **/

    public void afterThrow(JoinPoint joinPoint,Exception ex) {

        Signature sig=joinPoint.getSignature();
        System.out.println("After at "+sig.getName()+"Throw. message= ");
        System.out.println(ex.getMessage());
    }

    /* * 环绕通知
     * 环绕通知就等于整个代理过程交给你自己处理  连被代理对象的要执行的目标方法要不要执行也取决你
     * 上面几个通知比较像 处理目标方法调用的某个时刻的 处理过程
     **/

    public Object aroundMethod(ProceedingJoinPoint point){

        Object result = null;
        String methodName = point.getSignature().getName();
        try {
            //前置通知
            System.out.println("我是前置通知,即将调用"+ methodName);
            //执行目标方法
            result = point.proceed();
            //后置通知
            System.out.println("我是后置通知");
        } catch (Throwable e) {
            //异常通知
            System.out.println("我是异常通知,异常信息是"+e);
            throw new RuntimeException(e);
        }
        //返回通知
        System.out.println("我是返回通知,方法返回值是"+result);
        return result;
    }
}
