package j2.orm.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by vlad on 17.07.2016.
 */
@Entity
@Table(name = "tairlines", schema = "public", catalog = "aviasales")
public class EAirline {
    private Integer id;
    private String icao;
    private String iata;
    private String name;
    private EContry country;
    private Collection<EFlight> flightses;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "icao")
    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    @Basic
    @Column(name = "iata")
    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
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

        EAirline eAirline = (EAirline) o;

        if (id != null ? !id.equals(eAirline.id) : eAirline.id != null) return false;
        if (icao != null ? !icao.equals(eAirline.icao) : eAirline.icao != null) return false;
        if (iata != null ? !iata.equals(eAirline.iata) : eAirline.iata != null) return false;
        if (name != null ? !name.equals(eAirline.name) : eAirline.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (icao != null ? icao.hashCode() : 0);
        result = 31 * result + (iata != null ? iata.hashCode() : 0);
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

    @OneToMany(mappedBy = "airline")
    public Collection<EFlight> getFlightses() {
        return flightses;
    }

    public void setFlightses(Collection<EFlight> flightses) {
        this.flightses = flightses;
    }
}
