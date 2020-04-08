package com.bridgelabz.mongo.serviceprovider;

import java.util.List;

import com.bridgelabz.mongo.model.UserModel;
import com.mongodb.client.MongoCollection;

public interface UserService {
	public void register(MongoCollection<UserModel> collection, long id, String userName, String email, long phoneNumber, String city);
	public List<UserModel> getDetails(MongoCollection<UserModel> userModel);
	public void updateByID(MongoCollection<UserModel> collection, String newUserName, long id);
	public void deleteDetails(MongoCollection<UserModel> collection, String userName);
}
