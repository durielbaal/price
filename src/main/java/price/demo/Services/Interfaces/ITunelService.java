package price.demo.Services.Interfaces;

import price.demo.controller.DTO.TunelDTO;

import java.util.List;

public interface ITunelService {
    public List<TunelDTO> getAllTuneles();
    public TunelDTO saveTunel(TunelDTO tunelDTO);
    public void deleteTunel(TunelDTO TunelDTO);
    public TunelDTO getById(Integer id);
}
