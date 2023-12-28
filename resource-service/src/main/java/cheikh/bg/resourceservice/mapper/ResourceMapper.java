package cheikh.bg.resourceservice.mapper;

import cheikh.bg.resourceservice.dto.ResourceRequestDTO;
import cheikh.bg.resourceservice.dto.ResourceResponceDTO;
import cheikh.bg.resourceservice.entities.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ResourceMapper {
    public ResourceResponceDTO fromResource(Resource resource){
        ResourceResponceDTO resourceResponceDTO =new ResourceResponceDTO();
        BeanUtils.copyProperties(resource,resourceResponceDTO);
        return resourceResponceDTO;
    }
    public Resource toResource(ResourceRequestDTO resourceRequestDTO) {
        Resource resource = new Resource();
        BeanUtils.copyProperties(resourceRequestDTO, resource);
        return resource;
    }
}
