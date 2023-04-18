package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.UserDao;
import web.dao.UserDaoImpl;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserDaoImpl userDaoImpl;
    @Autowired
    public UsersController(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @GetMapping("/all")
    public String getUsers(Model model){
        model.addAttribute("allUsers",userDaoImpl.getAllUsers());
        return "allUsers";
    }
    @GetMapping()
    public String getUsers(@RequestParam long id, Model model){
        //Получим одного пользователя из дао по id и передадим на отображение в представление
        model.addAttribute("UserById",userDaoImpl.getUserById(id));
        return "UserById";
    }
}
