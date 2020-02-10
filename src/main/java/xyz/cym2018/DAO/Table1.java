package xyz.cym2018.DAO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@JsonPropertyOrder({"name", "buildingNumber", "unitNumber", "roomNumber", "area", "paidForTime", "breaks", "paidAt51",
        "depsit", "depositToCost", "wechatPay", "moneyPay", "unionPay", "refundNumber", "property2", "property3", "col", "note"})
@Entity
//商基鑫城
public class Table1 {
    public Table1() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // 业主姓名
    private String name;
    // 楼号
    private Integer buildingNumber;
    // 单元号
    private Integer unitNumber;
    // 房间号
    private Integer roomNumber;
    // 面积
    private Double area;
    // 押金抵费
    private Double depositToCost;
    // 交费至
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String paidForTime;
    // 微信支付
    private Double wechatPay;
    // 现金支付
    private Double moneyPay;
    // 银联支付
    private Double unionPay;
    // 退款姓名
    @JsonIgnore
    private String refundName;
    // 退款账号
    @JsonIgnore
    private String refundAccount;
    // 退款金额
    private Double refundNumber;
    // 减免
    private Double breaks;
    // 5.1号缴费
    private Double paidAt51;
    // 押金
    private String depsit;
    // 垃圾
    @JsonIgnore
    private Double garbageRate;
    // 水费
    @JsonIgnore
    private Double waterRate;
    // col
    private Double col;
    // 备注
    private String note;
    // 物业费2
    private Double property2;
    // 物业费3
    private Double property3;

    public Integer getId() {
        return id;
    }

    public Double getArea() {
        return area;
    }

    public Double getDepositToCost() {
        return depositToCost;
    }

    public Double getMoneyPay() {
        return moneyPay;
    }

    public Double getWechatPay() {
        return wechatPay;
    }

    public Double getUnionPay() {
        return unionPay;
    }

    public String getName() {
        return name;
    }

    public String getPaidForTime() {
        return paidForTime;
    }

    public Double getRefundNumber() {
        return refundNumber;
    }

    public String getRefundName() {
        return refundName;
    }

    public String getRefundAccount() {
        return refundAccount;
    }

    public Double getBreaks() {
        return breaks;
    }

    public Double getCol() {
        return col;
    }

    public Double getGarbageRate() {
        return garbageRate;
    }

    public Double getPaidAt51() {
        return paidAt51;
    }

    public Double getWaterRate() {
        return waterRate;
    }

    public String getDepsit() {
        return depsit;
    }

    public String getNote() {
        return note;
    }

    public void setGarbageRate(Double garbageRate) {
        this.garbageRate = garbageRate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public void setBreaks(Double breaks) {
        this.breaks = breaks;
    }

    public void setDepositToCost(Double depositToCost) {
        this.depositToCost = depositToCost;
    }

    public void setMoneyPay(Double moneyPay) {
        this.moneyPay = moneyPay;
    }

    public void setName(String name) {
        if (!"".equals(name))
            this.name = name;
    }

    public void setPaidForTime(String paidForTime) {
        if (!"".equals(paidForTime))
            this.paidForTime = paidForTime;
    }

    public void setRefundAccount(String refundAccount) {
        if (!"".equals(refundAccount))
            this.refundAccount = refundAccount;
    }

    public void setRefundName(String refundName) {
        if (!"".equals(refundName))
            this.refundName = refundName;
    }

    public void setRefundNumber(Double refundNumber) {
        this.refundNumber = refundNumber;
    }

    public void setUnionPay(Double unionPay) {
        this.unionPay = unionPay;
    }

    public void setWechatPay(Double wechatPay) {
        this.wechatPay = wechatPay;
    }

    public void setCol(Double col) {
        this.col = col;
    }

    public void setDepsit(String depsit) {
        if (!"".equals(depsit))
            this.depsit = depsit;
    }

    public void setNote(String note) {
        if (!"".equals(note))
            this.note = note;
    }

    public void setPaidAt51(Double paidAt51) {
        this.paidAt51 = paidAt51;
    }

    public void setWaterRate(Double waterRate) {
        this.waterRate = waterRate;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setBuildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public Double getProperty2() {
        return property2;
    }

    public Double getProperty3() {
        return property3;
    }

    public void setProperty2(Double property2) {
        this.property2 = property2;
    }

    public void setProperty3(Double property3) {
        this.property3 = property3;
    }


    // 清空数据
    public void Clear() {
        area = 0.0;
        depositToCost = 0.0;
        wechatPay = 0.0;
        moneyPay = 0.0;
        unionPay = 0.0;
        refundNumber = 0.0;
        breaks = 0.0;
        paidAt51 = 0.0;
        col = 0.0;
        property2 = 0.0;
        property3 = 0.0;
    }

    @Override
    public String toString() {
        return "Table1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", buildingNumber=" + buildingNumber +
                ", unitNumber=" + unitNumber +
                ", roomNumber=" + roomNumber +
                ", area=" + area +
                ", depositToCost=" + depositToCost +
                ", paidForTime='" + paidForTime + '\'' +
                ", wechatPay=" + wechatPay +
                ", moneyPay=" + moneyPay +
                ", unionPay=" + unionPay +
                ", refundName='" + refundName + '\'' +
                ", refundAccount='" + refundAccount + '\'' +
                ", refundNumber=" + refundNumber +
                ", breaks=" + breaks +
                ", paidAt51=" + paidAt51 +
                ", depsit='" + depsit + '\'' +
                ", garbageRate=" + garbageRate +
                ", waterRate=" + waterRate +
                ", col=" + col +
                ", note='" + note + '\'' +
                ", property2=" + property2 +
                ", property3=" + property3 +
                '}';
    }

    public void Add(Table1 table1) {
        area = Add(area, table1.area);
        depositToCost = Add(depositToCost, table1.depositToCost);
        wechatPay = Add(wechatPay, table1.wechatPay);
        moneyPay = Add(moneyPay, table1.moneyPay);
        unionPay = Add(unionPay, table1.unionPay);
        refundNumber = Add(refundNumber, table1.refundNumber);
        breaks = Add(breaks, table1.breaks);
        paidAt51 = Add(paidAt51, table1.paidAt51);
        col = Add(col, table1.col);
        property2 = Add(property2, table1.property2);
        property3 = Add(property3, table1.property3);
    }

    public double Add(Double a, Double b) {
        if (b != null) {
            return new BigDecimal(a.toString()).add(new BigDecimal(b.toString())).doubleValue();
        }
        return a;
    }
}
