package life.kou.community.mapper;

import life.kou.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modify) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModify})")
    void insert(User user);
}
