package fams.services.templates;

public interface IEmailService {
    public void sendPasswordResetEmail(String toEmail, String newPassword);
}
