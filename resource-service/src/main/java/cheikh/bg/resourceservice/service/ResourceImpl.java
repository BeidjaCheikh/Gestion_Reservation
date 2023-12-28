package cheikh.bg.resourceservice.service;

import cheikh.bg.resourceservice.dto.ResourceRequestDTO;
import cheikh.bg.resourceservice.dto.ResourceResponceDTO;
import cheikh.bg.resourceservice.entities.Resource;
import cheikh.bg.resourceservice.mapper.ResourceMapper;
import cheikh.bg.resourceservice.repository.ResourceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ResourceImpl implements ResourceService{
    private ResourceMapper resourceMapper;
    private ResourceRepository resourceRepository;


    public ResourceImpl(ResourceMapper resourceMapper, ResourceRepository resourceRepository) {
        this.resourceMapper = resourceMapper;
        this.resourceRepository = resourceRepository;
    }

    @Override
    public ResourceResponceDTO addResource(ResourceRequestDTO resourceRequestDTO) {
        Resource resource = resourceMapper.toResource(resourceRequestDTO);
        Resource resourcesaved = resourceRepository.save(resource);
        ResourceResponceDTO resourceResponceDTO = resourceMapper.fromResource(resourcesaved);
        return resourceResponceDTO;

    }

    @Override
    public ResourceResponceDTO getResourceById(Long resourceId) {
        Resource resource = resourceRepository.findById(resourceId)
                .orElseThrow(() -> new RuntimeException("Resource not found with id: " + resourceId));
        ResourceResponceDTO resourceResponceDTO=resourceMapper.fromResource(resource);
        return resourceResponceDTO;
    }
    @Override
    public List<ResourceResponceDTO> getAllResources() {
        List<Resource> allResources = resourceRepository.findAll();
        return allResources.stream()
                .map(resourceMapper::fromResource)
                .collect(Collectors.toList());
    }

    @Override
    public ResourceResponceDTO updateResource(Long id, ResourceRequestDTO resourceRequestDTO) {
        Resource existingResource = resourceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resource not found with id: " + id));
        existingResource.setName(resourceRequestDTO.getName());
        existingResource.setTypeResource(resourceRequestDTO.getTypeResource());
        Resource updatedResource = resourceRepository.save(existingResource);
        ResourceResponceDTO resourceResponceDTO = resourceMapper.fromResource(updatedResource);
        return resourceResponceDTO;
    }


}
