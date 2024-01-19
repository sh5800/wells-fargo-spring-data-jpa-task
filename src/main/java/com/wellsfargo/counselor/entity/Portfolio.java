package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;
import java.util.List;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue()
    private long portfolioId;
    @ManyToOne
    @JoinColumn(name = "client_id",nullable = false)
    private Client client;

    @CreatedDate
    @Column(nullable = false)
    private Date creationDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "portfolio")
    private List<Securities> securities;

    protected Portfolio() {
    }

    public Portfolio(Client client, Date creationDate, List<Securities> securities) {
        this.client = client;
        this.creationDate = creationDate;
        this.securities = securities;
    }

    public long getPortfolioId() {
        return portfolioId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Securities> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Securities> securities) {
        this.securities = securities;
    }
}