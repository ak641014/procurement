// Vendor response DTO
package com.procurement.procurement.dto.vendor;

public class VendorResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String status;       // ACTIVE / INACTIVE
    private Double rating;       // Optional: average rating
    private String compliance;   // Optional: compliance status

    public VendorResponseDTO() {
    }

    public VendorResponseDTO(Long id, String name, String email, String phone, String address, String status, Double rating, String compliance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.rating = rating;
        this.compliance = compliance;
    }

    // ===================== Getters & Setters =====================
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getCompliance() {
        return compliance;
    }

    public void setCompliance(String compliance) {
        this.compliance = compliance;
    }
}
