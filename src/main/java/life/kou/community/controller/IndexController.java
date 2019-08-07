package life.kou.community.controller;

import life.kou.community.dto.QuestionDTO;
import life.kou.community.mapper.UserMapper;
import life.kou.community.model.User;
import life.kou.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
        //获取用户cookies
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if("token".equals(cookie.getName())){
                    String token = cookie.getValue();
                    //判断用户登陆状态 通过：token判断
                    User user = userMapper.findByToken(token);
                    if(user != null){
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
    }
        //展示question列表
        List<QuestionDTO> questionDtoList = questionService.list();
        model.addAttribute("questions",questionDtoList);
        return "index";
    }
}
