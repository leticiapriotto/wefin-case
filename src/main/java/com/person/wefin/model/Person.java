package com.person.wefin.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Data @NoArgsConstructor
public class Person {

    private String name;

    @Id
    private String identificador;

    @Enumerated(EnumType.STRING)
    private TipoIdentificador tipoIdentificador;

    public TipoIdentificador personVerification() {
        switch (identificador.length()) {
            case 11:
                return tipoIdentificador = TipoIdentificador.CPF;
            case 14:
                return tipoIdentificador = TipoIdentificador.CNPJ;
            default:
                throw new IllegalArgumentException();
        }
    }

}