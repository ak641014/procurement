// Vendor document entity
package com.procurement.procurement.entity.vendor;

import jakarta.persistence.*;

@Entity
@Table(name = "vendor_documents")
public class VendorDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String documentName;  // e.g., "PAN Card", "GST Certificate"
    private String documentType;  // e.g., "PDF", "IMAGE"
    private String documentUrl;   // path ya link jahan document store hai
    private boolean verified;     // document verified or not

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    public VendorDocument() {
    }

    public VendorDocument(String documentName, String documentType, String documentUrl, boolean verified, Vendor vendor) {
        this.documentName = documentName;
        this.documentType = documentType;
        this.documentUrl = documentUrl;
        this.verified = verified;
        this.vendor = vendor;
    }

    // ===================== Getters & Setters =====================
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentUrl() {
        return documentUrl;
    }

    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
}
