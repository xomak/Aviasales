package j2.orm.entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Vladislav Vasilyev <vavlvl at mail.ru>
 */
@Entity
@Table(name = "ttickets", schema = "public", catalog = "aviasales")
@AssociationOverrides({
        @AssociationOverride(name = "pk.client",
                joinColumns = @JoinColumn(name = "clientid")),
        @AssociationOverride(name = "pk.flightInfo",
                joinColumns = @JoinColumn(name = "flightid")) })
public class ETicket {
    private ETIcketId pk;
    private BigDecimal cost;
    private EFlightClass flightClass;

    @EmbeddedId
    public ETIcketId getPk() {
        return pk;
    }

    public void setPk(ETIcketId pk) {
        this.pk = pk;
    }

    @Basic
    @Column(name = "cost")
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ETicket eTicket = (ETicket) o;

        if (cost != null ? !cost.equals(eTicket.cost) : eTicket.cost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return cost != null ? cost.hashCode() : 0;
    }

    @ManyToOne
    @JoinColumn(name = "classid", referencedColumnName = "id", nullable = false)
    public EFlightClass getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(EFlightClass flightClass) {
        this.flightClass = flightClass;
    }
}
