package ktp.sb.learn_spring.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "m_user",schema ="public")
public class UserEntity {

    @Id
    private Integer id;

    @Column(nullable = false, unique = true)
    private String gmail;

    @Column(nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "agama", nullable = false)
    private String agama;

    @Column(name = "status_perkawinan", nullable = false)
    private String statusPerkawinan;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "created_by", nullable = false)
    private String createdBy;


    // Getter dan Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getStatusPerkawinan() {
        return statusPerkawinan;
    }

    public void setStatusPerkawinan(String statusPerkawinan) {
        this.statusPerkawinan = statusPerkawinan;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }


    // Constructor default (optional, JPA membutuhkan ini)
    public UserEntity() {
    }

    // Constructor dengan parameter (optional)
    public UserEntity(Integer id, String name, String gmail, String password, String agama, String statusPerkawinan, Timestamp createdAt, String createdBy) {
        this.id = id;
        this.name = name;
        this.gmail = gmail;
        this.password = password;
        this.agama = agama;
        this.statusPerkawinan = statusPerkawinan;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

}
