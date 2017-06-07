package usuario;

public enum Tipo {

    ESTUDANTE("1"),
    PROFESSOR("2"),
    VISITANTE("3");

    private String id;

	    private Tipo(String id){
	        this.id = id;
	    }

    public void setTipo(String id){
    	this.id = id;
    }

    public String getTipo(){
        return id;
    }
}