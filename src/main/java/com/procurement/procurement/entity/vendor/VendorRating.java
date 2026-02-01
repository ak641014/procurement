// Vendor rating entity
package com.procurement.procurement.entity.vendor;

import jakarta.persistence.*;

@Entity
@Table(name = "vendor_ratings")
public class VendorRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer rating; // e.g., 1-5
    private String feedback; // vendor ke liye comments ya notes

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    public VendorRating() {
    }

    public VendorRating(Integer rating, String feedback, Vendor vendor) {
        this.rating = rating;
        this.feedback = feedback;
        this.vendor = vendor;
    }

    // ===================== Getters & Setters =====================
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
}
