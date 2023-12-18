package gr.hua.dit.ds.BloodDonorApp.entity;

import jakarta.persistence.*;




@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private Integer age;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String bloodType;

    @Column
    private String area;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bt_id")
    private BloodTest bloodTest;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Application() {
    }

    public Application(Integer id,
                       Integer age,
                       String firstName,
                       String lastName,
                       String bloodType,
                       String area) {
        this.id = id;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bloodType = bloodType;
        this.area = area;
    }

    public BloodTest getBloodTest() {
        return bloodTest;
    }

    public void setBloodTest(BloodTest bloodTest) {
        this.bloodTest = bloodTest;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
