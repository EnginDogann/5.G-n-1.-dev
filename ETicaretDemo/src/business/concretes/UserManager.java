package business.concretes;

import business.abstracts.UserService;
import core.GoogleRegisterService;
import core.MailCheck.MailCheckService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService{
	
	private UserDao userDao;
	private GoogleRegisterService googleRegisterService;
	private MailCheckService mailCheckService;
	
	public UserManager(UserDao userDao, GoogleRegisterService googleRegisterService, MailCheckService mailCheckService) {
		super();
		this.userDao = userDao;
		this.googleRegisterService = googleRegisterService;
		this.mailCheckService = mailCheckService;
		
	}
	


	@Override
	public void register(User user) {
		
		if(user.getFirstName().length()<2 || user.getLastName().length()<2) {
			System.out.println("Ýsim ve Soyisim 2 karakterden az olamaz");
			return;
		}
		if(user.getPassword().length()<6) {
			System.out.println("Parola 6 karakterden az olamaz");
			return;
		}
		
		if(!mailCheckService.regexMailCheck(user)) {
			System.out.println("Geçersiz e-posta adresi...");
			return;
		}
		if(!mailCheckService.sendVerificationEmail(user)) {
			System.out.println("E-posta doðrulanamadý...");
			return;
		}
		for (User customer: userDao.getAll()) {
			if(customer.getEmail()== user.getEmail()){
				System.out.println("Bu e-posta adresi daha önce kullanýlmýþ...");
				return;
			}
		}
		this.userDao.add(user);
		System.out.println("E-posta adresi doðrulandý ve kullanýcý kaydedildi...");
		
	}
	
	@Override
	public void signIn(String email, String password) {
		
		for (User customer: userDao.getAll()) {
			if(customer.getEmail()== email && customer.getPassword() == password){
				System.out.println("Giriþ Baþarýlý :" + customer.getFirstName()+" "+ customer.getLastName());
				return;
			}
		}
		System.out.println("Oturum açma baþarýsýz.");
		
	}

	

}
