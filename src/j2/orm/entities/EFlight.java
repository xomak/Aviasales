package j2.orm.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author Vladislav Vasilyev <vavlvl at mail.ru>
 */
@Entity
@Table(name = "tflights", schema = "public", catalog = "aviasales")
public class EFlight {
    private Integer id;
    private Collection<EFlightInfo> flightInfos;
    private EAirport departureAirport;
    private EAirport arrivalAirport;
    private EAirline airline;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EFlight eFlight = (EFlight) o;

        if (id != null ? !id.equals(eFlight.id) : eFlight.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @OneToMany(mappedBy = "flight")
    public Collection<EFlightInfo> getFlightInfos() {
        return flightInfos;
    }

    public void setFlightInfos(Collection<EFlightInfo> flightInfos) {
        this.flightInfos = flightInfos;
    }

    @ManyToOne
    @JoinColumn(name = "departure", referencedColumnName = "key", nullable = false)
    public EAirport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(EAirport departureAirport) {
        this.departureAirport = departureAirport;
    }

    @ManyToOne
    @JoinColumn(name = "arrival", referencedColumnName = "key", nullable = false)
    public EAirport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(EAirport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    @ManyToOne
    @JoinColumn(name = "airlineid", referencedColumnName = "id", nullable = false)
    public EAirline getAirline() {
        return airline;
    }

    public void setAirline(EAirline airline) {
        this.airline = airline;
    }
}
