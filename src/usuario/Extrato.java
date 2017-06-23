package Usuario;

public class Extrato {
	private String data;
	private String hora;
	private String operacao;
	private int saldo;
	
	
	public Extrato(String data, String hora, String operacao, int saldo) {
		super();
		this.data = data;
		this.hora = hora;
		this.operacao = operacao;
		this.saldo = saldo;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int quantidade) {
		this.saldo = quantidade;
	}

	@Override
	public String toString() {
	// TODO Auto-generated method stub
		return "data = "+ getData()+" Hora : "+getHora() +"  operacao: "+getOperacao()+" saldoqtd: "+getSaldo();
	}
}
