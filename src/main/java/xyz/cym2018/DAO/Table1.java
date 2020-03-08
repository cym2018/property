package xyz.cym2018.DAO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;

@JsonPropertyOrder({"name", "buildingNumber", "unitNumber", "roomNumber", "area", "paidForTime", "breaks", "paidAt51",
        "depsit", "depositToCost", "refundNumber", "property1", "property2", "property3", "numberNote", "textNote"})
@Entity
//商基鑫城
public class Table1 {
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
    private Date paidForTime;
    // 退款金额
    private Double refundNumber;
    // 减免
    private Double breaks;
    // 5.1号缴费
    private Double paidAt51;
    // 押金
    private String depsit;
    private Double property1;
    private Double property2;
    private Double property3;
    // 数字备注
    private Double numberNote;
    // 文字备注
    private String textNote;
    // 样式
    private String style;

    public Table1() {
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getPaidForTime() {
        return paidForTime;
    }

    public void setPaidForTime(Date paidForTime) {
        this.paidForTime = paidForTime;
    }

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getDepositToCost() {
        return depositToCost;
    }

    public void setDepositToCost(Double depositToCost) {
        this.depositToCost = depositToCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!"".equals(name))
            this.name = name;
    }

    public Double getRefundNumber() {
        return refundNumber;
    }

    public void setRefundNumber(Double refundNumber) {
        this.refundNumber = refundNumber;
    }

    public Double getBreaks() {
        return breaks;
    }

    public void setBreaks(Double breaks) {
        this.breaks = breaks;
    }

    public Double getPaidAt51() {
        return paidAt51;
    }

    public void setPaidAt51(Double paidAt51) {
        this.paidAt51 = paidAt51;
    }

    public String getDepsit() {
        return depsit;
    }

    public void setDepsit(String depsit) {
        if (!"".equals(depsit))
            this.depsit = depsit;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public Double getProperty2() {
        return property2;
    }

    public void setProperty2(Double property2) {
        this.property2 = property2;
    }

    public Double getProperty3() {
        return property3;
    }

    public void setProperty3(Double property3) {
        this.property3 = property3;
    }


    // 清空数据
    public void Clear() {
        buildingNumber = 0;
        unitNumber = 0;
        roomNumber = 0;
        area = 0.0;
        depsit = "0";
        textNote = "0";
        depositToCost = 0.0;
        refundNumber = 0.0;
        breaks = 0.0;
        paidAt51 = 0.0;
        numberNote = 0.0;
        property1 = 0.0;
        property2 = 0.0;
        property3 = 0.0;
    }

    public double Statistics(Double a, Double b) {
        if (b != null) {
            return new BigDecimal(a.toString()).add(new BigDecimal(b.toString())).doubleValue();
        }
        return a;
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
                ", paidForTime=" + paidForTime +
                ", refundNumber=" + refundNumber +
                ", breaks=" + breaks +
                ", paidAt51=" + paidAt51 +
                ", depsit='" + depsit + '\'' +
                ", property1=" + property1 +
                ", property2=" + property2 +
                ", property3=" + property3 +
                ", numberNote=" + numberNote +
                ", textNote='" + textNote + '\'' +
                '}';
    }

    public void Statistics(Table1 table1) {
        area = Statistics(area, table1.area);
        depositToCost = Statistics(depositToCost, table1.depositToCost);
        refundNumber = Statistics(refundNumber, table1.refundNumber);
        breaks = Statistics(breaks, table1.breaks);
        paidAt51 = Statistics(paidAt51, table1.paidAt51);
        property1 = Statistics(property1, table1.property1);
        property2 = Statistics(property2, table1.property2);
        property3 = Statistics(property3, table1.property3);
        numberNote = Statistics(numberNote, table1.numberNote);
    }

    public void Counts(Table1 table1) {
        if (table1.getBreaks() != null) breaks++;
        if (table1.getPaidAt51() != null) paidAt51++;
        if (table1.getDepsit() != null) depsit = String.valueOf((Integer.parseInt(depsit) + 1));
        if (table1.getDepositToCost() != null) depositToCost++;
        if (table1.getRefundNumber() != null) refundNumber++;
        if (table1.getProperty1() != null) property1++;
        if (table1.getProperty2() != null) property2++;
        if (table1.getProperty3() != null) property3++;
        if (table1.getNumberNote() != null) numberNote++;
        if (table1.getTextNote() != null) textNote = String.valueOf((Integer.parseInt(textNote) + 1));

    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
