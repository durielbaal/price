package price.demo.Services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import price.demo.controller.DTO.TipoAlarmaDTO;
import price.demo.Entity.TipoAlarma;
import price.demo.Repository.TipoAlarmaRepository;
import price.demo.Services.Interfaces.ITipoAlarmaService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoAlarmaService implements ITipoAlarmaService {
    @Autowired
    private TipoAlarmaRepository tipoAlarmaRepository;
    @Override
    public List<TipoAlarmaDTO> getAllTipoAlarmas() {
        return tipoAlarmaRepository.findAll().stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    @Override
    public TipoAlarmaDTO saveTipoAlarma(TipoAlarmaDTO tipoAlarmaDTO) {
        TipoAlarma tipoAlarma = convertToEntity(tipoAlarmaDTO);
        TipoAlarma savedTipoAlarma= tipoAlarmaRepository.save(tipoAlarma);
        return convertToDTO(savedTipoAlarma);
    }
    @Override
    public void deleteTipoAlarma(TipoAlarmaDTO tipoAlarmaDTO){
        TipoAlarma tipoAlarma= convertToEntity(tipoAlarmaDTO);
        tipoAlarmaRepository.delete(tipoAlarma);
    }
    @Override
    public TipoAlarmaDTO getById(Integer id){
        Optional<TipoAlarma> opTipoAlarma=tipoAlarmaRepository.findById(id);
        return opTipoAlarma.map(this::convertToDTO).orElse(null);
    }
    private TipoAlarma convertToEntity(TipoAlarmaDTO tipoAlarmaDTO) {
        TipoAlarma tipoAlarma = new TipoAlarma();
        BeanUtils.copyProperties(tipoAlarmaDTO, tipoAlarma);
        return tipoAlarma;
    }
    private TipoAlarmaDTO convertToDTO(TipoAlarma tipoAlarma) {
        TipoAlarmaDTO tipoAlarmaDTO = new TipoAlarmaDTO();
        BeanUtils.copyProperties(tipoAlarma, tipoAlarmaDTO);
        return tipoAlarmaDTO;
    }
}
