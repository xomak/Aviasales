package j2.orm.entities;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * @author Vladislav Vasilyev <vavlvl at mail.ru>
 */
@Embeddable
public class EFlightCostId implements Serializable {
    private EFlightClass flightClass;
    private EFlightInfo flightInfo;

    @ManyToOne
    public EFlightClass getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(EFlightClass flightClass) {
        this.flightClass = flightClass;
    }

    @ManyToOne
    public EFlightInfo getFlightInfo() {
        return flightInfo;
    }

    public void setFlightInfo(EFlightInfo flightInfo) {
        this.flightInfo = flightInfo;
    }
}
