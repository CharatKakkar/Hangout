package com.hangout.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length=40, nullable = false, unique = true)

    private String email;

    @Column(length=40, nullable = false)
    private String password;

    @Column(length=40, nullable = false)
    private String fName;

    @Column(length=40, nullable = false)
    private String lName;

    @Transient
    private String photo;

    @ColumnDefault("1")
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles" ,
            joinColumns = @JoinColumn(name = "userID"),
            inverseJoinColumns = @JoinColumn(name = "roleID")
    )
    private Set<Role> roles = new HashSet<>();


    public void addRoles(List<Role> rolesList){
        roles.addAll(rolesList);
    }

    public User(String fName, String lName,String email, String password,  boolean enabled){
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
    }

}
