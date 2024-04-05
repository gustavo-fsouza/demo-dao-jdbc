package db;

// quando tento apagar uma linha que esta vinculada a outra linha de 
// outra tabela, o banco da esse erro de integridade, para nao deixar
// uma linha sem referencia
public class DbIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DbIntegrityException(String msg) {
		super(msg);
	}
}
