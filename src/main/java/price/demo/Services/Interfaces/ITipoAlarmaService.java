package price.demo.Services.Interfaces;

import price.demo.controller.DTO.TipoAlarmaDTO;

import java.util.List;

public interface ITipoAlarmaService {
    public List<TipoAlarmaDTO> getAllTipoAlarmas();
    public TipoAlarmaDTO saveTipoAlarma(TipoAlarmaDTO tipoAlarmaDTO);
    public void deleteTipoAlarma(TipoAlarmaDTO tipoAlarmaDTO);
    public TipoAlarmaDTO getById(Integer id);
}
