package com.api.ciclo3.mt.Ciclo3.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Miguel Rojas
 */

/**
 * Date 20/10/2021
 * Reto 3
 * Clase Ortopedic
 */

@Entity
@Table(name = "ortopedic")
public class Ortopedic implements Serializable {

    /**
     * Clase principal Ortopedic, implementa los métodos y atributos de la clase Serializable
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Atributo ID de la clase Ortopedic
     * @param id
     */

    @Column(length = 45)
    private String name;

    /**
     * Atributo BRAND de la clase ortopedic
     * @para brand
     */

    @Column(length = 45)
    private String brand;

    /**
     * Atributo YEAR de la clase ortopedic
     * @param year
     */

    @Column(length = 4)
    private Integer year;

    /**
     * Atributo DESCRIPTION de la clase ortopedic
     * @param description
     */

    @Column(length = 250)
    private String description;

    /**
     *Atributo CATEGORY de la clase ortopedic, relación de muchos a uno
     * @param category
     */

    @ManyToOne
    @JoinColumn(name = "categoryID")
    @JsonIgnoreProperties("ortopedics")
    private Category category;

    /**
     *Atributo MESSAGES de la clase ortopedic, relación de uno a muchos
     * @param messages
     */

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "ortopedic")
    @JsonIgnoreProperties({"ortopedic","client"})
    public List<Message> messages;

    /**
     *Atributo RESERVATIONS de la clase ortopedic, relación de uno a muchos
     * @param reservations
     */

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "ortopedic")
    @JsonIgnoreProperties("ortopedic")
    public List<Reservation> reservations;

    /**
     * Método para obtener el ID de ortopedic
     * @return id
     */

    public Integer getId() {
        return id;
    }

    /**
     * Método para establecer el ID
     * @param id
     */

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Método para obtener el NAME de ortopedic
     * @return name
     */

    public String getName() {
        return name;
    }

    /**
     * Método para establecer el NAME de ortopedic
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método para obtener el BRAND de ortopedic
     * @return brand
     */

    public String getBrand() {
        return brand;
    }

    /**
     * Método para establecer el BRAND de ortopedic
     * @param brand
     */

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Método para obtener el YEAR de ortopedic
     * @return year
     */

    public Integer getYear() {
        return year;
    }

    /**
     * Método para establecer el YEAR de ortopedic
     * @param year
     */

    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * Método para obtener la DESCRIPTION de ortopedic
     * @return description
     */

    public String getDescription() {
        return description;
    }

    /**
     * Método para establecer la DESCRIPTION de ortopedic
     * @param description
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Método para obtener CATEGORY de ortopedic
     * @return category
     */

    public Category getCategory() {
        return category;
    }

    /**
     * Método para establecer CATEGORY de ortopedic
     * @param category
     */

    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Método para obtener MESSAGES de ortopedic
     * @return messages
     */

    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Método para establecer MESSAGES de ortopedic
     * @param messages
     */

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * Método para obtener RESERVATION de ortopedic
     * @return reservations
     */

    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Método para establecer RESERVATION de ortopedic
     * @param reservations
     */

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}// Fin de la clase