package j2.orm.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by vlad on 17.07.2016.
 */
@Entity
@Table(name = "tclients", schema = "public", catalog = "aviasales")
public class EClient {
    private Integer id;
    private String surname;
    private String name;
    private Date birthdate;
    private String passseries;
    private String passnumber;
    private Collection<ETicket> tickets;
    private Collection<EUser> users;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "birthdate")
    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Basic
    @Column(name = "passseries")
    public String getPassseries() {
        return passseries;
    }

    public void setPassseries(String passseries) {
        this.passseries = passseries;
    }

    @Basic
    @Column(name = "passnumber")
    public String getPassnumber() {
        return passnumber;
    }

    public void setPassnumber(String passnumber) {
        this.passnumber = passnumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EClient eClient = (EClient) o;

        if (id != null ? !id.equals(eClient.id) : eClient.id != null) return false;
        if (surname != null ? !surname.equals(eClient.surname) : eClient.surname != null) return false;
        if (name != null ? !name.equals(eClient.name) : eClient.name != null) return false;
        if (birthdate != null ? !birthdate.equals(eClient.birthdate) : eClient.birthdate != null) return false;
        if (passseries != null ? !passseries.equals(eClient.passseries) : eClient.passseries != null) return false;
        if (passnumber != null ? !passnumber.equals(eClient.passnumber) : eClient.passnumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        result = 31 * result + (passseries != null ? passseries.hashCode() : 0);
        result = 31 * result + (passnumber != null ? passnumber.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "pk.client")
    public Collection<ETicket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<ETicket> tickets) {
        this.tickets = tickets;
    }

    @OneToMany(mappedBy = "client")
    public Collection<EUser> getUsers() {
        return users;
    }

    public void setUsers(Collection<EUser> users) {
        this.users = users;
    }
}
