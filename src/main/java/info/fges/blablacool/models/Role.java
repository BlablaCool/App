package info.fges.blablacool.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Valentin on 15/03/15.
 */
@Entity
public class Role {
    private int idRole;
    private String role;
    private List<User> users;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id_role", nullable = false, insertable = false, updatable = false)
    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    @Basic
    @Column(name = "role", nullable = false, insertable = true, updatable = true, length = 42)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role1 = (Role) o;

        if (idRole != role1.idRole) return false;
        if (role != null ? !role.equals(role1.role) : role1.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRole;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @ManyToMany(mappedBy = "roles")
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
