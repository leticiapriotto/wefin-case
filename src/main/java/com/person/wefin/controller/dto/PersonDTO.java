package com.person.wefin.controller.dto;

import com.person.wefin.model.TipoIdentificador;
import lombok.*;

@Data @NoArgsConstructor
public class PersonDTO {

    private String name;
    private String identificador;
    private TipoIdentificador tipoIdentificador;

}
