package com.bridgelabz.mongo.serviceprovider;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.mongo.model.UserModel;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;

public class UserServiceImpl implements UserService{

	@Override
	public void register(MongoCollection<UserModel> collection, long id, String userName, String email, long phoneNumber, String city) {
		UserModel userModel = new UserModel();
		userModel.setId(id);
		userModel.setUserName(userName);
		userModel.setEmail(email);
		userModel.setPhoneNumber(phoneNumber);
		userModel.setCity(city);
		
		collection.insertOne(userModel);
		System.out.println("Successfully inserted");
	}

	@Override
	public List<UserModel> getDetails(MongoCollection<UserModel> userModelCollection) {
		FindIterable<UserModel> iterable = userModelCollection.find();
		MongoCursor<UserModel> cursor = iterable.cursor();
		List<UserModel> list = new ArrayList<>();
		
		while(cursor.hasNext()) {
			UserModel userModel = cursor.next();
			list.add(userModel);
		}
		System.out.println("Successfully read");
		return list;
	}

	@Override
	public void updateByID(MongoCollection<UserModel> collection, String newUserName, long id) {
		FindIterable<UserModel> iterable = collection.find();
		MongoCursor<UserModel> cursor = iterable.cursor();
		while(cursor.next().getId() == id)
			cursor.next();
		UserModel model = cursor.next();
		model.setUserName(newUserName);
		System.out.println("Successfully Replaced");
		System.out.println(model);
	}

	@Override
	public void deleteDetails(MongoCollection<UserModel> collection, String userName) {
		collection.deleteOne(eq("userName", userName));
	}
	
	public static UserServiceImpl getInstance(){
		if(impl == null)
			impl = new UserServiceProviderImpl();
		return impl;
	}

}
