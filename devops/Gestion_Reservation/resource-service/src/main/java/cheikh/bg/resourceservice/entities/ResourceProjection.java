package cheikh.bg.resourceservice.entities;

import cheikh.bg.resourceservice.enums.TypeResource;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullResource",types = Resource.class)
public interface ResourceProjection {
public Long getId();
public String getName();
public TypeResource getTypeResource();

}
