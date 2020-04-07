package com.bridgelabz.mongo.controller;

import com.bridgelabz.mongo.configuration.MongoDBConfiguration;
import com.bridgelabz.mongo.model.UserModel;
import com.bridgelabz.mongo.serviceprovider.UserServiceImpl;
import com.bridgelabz.mongo.utils.InputUtility;
import com.mongodb.MongoClient;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class UserController {
	static MongoCollection<UserModel> collection;
	static MongoClient mongoClient;
	static MongoDatabase database;
	static MongoDBConfiguration configuration;

	public static void main(String[] args) {
		configuration = new MongoDBConfiguration();
		mongoClient = MongoDBConfiguration.getInstance();
		database = configuration.getDatabase("mongoDBCRUD");
		collection = database.getCollection("user", UserModel.class);
		UserServiceImpl impl = new UserServiceImpl();
		

		boolean exit = false;

		while (!exit) {
			System.out.println("Choose your option");
			System.out.println("\n1.insert details "
					+ "\n2.read "
					+ "\n3.update "
					+ "\n4.delete "
					+ "\n5.exit");
			int choice = InputUtility.intVal();
			
			switch (choice) {
			case 1:
				System.out.println("Enter ID");
				int id = InputUtility.intVal();
				System.out.println("Enter user name");
				String userName = InputUtility.stringVal();
				System.out.println("Enter email ");
				String email = InputUtility.stringVal();
				System.out.println("Enter phone number");
				long phoneNumber = InputUtility.longVal();
				System.out.println("Enter c");
				String city = InputUtility.stringVal();

				impl.insertIntoMongoDB(collection, id, userName, email, phoneNumber, city);
				break;

			case 2:
				System.out.println(impl.readFromMongoDB(collection));
				break;

			case 3:
				System.out.println("Enter ID whose user name you want to change");
				int id1 = InputUtility.intVal();
				System.out.println("Enter new user name");
				String newUserName = InputUtility.stringVal();
				impl.updateMongoDB(collection, newUserName, id1);
				break;

			case 4:
				System.out.println("Enter old user name");
				String userNameDelete = InputUtility.stringVal();
				impl.deleteDetails(collection, userNameDelete);
				break;
			case 5:
				System.out.println("Successfully exited");
				exit = true;
				break;
			default:
				System.out.println("Invalid Entry");
			}
		}
	}
}