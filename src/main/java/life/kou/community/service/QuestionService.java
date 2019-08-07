package life.kou.community.service;

import life.kou.community.dto.QuestionDTO;
import life.kou.community.mapper.QuestionMapper;
import life.kou.community.mapper.UserMapper;
import life.kou.community.model.Question;
import life.kou.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;


    public List<QuestionDTO> list() {
        //获取question列表
        List<Question> questionList = questionMapper.list();
        List<QuestionDTO> questionDTOList = new ArrayList<QuestionDTO>();
        for (Question question : questionList) {
            //通过creatorID获取用户信息
            User user =  userMapper.findById(question.getCreator());
            //BeanUtils.copyProperties传输信息到questionDTO,并将user信息传入questionDTO
                QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
