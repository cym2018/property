//package xyz.cym2018.DAO;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import java.sql.Date;
//
//@Entity
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    public User() {
//    }
//
//    // 小区
//    private String community;
//
//    public String getCommunity() {
//        return community;
//    }
//
//    public void setCommunity(String community) {
//        this.community = community;
//    }
//
//    // 姓名
//    private String name;
//    // 楼号
//    private Integer buildingNumber;
//    // 单元号
//    private Integer unitNumber;
//    // 房间号
//    private Integer roomNumber;
//    // 面积
//    private Double area;
//    // 交费至
//    private Date paidForTime;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getBuildingNumber() {
//        return buildingNumber;
//    }
//
//    public void setBuildingNumber(Integer buildingNumber) {
//        this.buildingNumber = buildingNumber;
//    }
//
//    public Integer getUnitNumber() {
//        return unitNumber;
//    }
//
//    public void setUnitNumber(Integer unitNumber) {
//        this.unitNumber = unitNumber;
//    }
//
//    public Integer getRoomNumber() {
//        return roomNumber;
//    }
//
//    public void setRoomNumber(Integer roomNumber) {
//        this.roomNumber = roomNumber;
//    }
//
//    public Double getArea() {
//        return area;
//    }
//
//    public void setArea(Double area) {
//        this.area = area;
//    }
//
//    public Date getPaidForTime() {
//        return paidForTime;
//    }
//
//    public void setPaidForTime(Date paidForTime) {
//        this.paidForTime = paidForTime;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", buildingNumber=" + buildingNumber +
//                ", unitNumber=" + unitNumber +
//                ", roomNumber=" + roomNumber +
//                ", area=" + area +
//                ", paidForTime=" + paidForTime +
//                '}';
//    }
//}
