package j2.orm.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author Vladislav Vasilyev <vavlvl at mail.ru>
 */
@Entity
@Table(name = "tusers", schema = "public", catalog = "aviasales")
public class EUser {
    private Integer id;
    private String login;
    private String password;
    private EClient client;
    private Collection<ERole> roles;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EUser eUser = (EUser) o;

        if (id != null ? !id.equals(eUser.id) : eUser.id != null) return false;
        if (login != null ? !login.equals(eUser.login) : eUser.login != null) return false;
        if (password != null ? !password.equals(eUser.password) : eUser.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "clientid", referencedColumnName = "id")
    public EClient getClient() {
        return client;
    }

    public void setClient(EClient client) {
        this.client = client;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "tuserroles", catalog = "aviasales", joinColumns = {
            @JoinColumn(name = "userid", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "roleid",
                    nullable = false, updatable = false) })
    public Collection<ERole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<ERole> roles) {
        this.roles = roles;
    }

}
