package view;

import lombok.Getter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
@Getter
public class DataTabView {

    @Inject
    private ApplicationDataBean applicationDataBean;

}
