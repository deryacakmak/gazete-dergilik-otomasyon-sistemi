package com.gazete_dergi_otomasyon.model;

import javax.persistence.*;


@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String  publisherName;


    public Publisher(Long id, String publisherName) {
        this.id = id;
        this.publisherName = publisherName;
    }

    public Publisher() { }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
}
