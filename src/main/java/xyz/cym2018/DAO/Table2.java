package xyz.cym2018.DAO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
// 彩虹小区
public class Table2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // 姓名
    private String name;
    // 楼号
    private Integer buildingNumber;
    // 单元号
    private Integer unitNumber;
    // 房间号
    private Integer roomNumber;
    // 面积
    private Double area;
    // 退款日期
    private Date refundDate;
    // 退款姓名
    private String refundName;
    // 退款金额
    private Double refundNumber;
    // 押金状态
    private String depositState;
    // 垃圾清运费
    private Double garbage;
    // 物业费1
    private Double property1;
    // 交费至
    private String paidForTime;
    // 物业费2
    private Double property2;
    // 物业费3
    private Double property3;
    // 交费方式2
    private String paidBy2;
    // 交费方式3
    private String paidBy3;
    // 数字备注
    private Double numberNote;
    // 文字备注
    private String textNumber;

    @Override
    public String toString() {
        return "Table2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", buildingNumber=" + buildingNumber +
                ", unitNumber=" + unitNumber +
                ", roomNumber=" + roomNumber +
                ", area=" + area +
                ", refundDate=" + refundDate +
                ", refundName='" + refundName + '\'' +
                ", refundNumber=" + refundNumber +
                ", depositState='" + depositState + '\'' +
                ", garbage=" + garbage +
                ", property1=" + property1 +
                ", paidForTime='" + paidForTime + '\'' +
                ", property2=" + property2 +
                ", property3=" + property3 +
                ", paidBy2='" + paidBy2 + '\'' +
                ", paidBy3='" + paidBy3 + '\'' +
                ", numberNote=" + numberNote +
                ", textNumber='" + textNumber + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Date getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(Date refundDate) {
        this.refundDate = refundDate;
    }

    public String getRefundName() {
        return refundName;
    }

    public void setRefundName(String refundName) {
        this.refundName = refundName;
    }

    public Double getRefundNumber() {
        return refundNumber;
    }

    public void setRefundNumber(Double refundNumber) {
        this.refundNumber = refundNumber;
    }

    public String getDepositState() {
        return depositState;
    }

    public void setDepositState(String depositState) {
        this.depositState = depositState;
    }

    public Double getGarbage() {
        return garbage;
    }

    public void setGarbage(Double garbage) {
        this.garbage = garbage;
    }

    public Double getProperty1() {
        return property1;
    }

    public void setProperty1(Double property1) {
        this.property1 = property1;
    }

    public String getPaidForTime() {
        return paidForTime;
    }

    public void setPaidForTime(String paidForTime) {
        this.paidForTime = paidForTime;
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

    public String getPaidBy2() {
        return paidBy2;
    }

    public void setPaidBy2(String paidBy2) {
        this.paidBy2 = paidBy2;
    }

    public String getPaidBy3() {
        return paidBy3;
    }

    public void setPaidBy3(String paidBy3) {
        this.paidBy3 = paidBy3;
    }

    public Double getNumberNote() {
        return numberNote;
    }

    public void setNumberNote(Double numberNote) {
        this.numberNote = numberNote;
    }

    public String getTextNumber() {
        return textNumber;
    }

    public void setTextNumber(String textNumber) {
        this.textNumber = textNumber;
    }

    public void Clear() {
        area = 0.0;
        refundNumber = 0.0;
        garbage = 0.0;
        property1 = 0.0;
        property2 = 0.0;
        property3 = 0.0;
        numberNote = 0.0;
    }

    public void Add(Table2 table2) {
        area += table2.area;
        refundNumber += table2.refundNumber;
        garbage += table2.garbage;
        property1 += table2.property1;
        property2 += table2.property2;
        property3 += table2.property3;
        numberNote += table2.numberNote;

    }
}
