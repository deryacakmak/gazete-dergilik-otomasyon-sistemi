package com.gazete_dergi_otomasyon.model;

import javax.persistence.*;


@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private EPublisher  publisherName;


    public Publisher(Long id, EPublisher publisherName) {
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

    public EPublisher getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(EPublisher publisherName) {
        this.publisherName = publisherName;
    }
}
