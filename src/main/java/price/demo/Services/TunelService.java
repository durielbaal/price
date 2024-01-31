package price.demo.Services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import price.demo.Entity.Tunel;
import price.demo.controller.DTO.TunelDTO;
import price.demo.Repository.TunelRepository;
import price.demo.Services.Interfaces.ITunelService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TunelService implements ITunelService {
    @Autowired
    private TunelRepository tunelRepository;
    @Override
    public List<TunelDTO> getAllTuneles() {
        return tunelRepository.findAll().stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    @Override
    public TunelDTO saveTunel(TunelDTO tunelDTO) {
        Tunel tunel = convertToEntity(tunelDTO);
        Tunel savedTunel = tunelRepository.save(tunel);
        return convertToDTO(savedTunel);
    }
    @Override
    public void deleteTunel(TunelDTO tunelDTO) {
        Tunel tunel = convertToEntity(tunelDTO);
        tunelRepository.delete(tunel);
    }

    @Override
    public TunelDTO getById(Integer id) {
        Optional<Tunel> opTunel = tunelRepository.findById(id);
        return opTunel.map(this::convertToDTO).orElse(null);
    }
    private TunelDTO convertToDTO(Tunel tunel) {
        TunelDTO tunelDTO = new TunelDTO();
        BeanUtils.copyProperties(tunel, tunelDTO);
        return tunelDTO;
    }

    private Tunel convertToEntity(TunelDTO tunelDTO) {
        Tunel tunel = new Tunel();
        BeanUtils.copyProperties(tunelDTO, tunel);
        return tunel;
    }

}
