package org.bhavesh.kbsales.repository;

import org.bhavesh.kbsales.bean.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
	/*
	@Query(value="select u from User u left join fetch u.authorities where u.name=:name")
	User findByUsername(@Param("name")String name);
	
	@Query(value="select u from User u left join fetch u.authorities where u.name=:name and u.password=:password")
	User checkCredentials(@Param("name") String name, @Param("password")String password);
	
	@Query(value="select u from User u left join fetch u.authorities")
	List<User> findAllUsername();
	
	@Transactional
	@Modifying
	@Query(value = "insert into user(name,password) values(:name,:password)", nativeQuery = true)
	void save(@Param("name")String name, @Param("password")String password);
	
	@Transactional
	@Modifying
	@Query(value = "update user set password=:password where name=:name", nativeQuery = true)
	void update(@Param("name")String username, @Param("password")String password);
	*/
}
