package ra.session_14.service;

import ra.session_14.model.User;

public class UserServiceB1 {
    public boolean loginValidate(User user) {
        return "DinhDuong".equals(user.getUsername()) && "13012005".equals(user.getPassword());
    }
}
