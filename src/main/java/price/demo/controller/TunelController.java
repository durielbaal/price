package price.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import price.demo.controller.DTO.TunelDTO;
import price.demo.Services.TunelService;

import java.util.List;

@RestController
public class TunelController {
    public static final String API_BASE_PATH = "/tuneles";
    public static final String API_PATH_FIND_TUNNEL = API_BASE_PATH + "/buscartunel";
    public static final String API_PATH_DELETE_TUNNEL= API_BASE_PATH + "/borrartunel";
    @Autowired
    private TunelService tunelService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = API_BASE_PATH)
    public List<TunelDTO> getAllTuneles() {
        return tunelService.getAllTuneles();
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = API_PATH_FIND_TUNNEL+"/{id}")
    public TunelDTO getById(@PathVariable Integer id){return tunelService.getById(id);}
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = API_BASE_PATH)
    public TunelDTO saveTunel(@RequestBody TunelDTO tunelDTO) {
        return tunelService.saveTunel(tunelDTO);
    }
    @DeleteMapping(path = API_PATH_DELETE_TUNNEL)
    public void deleteTunel (@RequestBody TunelDTO tunelDTO){tunelService.deleteTunel(tunelDTO);}



}

