package cheikh.bg.resourceservice.service;

import cheikh.bg.resourceservice.dto.ResourceRequestDTO;
import cheikh.bg.resourceservice.dto.ResourceResponceDTO;

import java.util.List;

public interface ResourceService {
    ResourceResponceDTO addResource(ResourceRequestDTO resourceRequestDTO);
    ResourceResponceDTO getResourceById(Long resourceId);
    List<ResourceResponceDTO> getAllResources();
    ResourceResponceDTO updateResource(Long id,ResourceRequestDTO resourceRequestDTO );

}
