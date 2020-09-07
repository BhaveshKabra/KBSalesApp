package org.bhavesh.kbsales.mapper;

import java.util.List;

import org.bhavesh.kbsales.bean.User;
import org.bhavesh.kbsales.bean.pojo.UserPOJO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
	public User userPOJOtoUser(UserPOJO userpojo);
	public UserPOJO usertoUserPOJO(User userpojo);
	public List<User> userPOJOtoUser(List<UserPOJO> userpojolist);
	public List<UserPOJO> usertoUserPOJO(List<User> userlist);
}
