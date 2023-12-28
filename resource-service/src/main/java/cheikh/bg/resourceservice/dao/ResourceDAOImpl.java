package cheikh.bg.resourceservice.dao;

import cheikh.bg.resourceservice.entities.Resource;
import cheikh.bg.resourceservice.repository.ResourceRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ResourceDAOImpl implements ResourceDAO {

    private  ResourceRepository resourceRepository;

    public ResourceDAOImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public Resource getResourceById(Long resourceId) {
        return resourceRepository.findById(resourceId).orElse(null);
    }

    @Override
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    @Override
    public void createResource(Resource resource) {
        resourceRepository.save(resource);
    }

    @Override
    public void updateResource(Resource resource) {
        resourceRepository.save(resource);
    }

    @Override
    public void deleteResource(Long resourceId) {
        resourceRepository.deleteById(resourceId);
    }
}
