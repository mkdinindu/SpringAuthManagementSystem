package com.practice.usermanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "roles")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    private String id;

    @Column(unique = true)
    private String name;

}
