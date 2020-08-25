package org.bhavesh.kbsales.repository;

import org.bhavesh.kbsales.bean.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}
