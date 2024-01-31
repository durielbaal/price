package price.demo.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TunelDTO {
    private Integer idTunel;
    private TipoAlarmaDTO alarmType;
    private LocalDateTime alarm;
    private String descripcion;
    private Integer severidad;

}
