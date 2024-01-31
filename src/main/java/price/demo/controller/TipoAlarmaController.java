package price.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import price.demo.controller.DTO.TipoAlarmaDTO;
import price.demo.Services.TipoAlarmaService;

import java.util.List;

@RestController
public class TipoAlarmaController {
    public static final String API_BASE_PATH ="/tipoalarmas";
    public static final String API_PATH_FIND_TYPE_ALARM = API_BASE_PATH + "/buscartipoalarma";
    public static final String API_PATH_DELETE_TYPE_ALARM = API_BASE_PATH + "/borrartipoalarma";
    @Autowired
    private TipoAlarmaService tipoAlarmaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = API_BASE_PATH)
    public List<TipoAlarmaDTO> getAllTipoAlarmas() {
        return tipoAlarmaService.getAllTipoAlarmas();
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = API_PATH_FIND_TYPE_ALARM+"/{id}")
    public TipoAlarmaDTO getById(@PathVariable Integer id) {
        return tipoAlarmaService.getById(id);
    }
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = API_BASE_PATH)
    public TipoAlarmaDTO saveTipoAlarma(@RequestBody TipoAlarmaDTO tipoAlarmaDTO) {
        return tipoAlarmaService.saveTipoAlarma(tipoAlarmaDTO);
    }
    @DeleteMapping(path = API_PATH_DELETE_TYPE_ALARM)
    public void deleteTipoAlarma(@RequestBody TipoAlarmaDTO tipoAlarmaDTO){
        tipoAlarmaService.deleteTipoAlarma(tipoAlarmaDTO);
    }
}
