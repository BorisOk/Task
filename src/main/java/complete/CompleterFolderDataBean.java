package complete;

import api.FolderDataAPI;
import dto.ElementDTO;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class CompleterFolderDataBean extends BaseCompleter<ElementDTO> {

    @RestClient
    @Inject
    private FolderDataAPI folderDataAPI;

    @Override
    List<ElementDTO> childrenData(Integer id) {
        return folderDataAPI.childrenData(id);
    }

    @Override
    ElementDTO element(Integer id) {
        return folderDataAPI.element(id);
    }

    ElementDTO rootElement() {
        ElementDTO rootElement = folderDataAPI.rootData();
        if (Objects.isNull(rootElement)) {
            throw new RuntimeException("Проблена на сервере");
        }
        return rootElement;
    }
}
