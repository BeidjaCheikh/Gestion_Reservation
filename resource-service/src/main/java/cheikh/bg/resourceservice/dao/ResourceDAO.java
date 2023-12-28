package cheikh.bg.resourceservice.dao;

import cheikh.bg.resourceservice.entities.Resource;

import java.util.List;

public interface ResourceDAO {
    Resource getResourceById(Long resourceId);
    List<Resource> getAllResources();
    void createResource(Resource resource);
    void updateResource(Resource resource);
    void deleteResource(Long resourceId);
}
