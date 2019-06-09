package com.book.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CollectionId;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Role")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "role_id")
  private int roleId;

  private String name;

//  @JsonIgnoreProperties()
//  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
//  private Collection<User> users;


  @ManyToMany(cascade = {CascadeType.ALL})
  @JoinTable(
          name = "roles_privileges",
          joinColumns = @JoinColumn(
                  name = "role_id", referencedColumnName = "role_id"),
          inverseJoinColumns = @JoinColumn(
                  name = "privilege_id", referencedColumnName = "privilege_id"))
  private Collection<Privilege> privileges;

  public int getRoleId() {
    return roleId;
  }

  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Collection<Privilege> getPrivileges() {
    return privileges;
  }

  public void setPrivileges(Collection<Privilege> privileges) {
    this.privileges = privileges;
  }
}
