package view;

import dto.ElementDTO;
import lombok.Getter;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class ApplicationDataBean {
    @Getter
    private ElementDTO selectedTab;

    public void setSelectedTab(@Observes ElementDTO selectedTab) {
        this.selectedTab = selectedTab;
    }
}
