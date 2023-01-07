package com.prueba.pruebabackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;
    private String tx_uid;
    private String tx_user;
    private String tx_email;
    private String tx_pass;
    private String tx_rol;
    private String tx_fullname;
    private String tx_avatar;

}
