package cheikh.bg.resourceservice.dto;

import cheikh.bg.resourceservice.enums.TypeResource;
import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor @Builder @ToString

public class ResourceResponceDTO {
    private Long id;
    private String name;
    private TypeResource typeResource;
}
