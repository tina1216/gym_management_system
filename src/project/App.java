package project;

import project.client.MockClient;
import project.server.auth.Context;

import java.util.logging.Logger;

public class App {

    public static MockClient mock = new MockClient();
    public static Logger LOG = Logger.getLogger("App.class");

    public static void main(String[] args) {
        mock.login();
        while (true) {
            try {
                if (Context.getInstance().getCurrentUser() == null) {
                    mock.login();
                }
                mock.showGlobalMenu();
            } catch (Exception e) {
                e.printStackTrace();
                LOG.warning("forced logout");
                mock.login();
            }
        }
    }
}
