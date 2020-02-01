package xyz.cym2018.DAO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Owner {
    public Owner() {
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
    private String paidForTime;
    // 微信支付
    private Double wechatPay;
    // 现金支付
    private Double moneyPay;
    // 银联支付
    private Double unionPay;
    // 退款姓名
    private String refundName;
    // 退款账号
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
    private Double garbageRate;
    // 水费
    private Double waterRate;
    // col
    private Double col;
    // 备注
    private String note;

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

    @Override
    public String toString() {
        return "Owner{" +
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
                '}';
    }

    public void Add(Owner owner) {
        owner.Clear();
        area += owner.getArea();
        depositToCost += owner.getDepositToCost();
        wechatPay += owner.getWechatPay();
        moneyPay += owner.getMoneyPay();
        unionPay += owner.getUnionPay();
        refundNumber += owner.getRefundNumber();
        breaks += owner.getBreaks();
        paidAt51 += owner.getPaidAt51();
        col += owner.getCol();
    }

    public void Clear() {
        area = area == null ? 0 : area;
        depositToCost = depositToCost == null ? 0 : depositToCost;
        wechatPay = wechatPay == null ? 0 : wechatPay;
        moneyPay = moneyPay == null ? 0 : moneyPay;
        unionPay = unionPay == null ? 0 : unionPay;
        refundNumber = refundNumber == null ? 0 : refundNumber;
        breaks = breaks == null ? 0 : breaks;
        paidAt51 = paidAt51 == null ? 0 : paidAt51;
        col = col == null ? 0 : col;
    }
}
