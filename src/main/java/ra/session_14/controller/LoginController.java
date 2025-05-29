package ra.session_14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ra.session_14.model.User;
import ra.session_14.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private final UserService userService = new UserService();

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, Model model, HttpSession session) {
        if (userService.loginValidate(user)) {
            session.setAttribute("loggedInUser", user.getUsername());
            return "redirect:/welcome";
        } else {
            model.addAttribute("error", "Tên người dùng hoặc mật khẩu không đúng.");
            return "login";
        }
    }

    @GetMapping("/welcome")
    public String welcome(HttpSession session, Model model) {
        String username = (String) session.getAttribute("loggedInUser");
        if (username == null) {
            return "redirect:/login";
        }
        model.addAttribute("username", username);
        return "welcome";
    }
}
