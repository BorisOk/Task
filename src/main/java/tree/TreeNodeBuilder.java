package tree;

import complete.CompleterFolderDataBean;
import dto.ElementDTO;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Named
@ApplicationScoped
public class TreeNodeBuilder {

    @Inject
    private CompleterFolderDataBean completerData;

    public TreeNode completeTreNode() {
        List<ElementDTO> allElements = completerData.allElements();
        ElementDTO rootElement = rootElement(allElements);
        TreeNode rootNode = new DefaultTreeNode(rootElement, null);
        fillNodeData(rootElement, allElements, rootNode);
        return rootNode;
    }

    private void fillNodeData(ElementDTO rootElement, List<ElementDTO> allElements, TreeNode roteNode) {
        List<ElementDTO> childrenElementDTO = childrenElementDTO(allElements, rootElement);
        for (ElementDTO elementDTO : childrenElementDTO) {
            TreeNode treeNode = treeNodeByElementDto(elementDTO, roteNode);
            if (elementDTO.getFolder()) {
                fillNodeData(elementDTO, allElements, treeNode);
            }
        }
    }

    private List<ElementDTO> childrenElementDTO(List<ElementDTO> allElements, ElementDTO root) {
        return allElements
                .stream()
                .filter(elementDTO -> Objects.nonNull(elementDTO.getParent()))
                .filter(elementDTO -> elementDTO.getParent().equals(root.getId()))
                .collect(Collectors.toList());
    }


    private ElementDTO rootElement(List<ElementDTO> allElements) {
        return allElements
                .stream()
                .filter(elementDTO -> Objects.isNull(elementDTO.getParent()))
                .findFirst().orElseGet(() -> {
                    throw new RuntimeException("Корневая папка не найдена");
                });
    }

    private TreeNode treeNodeByElementDto(ElementDTO elementDTO, TreeNode rootTreNode) {
        return new DefaultTreeNode(elementDTO.getFolder() ? "folder" : "file", elementDTO, rootTreNode);
    }
}
