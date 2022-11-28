package com.hangout.common.entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="roles")
@Data
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length=40, nullable = false, unique = true)
    private String name;

    @Column(length = 100, nullable = false)
    private String description;

    public Role(String name, String desc) {
        this.name = name;
        this.description = desc;
    }

    public String toString(){
        return name;
    }
}
