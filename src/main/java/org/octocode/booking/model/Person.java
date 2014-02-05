package org.octocode.booking.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "Person")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(name = "username")
    @NotEmpty
    protected String username;

    @Column(name = "password")
    @NotEmpty
    protected String password;
    @Column(name = "first_name")
    @NotEmpty
    protected String firstName;
    @Column(name = "last_name")
    @NotEmpty
    protected String lastName;
    @Column(name = "address")
    @NotEmpty
    private String address;
    @Column(name = "city")
    @NotEmpty
    private String city;
    @Column(name = "telephone")
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    private String telephone;

    public Person() {
    }

    public Person(String username, String firstName, String lastName, String address, String city, String telephone) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew() {
        return (this.id == null);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId())
                .append("new", this.isNew())
                .append("lastName", this.getLastName())
                .append("firstName", this.getFirstName())
                .append("address", this.address)
                .append("city", this.city)
                .append("telephone", this.telephone)
                .toString();
    }
}
