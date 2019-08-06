package life.kou.community.dto;

import lombok.Data;

/*需要获取git用户信息*/
@Data
public class GithubUser {
    private Long id;
    private String name;
    private String bio;
    private String avatarUrl;
}
