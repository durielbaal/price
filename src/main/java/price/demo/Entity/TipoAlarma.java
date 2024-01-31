package price.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
/*Esto me ahora construir getters, setters y constructores (llenos y vacíos)*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoAlarma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String xkey;
    private String descripcion;
}
