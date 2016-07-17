package j2.orm.entities;

import javax.persistence.*;

/**
 * @author Vladislav Vasilyev <vavlvl at mail.ru>
 */
@Entity
@Table(name = "troles", schema = "public", catalog = "aviasales")
public class ERole {
    private Integer id;
    private String name;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

        ERole eRole = (ERole) o;

        if (id != null ? !id.equals(eRole.id) : eRole.id != null) return false;
        if (name != null ? !name.equals(eRole.name) : eRole.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
