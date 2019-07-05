package com.library.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name ="Authors")
public class AuthorsOfBooks {



    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id" )
    private Long id;


    @Column(name = "Author")
    private String name;
}
