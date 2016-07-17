package j2.orm.entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Vladislav Vasilyev <vavlvl at mail.ru>
 */
@Entity
@Table(name = "tflightcost", schema = "public", catalog = "aviasales")
@AssociationOverrides({
        @AssociationOverride(name = "pk.flightClass",
                joinColumns = @JoinColumn(name = "flightclassid")),
        @AssociationOverride(name = "pk.flightInfo",
                joinColumns = @JoinColumn(name = "flightinfoid")) })
public class EFlightCost {

    private EFlightCostId pk;
    private BigDecimal cost;
    private Integer totalNumber;
    private Integer availableNumber;

    @EmbeddedId
    public EFlightCostId getPk() {
        return pk;
    }

    public void setPk(EFlightCostId pk) {
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

    @Basic
    @Column(name = "totalnumber")
    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalnumber) {
        this.totalNumber = totalnumber;
    }

    @Basic
    @Column(name = "availablenumber")
    public Integer getAvailableNumber() {
        return availableNumber;
    }

    public void setAvailableNumber(Integer availablenumber) {
        this.availableNumber = availablenumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EFlightCost that = (EFlightCost) o;

        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;
        if (totalNumber != null ? !totalNumber.equals(that.totalNumber) : that.totalNumber != null) return false;
        if (availableNumber != null ? !availableNumber.equals(that.availableNumber) : that.availableNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cost != null ? cost.hashCode() : 0;
        result = 31 * result + (totalNumber != null ? totalNumber.hashCode() : 0);
        result = 31 * result + (availableNumber != null ? availableNumber.hashCode() : 0);
        return result;
    }

}
