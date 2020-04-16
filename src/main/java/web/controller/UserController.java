package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String printUsers(ModelMap model){
        model.addAttribute("users", userService.listOfUsers());
        return "users";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteUser(@RequestParam("id") Long id){
        userService.deleteUser(id);
        return "users";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(ModelMap model,@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName ){
        userService.addUser(firstName, lastName);
        model.addAttribute("users", userService.listOfUsers());
        return "users";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(ModelMap model, HttpServletRequest request){
        HttpSession session = request.getSession();
        if (request.getParameter("id") != null){
            session.setAttribute("id", Long.parseLong(request.getParameter("id")));
            session.setAttribute("isVisible", true);
        }
        else {
            userService.editUser((Long) session.getAttribute("id"), request.getParameter("newFirstName"), request.getParameter("newLastName"));
            model.addAttribute("users", userService.listOfUsers());
            session.removeAttribute("id");
            session.removeAttribute("isVisible");
        }
        return "users";
    }
}
