package view;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.TreeNode;
import tree.TreeNodeBuilder;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("treeIconView")
@ApplicationScoped
@Getter
@Setter
public class IconView {
    @Inject
    private TreeNodeBuilder treeNodeBuilder;

    @Inject
    private TabbedView tabbedView;

    private TreeNode root;

    @PostConstruct
    public void init() {
        root = treeNodeBuilder.completeTreNode();
    }
}
