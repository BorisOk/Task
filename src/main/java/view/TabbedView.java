package view;

import dto.ElementDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.primefaces.event.TabCloseEvent;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Named
@ApplicationScoped
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TabbedView {

    private ElementDTO selected;

    private List<ElementDTO> elements;

    @PostConstruct
    public void init() {
        elements = new ArrayList<>();
    }

    public void addElementToList(ElementDTO elementDTO) {
        selected = elementDTO;
        if (!elements.contains(elementDTO)) {
            elements.add(elementDTO);
        }
    }

    public void onTabClose(TabCloseEvent<ElementDTO> event) {
        elements.remove(event.getData());
        FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public Integer indexLastElement() {
        if (Objects.isNull(elements)) {
            return 0;
        }
        return elements.indexOf(selected);

    }
}
