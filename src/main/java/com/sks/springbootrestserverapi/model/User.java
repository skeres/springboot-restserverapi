package com.sks.springbootrestserverapi.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * L'annotation @Entity permet d'indiquer à l'ORM Hibernate que cette classe sera une table de la base de données et
 * l'annotation @Table(name = "UTILISATEUR") permet de donner le nom UTILISATEUR à la table.
 *
 * Grâce à ces annotations, on n'a plus besoin du fichier de configuration persistence.xml.
 */
@Entity
@Table(name = "UTILISATEUR")
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //c'est la base de données qui va générer la clé primaire
    @Column(name = "USER_ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "LOGIN", unique=true, insertable=true, updatable=true, nullable=false)
    private String login;

    @Column(name = "USER_PASSWORD", insertable=true, updatable=true, nullable=false)
    private String password;

    @Column(name = "USER_ACTIVE", insertable=true, updatable = true, nullable=false)
    private Integer active;

    /**
     * Une personne peut à la fois avoir le rôle administrateur et le rôle utilisateur. Plusieurs utilisateurs peuvent avoir le même rôle.
     * On peut par exemple avoir plusieurs administrateurs : c'est ce qui explique l'existence de la relation ManyToMany.
     *
     * Au niveau de la base de données, cela donne naissance à une table de jointure que je vais nommer : USER_ROLE, à ne
     * pas confondre avec la table ROLE qui stocke tous les rôles. On a ainsi terminé le model.
     * 
     */
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> roles= new HashSet<>();

    public User() {
        super();
    }

    public User(String login, String password, Integer active) {
        this.login = login;
        this.password = password;
        this.active = active;
    }

    public User(Long id, String login, String password, Integer active) {
        this.id= id;
        this.login=login;
        this.password = password;
        this.active=active;
    }

    public User(String login, String password) {
        this.login=login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getActive() {
        return active;
    }
    public void setActive(Integer active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", login=" + login + ", password=XXXXXXX, active=" + active + ", roles="
                + roles + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((active == null) ? 0 : active.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((roles == null) ? 0 : roles.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (active == null) {
            if (other.active != null)
                return false;
        } else if (!active.equals(other.active))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (roles == null) {
            if (other.roles != null)
                return false;
        } else if (!roles.equals(other.roles))
            return false;
        return true;
    }
}
