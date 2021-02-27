package view;

import dto.ElementDTO;
import interfaces.ReturningContent;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
@Getter
@Setter
public class ButtonPressView implements ReturningContent<ElementDTO> {

    private static ElementDTO selected;

    public String content(ElementDTO elementDTO) {
        selected = elementDTO;
        return selected.getContent();
    }

    public void addMessage() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, null, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
