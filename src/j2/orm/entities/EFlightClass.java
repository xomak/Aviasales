package j2.orm.entities;

import javax.persistence.*;

/**
 * @author Vladislav Vasilyev <vavlvl at mail.ru>
 */
@Entity
@Table(name = "tflightclass", schema = "public", catalog = "aviasales")
public class EFlightClass {
    private Integer id;
    private String flightClass;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "class")
    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EFlightClass that = (EFlightClass) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (flightClass != null ? !flightClass.equals(that.flightClass) : that.flightClass != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (flightClass != null ? flightClass.hashCode() : 0);
        return result;
    }
}
