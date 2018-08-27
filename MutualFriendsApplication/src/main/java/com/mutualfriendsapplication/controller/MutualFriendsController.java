package com.mutualfriendsapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mutualfriendsapplication.model.User;
import com.mutualfriendsapplication.model.UserEmails;
import com.mutualfriendsapplication.service.intf.MutualFriendService;

@RestController
@RequestMapping(value="/api/v1")
@CrossOrigin(origins="*")
public class MutualFriendsController {

	@Autowired
	MutualFriendService mutualFriendService;
	
	@RequestMapping(value="/findMutualFriends", method=RequestMethod.POST)
	public List<User> findMutualFriends(@RequestBody UserEmails userEmails) {
		System.out.println(userEmails.getFirstUserEmail());
		System.out.println(userEmails.getSecondUserEmail());
		
		List<User> mutualFriends= mutualFriendService.findMutualFriends(userEmails);
		
		return mutualFriends;
	}
}
