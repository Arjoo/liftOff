package com.mutualfriendsapplication.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mutualfriendsapplication.dao.intf.MutualFriendDAO;
import com.mutualfriendsapplication.model.User;
import com.mutualfriendsapplication.model.UserEmails;

@Repository
public class MutualFriendDAOImpl implements MutualFriendDAO {

	private static Map<String, List<User>> users = new HashMap<>();

	public static Map<String, List<User>> getUsers() {
		return users;
	}

	@Override
	public List<User> findMutualFriends(UserEmails userEmails) {
		sampleData();
		List<User> mutual = new ArrayList<>();
		List<User> user1FriendsList = getUsers().get(userEmails.getFirstUserEmail());
		List<User> user2FriendsList = getUsers().get(userEmails.getSecondUserEmail());

		if (user1FriendsList == null || user2FriendsList == null) {
			return mutual;
		}

		for (User user : user1FriendsList) {
			if (user2FriendsList.contains(user))
				mutual.add(user);
		}
		return mutual;
	}

	private void sampleData() {
		
		//Creating Users
		User arjoo 		= new User(1, "arjoo", "arjoo@gmail.com");
		User bhaibhav 	= new User(2, "bhaibhav", "bhaibhav@gmail.com");
		User chintu 	= new User(3, "chintu", "chintu@gmail.com");
		User dinesh 	= new User(4, "dinesh", "dinesh@gmail.com");
		User ezaz 		= new User(5, "ezaz", "ezaz@gmail.com");
		User faizal 	= new User(6, "faizal", "faizal@gmail.com");
		User gyani 		= new User(7, "gyani", "gyani@gmail.com");

		//Creating arjoo's friends
		addFriend(arjoo, bhaibhav);
		addFriend(arjoo, chintu);
		addFriend(arjoo, gyani);
		addFriend(arjoo, faizal);
		//addFriend(arjoo, ezaz);
		
		//Creating dinesh's friends
		addFriend(dinesh, ezaz);
		addFriend(dinesh, gyani); 		// mutual friend
		addFriend(dinesh, bhaibhav); 	// mutual friend
		addFriend(dinesh, faizal); 		// mutual friend
	}

	private void addFriend(User user, User friend) {
		Map<String, List<User>> users = getUsers();
		List<User> userFriendsList = users.get(user.getEmail());
		if (userFriendsList == null) {
			userFriendsList = new ArrayList<>();
		}

		if (!userFriendsList.contains(friend))
			userFriendsList.add(friend);

		users.put(user.getEmail(), userFriendsList);
	}
}
