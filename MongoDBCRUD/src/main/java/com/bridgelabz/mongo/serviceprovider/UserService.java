package com.bridgelabz.mongo.serviceprovider;

import java.util.List;

import com.bridgelabz.mongo.model.UserModel;
import com.mongodb.client.MongoCollection;

public interface UserService {
	public void insertIntoMongoDB(MongoCollection<UserModel> collection, int id, String userName, String email, long phoneNumber, String city);
	public List<UserModel> readFromMongoDB(MongoCollection<UserModel> userModel);
	public void updateMongoDB(MongoCollection<UserModel> collection, String newUserName, int id);
	public void deleteDetails(MongoCollection<UserModel> collection, String userName);
}
