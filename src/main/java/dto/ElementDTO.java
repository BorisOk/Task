package dto;

import interfaces.IIsCompleteElement;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString(of = {"name"})
public class ElementDTO implements Serializable, IIsCompleteElement {
    private Integer id;
    private String name;
    private String content;
    private Boolean folder;
    private Integer parent;
}
