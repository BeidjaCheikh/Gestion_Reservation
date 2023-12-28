package cheikh.bg.resourceservice.repository;

import cheikh.bg.resourceservice.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface ResourceRepository extends JpaRepository<Resource,Long> {
}
