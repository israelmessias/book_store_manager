package com.israel.bookstoremanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book")
/*é uma anotação de atalho conveniente que agrupa os recursos de
 @ToString, @EqualsAndHashCode, @Getter / @Settere @RequiredArgsConstructor*/
@Data
/*@Builderpermite que você produza automaticamente o
 código necessário para que sua classe seja instanciada com códigos como*/
@Builder
@NoArgsConstructor //Construtor sem argumentos
@AllArgsConstructor// COnstrutor com argumentos
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 200)
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer pages;

    @NotBlank
    @Size(max = 50, min = 4)
    @Column(nullable = false)
    private String isbn;

    @NotBlank
    @Size(max = 200)
    @Column(name="publisher_name",nullable = false, unique = true)
    private String publisherName;
    /*
    * PESIST = Quando incluir um livro tambem é incluido um autor
    * MERGE = Quando Atualizada o Livro atualiza tambem o autor
    * REMOVE = Quando remover o livro remove o author_id*/
    @Valid
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})//Um livro tem um autor
    @JoinColumn(name="author_id")
    private Author author;
}
