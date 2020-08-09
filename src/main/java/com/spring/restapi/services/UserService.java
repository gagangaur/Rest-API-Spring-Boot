package com.spring.restapi.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;


import com.spring.restapi.entities.User;

@Service
public class UserService {
	
		private List<User> userEntity = new ArrayList<>(Arrays.asList(
				new User("1","ABC","Java"),
				new User("2","DEF","Python"),
				new User("3","GHI","C"),
				new User("4","JKL","C++")
			));
		
		public List<User> getAllUsers() {
			return userEntity;
		}
		
		public User getUser(String id) {
			return userEntity.stream()
					.filter(e->e.getId().equals(id))
					.findFirst()
					.get();
		}
		
		public void addUser(User user) {
			userEntity.add(user);
		}
		
		public void updateUser(User user,String id) {
			for(int i=0;i<userEntity.size();i++) {
				if(userEntity.get(i).getId().equals(id)) {
					userEntity.set(i, user);
					return;
				}
			}
		}
		
		public void deleteUser(String id) {
			userEntity.removeIf(user->user.getId().equals(id));
		}
}
