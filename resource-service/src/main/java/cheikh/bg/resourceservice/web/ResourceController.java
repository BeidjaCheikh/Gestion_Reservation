package cheikh.bg.resourceservice.web;

import cheikh.bg.resourceservice.dto.ResourceRequestDTO;
import cheikh.bg.resourceservice.dto.ResourceResponceDTO;
import cheikh.bg.resourceservice.entities.Resource;
import cheikh.bg.resourceservice.repository.ResourceRepository;
import cheikh.bg.resourceservice.service.ResourceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ResourceController {

private ResourceRepository resourceRepository;
private ResourceService resourceService;

    public ResourceController(ResourceRepository resourceRepository, ResourceService resourceService) {
        this.resourceRepository = resourceRepository;
        this.resourceService = resourceService;
    }

    @GetMapping("/resources")
    public List<ResourceResponceDTO> allResources(){
        return resourceService.getAllResources();
    }
    @GetMapping("/resources/{id}")
    public ResourceResponceDTO getResourceById(@PathVariable Long id) {
        return resourceService.getResourceById(id);
    }

    @PostMapping("/resources")
    public ResourceResponceDTO createResource(@RequestBody ResourceRequestDTO resourceRequestDTO) {
        return resourceService.addResource(resourceRequestDTO);
    }
    @PutMapping("/resources/{id}")
    public ResourceResponceDTO updateResource(@PathVariable Long id, @RequestBody ResourceRequestDTO updatedResource) {
        return resourceService.updateResource(id,updatedResource);
    }

    @DeleteMapping("/resources/{id}")
    public void deleteResource(@PathVariable Long id) {
        resourceRepository.deleteById(id);
    }
}
