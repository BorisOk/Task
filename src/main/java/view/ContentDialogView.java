package view;

import lombok.Getter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class ContentDialogView {

    @Getter
    @Inject
    private ApplicationDataBean applicationDataBean;

}
