package mateus.senior.livraria.model.exceptions;

public class LivroNotFoundException extends RuntimeException {

	public LivroNotFoundException(String msg) {
		super(msg);
	}
}
