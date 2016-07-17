package j2.orm.entities;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * @author Vladislav Vasilyev <vavlvl at mail.ru>
 */
@Embeddable
public class ETIcketId implements Serializable {
    private EClient client;
    private EFlightInfo flightInfo;

    @ManyToOne
    public EClient getClient() {
        return client;
    }

    public void setClient(EClient client) {
        this.client = client;
    }

    @ManyToOne
    public EFlightInfo getFlightInfo() {
        return flightInfo;
    }

    public void setFlightInfo(EFlightInfo flightInfo) {
        this.flightInfo = flightInfo;
    }

}
