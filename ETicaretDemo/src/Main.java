

import java.util.Scanner;


import business.abstracts.UserService;
import business.concretes.UserManager;
import core.GoogleRegisterAdapter;
import core.MailCheck.MailCheckManager;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;
import entities.concretes.UserList;

public class Main {

	public static void main(String[] args) {
		Scanner giriniz = new Scanner(System.in);
		
		UserList userList = new UserList();
		
		UserService userService = new UserManager(new HibernateUserDao(userList),new GoogleRegisterAdapter()
				,new MailCheckManager());
		
		User user1 = new User();
		System.out.print("Ýsminizi Giriniz: ");
		
		user1.setFirstName(giriniz.next());

		System.out.print("Soyadýnýzý Giriniz: ");
		user1.setLastName(giriniz.next());
				
		System.out.print("E-posta giriniz: ");
		user1.setEmail(giriniz.next());
			
		System.out.print("Þifrenizi giriniz:");
		user1.setPassword(giriniz.next());
		
		User user2 = new User();
		System.out.print("Ýsminizi Giriniz: ");
		
		user2.setFirstName(giriniz.next());

		System.out.print("Soyadýnýzý Giriniz: ");
		user2.setLastName(giriniz.next());
				
		System.out.print("E-posta giriniz: ");
		user2.setEmail(giriniz.next());
			
		System.out.print("Þifrenizi giriniz:");
		user2.setPassword(giriniz.next());
		
		User user3 = new User();
		System.out.print("Ýsminizi Giriniz: ");
		
		user3.setFirstName(giriniz.next());

		System.out.print("Soyadýnýzý Giriniz: ");
		user3.setLastName(giriniz.next());
				
		System.out.print("E-posta giriniz: ");
		user3.setEmail(giriniz.next());
			
		System.out.print("Þifrenizi giriniz:");
		user3.setPassword(giriniz.next());
		
		
		
		
		userService.register(user1);
		userService.signIn(user1.getEmail(), user1.getPassword());
		
		System.out.println("***************");
		
		userService.register(user2);
		userService.signIn(user2.getEmail(), user2.getPassword());
		
		System.out.println("***************");
		
		userService.register(user3);
		userService.signIn(user3.getEmail(), user3.getPassword());
		
		
	
			
	}

}
