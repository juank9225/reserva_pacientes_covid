package co.com.reto.covid.usecases.reservahabitacion;

public interface SenderEmailService {
    void sendEmail(String email, String contet_body);
}
