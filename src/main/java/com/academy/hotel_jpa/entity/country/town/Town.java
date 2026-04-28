package com.academy.hotel_jpa.entity.country.town;

import com.academy.hotel_jpa.entity.country.Country;
import com.academy.hotel_jpa.entity.country.town.address.Address;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "town")
public class Town implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    //Town - town -> Country - country
    //MANY-TO-ONE
    //Jedan TOWN pripada jednom Country
    //Viđe TOWNs može imati isti Country
    @ManyToOne(optional = false)
    //Strani koja drži FK ili koja vlasnik relacije
    @JoinColumn(name = "id_country", referencedColumnName = "id")
    private Country country;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "town")
    private List<Address> addresses = new ArrayList<>();

    public Town() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Town town)) return false;
        return Objects.equals(id, town.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Town{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
