package com.agriconnect.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "suggestions")
public class Suggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String advice; // Matches frontend field name

    private String expertName; // Matches frontend field name

    public Suggestion() {}

    public Suggestion(Long id, String advice, String expertName) {
        this.id = id;
        this.advice = advice;
        this.expertName = expertName;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAdvice() { return advice; }
    public void setAdvice(String advice) { this.advice = advice; }

    public String getExpertName() { return expertName; }
    public void setExpertName(String expertName) { this.expertName = expertName; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Suggestion that = (Suggestion) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
