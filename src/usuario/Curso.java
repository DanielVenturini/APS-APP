package Usuario;

public enum Curso {
	CIENCIA_DA_COMPUTACAO,
	ENGENHARIA_CIVIL,
	ENGENHARIA_AMBIENTAL,
	ENGENHARIA_ELETRONICA,
	ENGENHARIA_ALIMENTOS,
	TECNOLOGIA_ALIMENTOS,
	PROFESSOR,
	VISITANTE;
	
	public static Curso getById(int id){
		if(id < values().length)
			return values()[id];
		
		return null;
	}
	
	@Override
	public String toString(){
		switch(this.ordinal()){
			case 0:
				return "Ciência da Computação";
			case 1:
				return "Engenharia Civil";
			case 2:
				return "Engenharia Ambiental";
			case 3:
				return "Engenharia Eletrônica";
			case 4:
				return "Engenharia de Alimentos";
			case 5:
				return "Tecnologia de Alimentos";
			case 6:
				return "Professor";
			default:
				return "Visitante";
		}
		
	}
}
