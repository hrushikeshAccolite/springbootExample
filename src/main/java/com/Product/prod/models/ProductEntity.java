package com.Product.prod.models;

import java.util.Date;
import jakarta.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long prodId;

    @Column(name = "prodName")
    private String prodName;

    @Column(name = "prodPrice")
    private long prodPrice;

    @CreationTimestamp
    private Date createdDate;

    public long getProdId() {
        return prodId;
    }

    public void setProdId(long prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public long getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(long prodPrice) {
        this.prodPrice = prodPrice;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
