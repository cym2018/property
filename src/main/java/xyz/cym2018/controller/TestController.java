package xyz.cym2018.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cym2018.DAO.Table1;

import java.util.List;

@RestController
public class TestController extends template {
    @RequestMapping("/count")
    public String Count() {
        System.out.println("押金抵费非空行数:" + table1Repository.countAllByDepositToCostIsNotNull());
        System.out.println("交费至非空行数:" + table1Repository.countAllByPaidForTimeIsNotNull());
        System.out.println("微信支付非空行数:" + table1Repository.countAllByWechatPayIsNotNull());
        System.out.println("现金支付非空行数:" + table1Repository.countAllByMoneyPayIsNotNull());
        System.out.println("银联支付非空行数:" + table1Repository.countAllByUnionPayIsNotNull());
        System.out.println("退款金额非空行数:" + table1Repository.countAllByrefundNumberIsNotNull());
        System.out.println("减免非空行数:" + table1Repository.countAllBybreaksIsNotNull());
        return table1Repository.countAllBybreaksIsNotNull().toString();
    }

    @RequestMapping("/Table1Do")
    public String Table1Do() {
        System.out.println("执行合并数据行曹祖");
        List<Table1> data = table1Repository.findAll();
        Double sum;
        for (Table1 i : data) {
            sum = 0.0;
            if (i.getWechatPay() != null)
                sum += i.getWechatPay();
            if (i.getMoneyPay() != null)
                sum += i.getMoneyPay();
            if (i.getUnionPay() != null)
                sum += i.getUnionPay();
            i.setWechatPay(sum==0.0?null:sum);
            i.setMoneyPay(null);
            i.setUnionPay(null);
            table1Repository.save(i);
        }
        return "操作完毕";
    }
}
