package view;

import dto.ElementDTO;
import interfaces.ReturningContent;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
@Getter
@Setter
public class AreaTwoView implements ReturningContent<ElementDTO> {

    private ElementDTO selected;

    public String content(ElementDTO elementDTO) {
        selected = elementDTO;
        return selected.getContent();
    }
}
