package view;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
@Getter
@Setter
public class ContentButtonView {

    @Inject
    private ApplicationDataBean applicationDataBean;

    public void openDialog() {
        PrimeFaces.current().executeScript("PF('dlg').show()");
    }

}
