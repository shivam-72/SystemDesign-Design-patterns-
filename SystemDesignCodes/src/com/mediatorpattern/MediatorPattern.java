package com.mediatorpattern;

import java.util.ArrayList;
import java.util.List;

interface ChatMediator {
	void sendMessage(String msg, User rec);

	void addUser(User user);
}

class ChatRoom implements ChatMediator {

	private List<User> users;

	public ChatRoom() {

		users = new ArrayList<>();
	}

	@Override
	public void sendMessage(String msg, User sender) {
		// TODO Auto-generated method stub
		for (User user : users) {
			if (user != sender)
				user.receiveMessage(msg, sender);
		}
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		users.add(user);
	}

}

class User {
	private String name;
	private ChatMediator chatMediator;

	public User(String name, ChatMediator chatMediator) {
		this.name = name;
		this.chatMediator = chatMediator;
	}

	public void sendMessage(String msg) {
		chatMediator.sendMessage(msg, this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void receiveMessage(String msg, User sender) {
		System.out.println(this.name + " received message " + msg + " from " + sender.getName());
	}

}

public class MediatorPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// here we are designing a group chat feature every user mst know about every
		// other user creating
		// a complex web of communication and dependency
//       User shivam=new User("shivam");
//       User shubham=new User("Shubham");
//       User rohan=new User("rohan");
//       shivam.SendMessage("Hi", shubham);
//       shivam.SendMessage("hello", rohan);
		ChatRoom chatRoom = new ChatRoom();
		User shivam = new User("shivam", chatRoom);
		User shubham = new User("Shubham", chatRoom);
		User rohan = new User("rohan", chatRoom);
		chatRoom.addUser(rohan);
		chatRoom.addUser(shubham);
		chatRoom.addUser(shivam);

		shivam.sendMessage("i interviwed ");
	}

}
