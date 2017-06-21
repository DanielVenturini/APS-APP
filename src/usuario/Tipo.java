package Usuario;

public enum Tipo {
	ESTUDANTE("1"),
	PROFESSOR("2"),
	VISISTANTE("3");
	
	private String id;

	 Tipo(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
