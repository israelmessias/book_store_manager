package com.israel.bookstoremanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "author")
/*é uma anotação de atalho conveniente que agrupa os recursos de
 @ToString, @EqualsAndHashCode, @Getter / @Settere @RequiredArgsConstructor*/
@Data
/*@Builderpermite que você produza automaticamente o
 código necessário para que sua classe seja instanciada com códigos como*/
@Builder
@NoArgsConstructor //Construtor sem argumentos
@AllArgsConstructor// COnstrutor com argumentos
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 200)
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer age;

}
