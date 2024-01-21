package gr.hua.dit.ds.BloodDonorApp.entity;

import jakarta.persistence.*;

@Entity
public class BloodTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private Integer height;

    @Column
    private Integer weight;

    @Column
    private Integer rhesusFactor;

    @Column
    private Integer bloodPressure;

    @Column
    private Integer whiteBloodCellCount;

    @Column
    private Integer redBloodCellCount;

    @Column
    private String dateOfTest;

    @Column
    private String hospitalName;

    public BloodTest() {
    }

    public BloodTest(
                     Integer height,
                     Integer weight,
                     Integer rhesusFactor,
                     Integer bloodPressure,
                     Integer whiteBloodCellCount,
                     Integer redBloodCellCount,
                     String dateOfTest,
                     String hospitalName) {
        this.height = height;
        this.weight = weight;
        this.rhesusFactor = rhesusFactor;
        this.bloodPressure = bloodPressure;
        this.whiteBloodCellCount = whiteBloodCellCount;
        this.redBloodCellCount = redBloodCellCount;
        this.dateOfTest = dateOfTest;
        this.hospitalName = hospitalName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getRhesusFactor() {
        return rhesusFactor;
    }

    public void setRhesusFactor(Integer rhesusFactor) {
        this.rhesusFactor = rhesusFactor;
    }

    public Integer getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(Integer bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public Integer getWhiteBloodCellCount() {
        return whiteBloodCellCount;
    }

    public void setWhiteBloodCellCount(Integer whiteBloodCellCount) {
        this.whiteBloodCellCount = whiteBloodCellCount;
    }

    public Integer getRedBloodCellCount() {
        return redBloodCellCount;
    }

    public void setRedBloodCellCount(Integer redBloodCellCount) {
        this.redBloodCellCount = redBloodCellCount;
    }

    public String getDateOfTest() {
        return dateOfTest;
    }

    public void setDateOfTest(String dateOfTest) {
        this.dateOfTest = dateOfTest;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    @Override
    public String toString() {
        return "BloodTest{" +
                "id=" + id +
                ", height=" + height +
                ", weight=" + weight +
                ", rhesusFactor=" + rhesusFactor +
                ", bloodPressure=" + bloodPressure +
                ", whiteBloodCellCount=" + whiteBloodCellCount +
                ", redBloodCellCount=" + redBloodCellCount +
                ", dateOfTest='" + dateOfTest + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                '}';
    }




}
