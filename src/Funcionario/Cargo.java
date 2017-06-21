package Funcionario;

public enum Cargo {
	GERENTE(1),
	VENDEDOR(2);
	
	private int id;

	Cargo(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
