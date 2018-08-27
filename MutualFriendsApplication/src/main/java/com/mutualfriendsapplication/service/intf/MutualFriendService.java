package com.mutualfriendsapplication.service.intf;

import java.util.List;

import com.mutualfriendsapplication.model.User;
import com.mutualfriendsapplication.model.UserEmails;

public interface MutualFriendService {

	List<User> findMutualFriends(UserEmails userEmails);

}
