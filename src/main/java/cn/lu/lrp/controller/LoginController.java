package cn.lu.lrp.controller;

import cn.lu.lrp.controller.domain.Result;
import cn.lu.lrp.controller.domain.ResultController;
import cn.lu.lrp.entity.User;
import cn.lu.lrp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @program: cn.lu.lrp.controller.LoginController
 * @author: lull lull@shuto.cn
 * @create: 2021-04-03
 * @version: <p> 2021-04-03 10:20 1、 登录控制器  lull
 **/
@RestController
@RequestMapping
public class LoginController extends ResultController {

    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 登录页
     *
     * @param request
     * @return
     */
    @GetMapping("login")
    public ModelAndView login(HttpServletRequest request) {
        return jumpPage("login");
    }

    @PostMapping(value = "login.do")
    public Result login(HttpSession session, @RequestBody User param, Model model) {
        User user = userService.selectByUsername(param.getUserName());
        if (user != null) {
            session.setAttribute("user", user);
            model.addAttribute("user", user);
            return Result.success("登录成功");
        }
        return Result.failure("用户名或密码错误");
    }

    @PostMapping(value = "logout.do")
    public Result logout(HttpSession session) {
        session.removeAttribute("user");
        return Result.success("注销成功");
    }

    /**
     * 首页
     *
     * @return
     */
    @GetMapping("index")
    public ModelAndView index() {
        return jumpPage("index");
    }

    @GetMapping("main")
    public ModelAndView main() {
        return jumpPage("main");
    }

    /**
     * Describe:无权限页面
     * Return:返回403页面
     */
    @GetMapping("error/403")
    public ModelAndView noPermission() {
        return jumpPage("error/403");
    }

    /**
     * Describe:找不带页面
     * Return:返回404页面
     */
    @GetMapping("error/404")
    public ModelAndView notFound() {
        return jumpPage("error/404");
    }

    /**
     * Describe:异常处理页
     * Return:返回500界面
     */
    @GetMapping("error/500")
    public ModelAndView onException() {
        return jumpPage("error/500");
    }


}
