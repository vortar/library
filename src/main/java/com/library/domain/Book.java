package com.library.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "BOOKS")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    private Long id;


    @Column(name = "TITLE")
    private String title;

    @Column(name = "Author")
    private String author;

    @Column(name = "kinds")
    private String kind;



    @OneToMany(
            targetEntity = Copy.class,
            mappedBy = "book",
            fetch = FetchType.LAZY
    )
    private List<Copy> copies = new ArrayList<>();


}
