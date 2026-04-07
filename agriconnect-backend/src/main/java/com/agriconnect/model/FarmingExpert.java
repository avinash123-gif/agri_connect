package com.agriconnect.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "farming_experts")
public class FarmingExpert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private String qualification;
    private String fieldOfExpertise;
    
    @Column(length = 1000)
    private String bio;

    public FarmingExpert() {}

    public FarmingExpert(Long id, User user, String qualification, String fieldOfExpertise, String bio) {
        this.id = id;
        this.user = user;
        this.qualification = qualification;
        this.fieldOfExpertise = fieldOfExpertise;
        this.bio = bio;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getQualification() { return qualification; }
    public void setQualification(String qualification) { this.qualification = qualification; }

    public String getFieldOfExpertise() { return fieldOfExpertise; }
    public void setFieldOfExpertise(String fieldOfExpertise) { this.fieldOfExpertise = fieldOfExpertise; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FarmingExpert expert = (FarmingExpert) o;
        return Objects.equals(id, expert.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
