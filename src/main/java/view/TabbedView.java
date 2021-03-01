package view;

import dto.ElementDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Named
@SessionScoped
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TabbedView implements Serializable {

    @Inject
    private ApplicationDataBean bean;

    private List<ElementDTO> elements;

    @Inject
    private Event<ElementDTO> selectedEvent;

    @PostConstruct
    public void init() {
        elements = new ArrayList<>();
    }

    public void addElementToList(ElementDTO elementDTO) {
        selectedEvent.fire(elementDTO);
        if (!elements.contains(elementDTO)) {
            elements.add(elementDTO);
        }
    }

    public void onTabClose(TabCloseEvent<ElementDTO> event) {
        elements.remove(event.getData());
        FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getTab().getTitle());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onTabChange(TabChangeEvent<ElementDTO> event) {
        selectedEvent.fire(event.getData());
    }

    public Integer indexCurrentElement() {
        if (Objects.isNull(elements)) {
            return 0;
        }
        return elements.indexOf(bean.getSelectedTab());
    }
}
