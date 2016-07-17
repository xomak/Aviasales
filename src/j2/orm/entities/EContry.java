package j2.orm.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author Vladislav Vasilyev <vavlvl at mail.ru>
 */
@Entity
@Table(name = "tcontries", schema = "public", catalog = "aviasales")
public class EContry {
    private Integer id;
    private String country;
    private Collection<EAirline> tairlinesById;
    private Collection<EAirport> tairportsesById;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EContry eContry = (EContry) o;

        if (id != null ? !id.equals(eContry.id) : eContry.id != null) return false;
        if (country != null ? !country.equals(eContry.country) : eContry.country != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "country")
    public Collection<EAirline> getTairlinesById() {
        return tairlinesById;
    }

    public void setTairlinesById(Collection<EAirline> tairlinesById) {
        this.tairlinesById = tairlinesById;
    }

    @OneToMany(mappedBy = "country")
    public Collection<EAirport> getTairportsesById() {
        return tairportsesById;
    }

    public void setTairportsesById(Collection<EAirport> tairportsesById) {
        this.tairportsesById = tairportsesById;
    }
}
