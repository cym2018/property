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
        "depsit", "depositToCost", "refundNumber", "property1", "property2", "property3", "numberNote", "textNote"})
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
    private Double property1;
    private Double property2;
    private Double property3;

    public Double getProperty1() {
        return property1;
    }

    public void setProperty1(Double property1) {
        this.property1 = property1;
    }

    public String getTextNote() {
        return textNote;
    }

    public void setTextNote(String textNote) {
        this.textNote = textNote;
    }

    public Double getNumberNote() {
        return numberNote;
    }

    public void setNumberNote(Double numberNote) {
        this.numberNote = numberNote;
    }

    // 文字备注
    private String textNote;
    // 数字备注
    private Double numberNote;

    public Integer getId() {
        return id;
    }

    public Double getArea() {
        return area;
    }

    public Double getDepositToCost() {
        return depositToCost;
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


    public void setDepsit(String depsit) {
        if (!"".equals(depsit))
            this.depsit = depsit;
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
        refundNumber = 0.0;
        breaks = 0.0;
        paidAt51 = 0.0;
        numberNote = 0.0;
        property1 = 0.0;
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
                ", refundName='" + refundName + '\'' +
                ", refundAccount='" + refundAccount + '\'' +
                ", refundNumber=" + refundNumber +
                ", breaks=" + breaks +
                ", paidAt51=" + paidAt51 +
                ", depsit='" + depsit + '\'' +
                ", garbageRate=" + garbageRate +
                ", waterRate=" + waterRate +
                ", property1=" + property1 +
                ", property2=" + property2 +
                ", property3=" + property3 +
                ", textNote='" + textNote + '\'' +
                ", numberNote=" + numberNote +
                '}';
    }

    public void Add(Table1 table1) {
        area = Add(area, table1.area);
        depositToCost = Add(depositToCost, table1.depositToCost);
        refundNumber = Add(refundNumber, table1.refundNumber);
        breaks = Add(breaks, table1.breaks);
        paidAt51 = Add(paidAt51, table1.paidAt51);
        property1 = Add(property1, table1.property1);
        property2 = Add(property2, table1.property2);
        property3 = Add(property3, table1.property3);
        numberNote = Add(numberNote, table1.numberNote);
    }

    public double Add(Double a, Double b) {
        if (b != null) {
            return new BigDecimal(a.toString()).add(new BigDecimal(b.toString())).doubleValue();
        }
        return a;
    }
}
