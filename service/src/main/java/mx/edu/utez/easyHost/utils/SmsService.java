package mx.edu.utez.easyHost.utils;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;


@RestController
public class SmsService {

    @Value("${TWILIO_ACCOUNT_SID}")
    String sid;
    @Value("${TWILIO_AUTH_TOKEN}")
    String token;
    @Value("${TWILIO_NUMBER}")
    String phoneNumber;

    @GetMapping(value = "/codigoVerificacion")
    public ResponseEntity<String> sendSMS() {

        Twilio.init(sid, token);

        String codigoVerificacion = generarCodigo();

        Message.creator(
                new PhoneNumber("+527271083065"),
                new PhoneNumber(phoneNumber),
                "Tu codigo de verificacion para EasyHost es: " + codigoVerificacion + " no lo compartas con nadie fuera de la plataforma"
        ).create();

        return new ResponseEntity<String>("Mensaje enviado correctamente el codigo es " + codigoVerificacion, HttpStatus.OK);


    }

    //Generar codigo aleatorio
    private static String generarCodigo() {
        Random random = new Random();
        int code = 10000 + random.nextInt(90000);
        return String.valueOf(code);
    }
}
