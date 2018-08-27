package com.mutualfriendsapplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutualfriendsapplication.dao.intf.MutualFriendDAO;
import com.mutualfriendsapplication.model.User;
import com.mutualfriendsapplication.model.UserEmails;
import com.mutualfriendsapplication.service.intf.MutualFriendService;

@Service
public class MutualFriendServiceImpl implements MutualFriendService {

	@Autowired
	MutualFriendDAO mutualFriendDAO;
	
	@Override
	public List<User> findMutualFriends(UserEmails userEmails) {
		return mutualFriendDAO.findMutualFriends(userEmails);
	}
	
}
