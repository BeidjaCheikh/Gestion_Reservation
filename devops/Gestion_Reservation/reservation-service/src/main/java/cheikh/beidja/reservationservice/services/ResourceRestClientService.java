package cheikh.beidja.reservationservice.services;
import cheikh.beidja.reservationservice.dto.ResourceResponseDTO;
import cheikh.beidja.reservationservice.model.Resource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "resource-service")
public interface ResourceRestClientService {
    @GetMapping("/api/resources/{id}?projection=fullResource")
    public ResourceResponseDTO resourceById(@PathVariable Long id);
    @GetMapping("/api/resources?projection=fullResource")
    public List<ResourceResponseDTO> allResources();
}
