package xyz.cym2018.DAO;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class User {
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
    // 交费至
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date paidForTime;
    // 数值备注1
    private Double numberNote1;
    // 数值备注2
    private Double numberNote2;
    // 文字备注1
    private String textNote1;
    // 文字备注2
    private String textNote2;

    public Integer getId() {
        return id;
    }

    public Integer getUnitNumber() {
        return unitNumber;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }


    public String getName() {
        return name;
    }

    public Double getArea() {
        return area;
    }

    public Double getNumberNote1() {
        return numberNote1;
    }

    public Double getNumberNote2() {
        return numberNote2;
    }

    public String getTextNote1() {
        return textNote1;
    }

    public String getTextNote2() {
        return textNote2;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBuildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setUnitNumber(Integer unitNumber) {
        this.unitNumber = unitNumber;
    }

    public Date getPaidForTime() {
        return paidForTime;
    }

    public void setPaidForTime(Date paidForTime) {
        this.paidForTime = paidForTime;
    }
    public void setPaidForTime(String paidForTime) {
        System.out.println("x.c.D.User.setPaidForTime(String)");
        Long time=Long.parseLong(paidForTime);
        this.paidForTime = new Date(time);
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setArea(Double area) {
        this.area = area;
    }

    public void setNumberNote1(Double numberNote1) {
        this.numberNote1 = numberNote1;
    }

    public void setNumberNote2(Double numberNote2) {
        this.numberNote2 = numberNote2;
    }

    public void setTextNote1(String textNote1) {
        this.textNote1 = textNote1;
    }

    public void setTextNote2(String textNote2) {
        this.textNote2 = textNote2;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", buildingNumber=" + buildingNumber +
                ", unitNumber=" + unitNumber +
                ", roomNumber=" + roomNumber +
                ", area=" + area +
                ", paidForTime=" + paidForTime +
                ", numberNote1=" + numberNote1 +
                ", numberNote2=" + numberNote2 +
                ", textNote1='" + textNote1 + '\'' +
                ", textNote2='" + textNote2 + '\'' +
                '}';
    }
}
