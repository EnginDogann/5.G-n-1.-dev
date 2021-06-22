package core.MailCheck;

import entities.concretes.User;

public interface MailCheckService {
	boolean regexMailCheck(User user);
	public boolean sendVerificationEmail(User user);

}
