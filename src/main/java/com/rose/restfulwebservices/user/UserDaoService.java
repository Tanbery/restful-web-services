package com.rose.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users= new ArrayList<>();
	private static int userCount=3;
	static {
		users.add(new User(1,"Enver",new Date()));
		users.add(new User(2,"Simru",new Date()));
		users.add(new User(3,"Denem",new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User usr) {
		if (usr.getId()==null)
			usr.setId(++userCount);
		users.add(usr);
		return usr;
	}
	
	public User findOne(int id) {
		for(User u:users) {
			if(u.getId()==id)
				return u;
		}
		return null;
	}
	
	public Boolean delete(int id) {
		for(User u:users) {
			if(u.getId()==id)
			{
				return users.remove(u);
			}
		}
		return false;
	}
}
