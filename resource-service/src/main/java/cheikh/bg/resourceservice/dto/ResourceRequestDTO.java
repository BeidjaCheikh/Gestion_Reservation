package cheikh.bg.resourceservice.dto;

import cheikh.bg.resourceservice.enums.TypeResource;
import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor @Builder @ToString

public class ResourceRequestDTO {
    private String name;
    private TypeResource typeResource;
}
