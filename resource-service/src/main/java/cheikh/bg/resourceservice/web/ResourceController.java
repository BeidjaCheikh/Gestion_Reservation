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
    //@PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/resources")
    public List<ResourceResponceDTO> allResources(){
        return resourceService.getAllResources();
    }

    //@PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/resources/{id}")
    public ResourceResponceDTO getResourceById(@PathVariable Long id) {
        return resourceService.getResourceById(id);
    }

    //@PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/resources/create")
    public ResourceResponceDTO createResource(@RequestBody ResourceRequestDTO resourceRequestDTO) {
        return resourceService.addResource(resourceRequestDTO);
    }
    //@PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/resources/update/{id}")
    public ResourceResponceDTO updateResource(@PathVariable Long id, @RequestBody ResourceRequestDTO updatedResource) {
        return resourceService.updateResource(id,updatedResource);
    }
    //@PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/resources/delete/{id}")
    public void deleteResource(@PathVariable Long id) {
        resourceRepository.deleteById(id);
    }
}
