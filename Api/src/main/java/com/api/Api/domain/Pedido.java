package com.api.Api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name="Pedido")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue UUID id;

    @Column(nullable = false)
    private int andares;

    @Column(nullable = false)
    private String cor1;

    @Column(nullable = false)
    private String cor2;

    @Column(nullable = false)
    private String cor3;

    @Column(nullable = false)
    private String desenho1;

    @Column(nullable = false)
    private String desenho2;

    @Column(nullable = false)
    private String desenho3;

}
