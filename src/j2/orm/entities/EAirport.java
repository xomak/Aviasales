package j2.orm.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by vlad on 17.07.2016.
 */
@Entity
@Table(name = "tairports", schema = "public", catalog = "aviasales")
public class EAirport {
    private String key;
    private String city;
    private String name;
    private EContry country;
    private Collection<EFlight> departureAirport;
    private Collection<EFlight> arrivalAirport;

    @Id
    @Column(name = "key")
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EAirport eAirport = (EAirport) o;

        if (key != null ? !key.equals(eAirport.key) : eAirport.key != null) return false;
        if (city != null ? !city.equals(eAirport.city) : eAirport.city != null) return false;
        if (name != null ? !name.equals(eAirport.name) : eAirport.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "countryid", referencedColumnName = "id")
    public EContry getCountry() {
        return country;
    }

    public void setCountry(EContry country) {
        this.country = country;
    }

    @OneToMany(mappedBy = "departureAirport")
    public Collection<EFlight> getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Collection<EFlight> departureAirport) {
        this.departureAirport = departureAirport;
    }

    @OneToMany(mappedBy = "arrivalAirport")
    public Collection<EFlight> getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Collection<EFlight> arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }
}
