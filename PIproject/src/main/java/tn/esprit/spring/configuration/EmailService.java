package tn.esprit.spring.configuration;

public interface EmailService {

	public void sendSimpleMessage(
		      String to, String subject, String text);
}
