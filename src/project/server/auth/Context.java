package project.server.auth;

import project.server.domain.dto.UserDto;

public class Context {

    private static final Context instance = new Context();

    private UserDto user;

    private Context() {

    }

    public static Context getInstance() {
        return instance;
    }

    public void init(UserDto user) {
        this.user = user;
    }

    public void reset() {
        this.user = null;
    }

    public UserDto getCurrentUser() {
        return user;
    }
}
