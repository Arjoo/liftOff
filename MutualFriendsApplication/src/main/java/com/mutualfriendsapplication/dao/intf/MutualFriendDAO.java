package com.mutualfriendsapplication.dao.intf;

import java.util.List;

import com.mutualfriendsapplication.model.User;
import com.mutualfriendsapplication.model.UserEmails;

public interface MutualFriendDAO {

	List<User> findMutualFriends(UserEmails userEmails);

}
