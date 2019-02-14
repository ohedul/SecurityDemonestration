package bd.ohedulalam.SecurityDemonestration.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users_table")
public class users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="user_id")
    private int id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String passwaor;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public users() {
    }

    public users(users user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.passwaor = user.getPasswaor();
        this.roles = user.getRoles();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswaor() {
        return passwaor;
    }

    public void setPasswaor(String passwaor) {
        this.passwaor = passwaor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
