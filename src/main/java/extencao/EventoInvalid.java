package extencao;

import java.io.Serial;

public class EventoInvalid extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    // Construtor da exceção MotoristaInvalid, que recebe uma mensagem como argumento.
   

	public EventoInvalid(String msg) {
        super(msg);
    }
}
