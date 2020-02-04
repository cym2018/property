package xyz.cym2018.DAO;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Recode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // 用户id
    private Integer userId;
    // 标题
    private String title;
    // 交易时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    // 支付方式
    private String paidWay;
    // 金额
    private Double amount;
    // 备注
    private String note;

    public String getNote() {
        return note;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public String getPaidWay() {
        return paidWay;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setPaidWay(String paidWay) {
        this.paidWay = paidWay;
    }
}
