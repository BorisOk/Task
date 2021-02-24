package complete;

import interfaces.IIsCompleteElement;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseCompleter<T extends IIsCompleteElement> {

    abstract List<T> childrenData(Integer id);

    abstract T element(Integer id);

    abstract T rootElement();


    public List<T> allElements() {
        List<T> allElements = new ArrayList<>();
        T rootElement = rootElement();
        allElements.add(rootElement);
        collectChildrenElements(rootElement, allElements);
        return allElements;
    }


    protected void collectChildrenElements(T rootElement, List<T> allChildren) {
        if (rootElement.getFolder()) {
            List<T> childrenByRoot = childrenData(rootElement.getId());
            for (T elementDTO : childrenByRoot) {
                T children = element(elementDTO.getId());
                allChildren.add(children);
                if (children.getFolder()) {
                    collectChildrenElements(children, allChildren);
                }
            }
        }
    }
}
