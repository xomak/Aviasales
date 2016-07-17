package j2.orm.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * @author Vladislav Vasilyev <vavlvl at mail.ru>
 */
@Entity
@Table(name = "tflightinfo", schema = "public", catalog = "aviasales")
public class EFlightInfo {
    private Timestamp departureTime;
    private Timestamp arrivalTime;
    private Integer id;
    private Collection<EFlightCost> flightCosts;
    private EFlight flight;
    private Collection<ETicket> tickets;

    @Basic
    @Column(name = "departuretime")
    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    @Basic
    @Column(name = "arrivaltime")
    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivialTime) {
        this.arrivalTime = arrivialTime;
    }

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

        EFlightInfo that = (EFlightInfo) o;

        if (departureTime != null ? !departureTime.equals(that.departureTime) : that.departureTime != null)
            return false;
        if (arrivalTime != null ? !arrivalTime.equals(that.arrivalTime) : that.arrivalTime != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = departureTime != null ? departureTime.hashCode() : 0;
        result = 31 * result + (arrivalTime != null ? arrivalTime.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "pk.flightInfo")
    public Collection<EFlightCost> getFlightCosts() {
        return flightCosts;
    }

    public void setFlightCosts(Collection<EFlightCost> flightCosts) {
        this.flightCosts = flightCosts;
    }

    @ManyToOne
    @JoinColumn(name = "flightid", referencedColumnName = "id")
    public EFlight getFlight() {
        return flight;
    }

    public void setFlight(EFlight flight) {
        this.flight = flight;
    }

    @OneToMany(mappedBy = "pk.flightInfo")
    public Collection<ETicket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<ETicket> tticketses) {
        this.tickets = tticketses;
    }
}
