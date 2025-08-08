package hibernate_test.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Details")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column
    private String city;

    @Column
    private String phoneNumber;

    @Column
    private String email;

    @OneToOne(mappedBy = "detail",cascade = CascadeType.ALL) //Связь уже налажена, поищи её в описании поля Employee -> detail
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Detail() {
    }

    public Detail(String email, String phoneNumber, String city) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
    }


    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
