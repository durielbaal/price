package price.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tunel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTunel;
    /*Varios Tuneles pueden tener un tipo de alarma (N a 1)*/
    @ManyToOne
    @JoinColumn(name = "id")
    private TipoAlarma alarmType;

    private LocalDateTime alarm;
    private String descripcion;
    private Integer severidad;
}
