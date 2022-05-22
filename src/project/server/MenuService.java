package project.server;

import project.server.domain.enums.Menu;

import java.util.Map;

public class MenuService {

    public Map<String, String> getGlobalMenu() {
        return Menu.list();
    }

}
