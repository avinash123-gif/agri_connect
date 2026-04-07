package com.agriconnect.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "schemes")
public class Scheme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    
    @Column(length = 1000)
    private String description;
    
    private String benefits;
    private String link;
    private String category; // SUBSIDY, LOAN, INSURANCE, TRAINING
    private String eligibility;

    public Scheme() {}

    public Scheme(Long id, String name, String description, String benefits, String link, String category, String eligibility) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.benefits = benefits;
        this.link = link;
        this.category = category;
        this.eligibility = eligibility;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getBenefits() { return benefits; }
    public void setBenefits(String benefits) { this.benefits = benefits; }

    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getEligibility() { return eligibility; }
    public void setEligibility(String eligibility) { this.eligibility = eligibility; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scheme scheme = (Scheme) o;
        return Objects.equals(id, scheme.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
