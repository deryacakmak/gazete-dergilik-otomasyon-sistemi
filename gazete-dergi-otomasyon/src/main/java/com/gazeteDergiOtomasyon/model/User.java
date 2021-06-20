package com.gazeteDergiOtomasyon.model;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="USER")
public class User implements Serializable {

    private static final long serialVersionUID = 6805770934683941123L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID", unique = true, nullable = false)
    private Integer id;

    @Column(name="NAME", unique = true, nullable = false)
    private String name;

    @Column(name="SURNAME", unique = true, nullable = false)
    private String surname;


}