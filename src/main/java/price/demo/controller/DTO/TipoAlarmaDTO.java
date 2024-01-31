package price.demo.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoAlarmaDTO {
    private Integer id;
    private String xkey;
    private String descripcion;

    // Constructor y métodos adicionales si es necesario
}
