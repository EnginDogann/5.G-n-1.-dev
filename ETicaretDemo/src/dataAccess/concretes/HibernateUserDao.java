package dataAccess.concretes;

import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;
import entities.concretes.UserList;

public class HibernateUserDao implements UserDao{

	private UserList userList;
	
	public HibernateUserDao(entities.concretes.UserList userList) {
		super();
		this.userList = userList;
	}

	@Override
	public void add(User user) {
		System.out.println(user.getFirstName()+" "+user.getLastName()+" : Hibernate ile Kaydedildi");
		userList.userList.add(user);
	}

	@Override
	public void delete(User user) {
		System.out.println(user.getFirstName()+" "+user.getLastName()+" : Hibernate ile Silindi");
		userList.userList.remove(user);
	}

	@Override
	public void update(User user) {
		System.out.println(user.getFirstName()+" "+user.getLastName()+" : Hibernate ile Güncellendi");

	}


	@Override
	public List<User> getAll() {
		
		return userList.userList;
	}

}
