package com.peak.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Table(name="restaurants")
@Entity
public class Restaurant {

    @Id
    @Column(name="CAMIS")
    private Integer camis;
    @Column(name="DBA")
    private String name;
    @Column(name="BORO")
    private String boro;
    @Column(name="BUILDING")
    private String building;
    @Column(name="STREET")
    private String street;
    @Column(name="ZIPCODE")
    private String zipCode;
    @Column(name="PHONE")
    private String phone;
    @Column(name="CUISINE_DESCRIPTION")
    private String cuisine;
    @Column(name="INSPECTION_DATE")
    private Date inspectionDate;
    @Column(name="VIOLATION_CODE")
    private String violationCode;
    @Column(name="VIOLATION_DESCRIPTION")
    private String violationDescription;
    @Column(name="CRITICAL_FLAG")
    private String criticalFlag;
    @Column(name="SCORE")
    private Integer score;
    @Column(name="GRADE")
    private String grade;
    @Column(name="GRADE_DATE")
    private Date gradeDate;
    @Column(name="RECORD_DATE")
    private Date recordDate;
    @Column(name="INSPECTION_TYPE")
    private String inspectionType;
    @Column(name="Latitude")
    private Double latitude;
    @Column(name="Longitude")
    private Double longitude;
    @Column(name="Community_Board")
    private Integer communityBoard;
    @Column(name="Council_District")
    private Integer councilDistrict;
    @Column(name="Census_Tract")
    private Integer censusTract;
    @Column(name="BIN")
    private Integer bin;
    @Column(name="BBL")
    private Integer bbl;
    @Column(name="NTA")
    private String nta;

    public Restaurant() {
    }

    public Restaurant(Integer camis, String name, String boro, String building, String street, String zipCode, String phone, String cuisine, String violationCode, String criticalFlag, Integer score, String grade) {
        this.camis = camis;
        this.name = name;
        this.boro = boro;
        this.building = building;
        this.street = street;
        this.zipCode = zipCode;
        this.phone = phone;
        this.cuisine = cuisine;
        this.violationCode = violationCode;
        this.criticalFlag = criticalFlag;
        this.score = score;
        this.grade = grade;
    }

    public Integer getCamis() {
        return camis;
    }

    public void setCamis(Integer camis) {
        this.camis = camis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBoro() {
        return boro;
    }

    public void setBoro(String boro) {
        this.boro = boro;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public Date getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(Date inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getViolationCode() {
        return violationCode;
    }

    public void setViolationCode(String violationCode) {
        this.violationCode = violationCode;
    }

    public String getViolationDescription() {
        return violationDescription;
    }

    public void setViolationDescription(String violationDescription) {
        this.violationDescription = violationDescription;
    }

    public String getCriticalFlag() {
        return criticalFlag;
    }

    public void setCriticalFlag(String criticalFlag) {
        this.criticalFlag = criticalFlag;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Date getGradeDate() {
        return gradeDate;
    }

    public void setGradeDate(Date gradeDate) {
        this.gradeDate = gradeDate;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getInspectionType() {
        return inspectionType;
    }

    public void setInspectionType(String inspectionType) {
        this.inspectionType = inspectionType;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getCommunityBoard() {
        return communityBoard;
    }

    public void setCommunityBoard(Integer communityBoard) {
        this.communityBoard = communityBoard;
    }

    public Integer getCouncilDistrict() {
        return councilDistrict;
    }

    public void setCouncilDistrict(Integer councilDistrict) {
        this.councilDistrict = councilDistrict;
    }

    public Integer getCensusTract() {
        return censusTract;
    }

    public void setCensusTract(Integer censusTract) {
        this.censusTract = censusTract;
    }

    public Integer getBin() {
        return bin;
    }

    public void setBin(Integer bin) {
        this.bin = bin;
    }

    public Integer getBbl() {
        return bbl;
    }

    public void setBbl(Integer bbl) {
        this.bbl = bbl;
    }

    public String getNta() {
        return nta;
    }

    public void setNta(String nta) {
        this.nta = nta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(boro, that.boro) &&
                Objects.equals(zipCode, that.zipCode) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(cuisine, that.cuisine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, boro, zipCode, phone, cuisine);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", boro='" + boro + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phone='" + phone + '\'' +
                ", cuisine='" + cuisine + '\'' +
                '}';
    }
}
