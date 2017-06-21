package Usuario;

public class Extrato {
	private String data;
	private String hora;
	private String operacao;
	private int saldo_qtd;
	private float saldo_dinheiro;
	
	
	
	
	public Extrato(String data, String hora, String operacao, int saldo_qtd, float saldo_dinheiro) {
		super();
		this.data = data;
		this.hora = hora;
		this.operacao = operacao;
		this.saldo_qtd = saldo_qtd;
		this.saldo_dinheiro = saldo_dinheiro;
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
	public int getSaldoQtd() {
		return saldo_qtd;
	}
	public void setSaldoQtd(int quantidade) {
		this.saldo_qtd = quantidade;
	}
	public float getSaldoDinheiro() {
		return saldo_dinheiro;
	}
	public void setSaldoDinheiro(float saldo) {
		this.saldo_dinheiro = saldo;
	}
	@Override
	public String toString() {
	// TODO Auto-generated method stub
		return "data = "+ getData()+" Hora : "+getHora() +"  operacao: "+getOperacao()+" saldoqtd: "+getSaldoQtd()+" saldoDin "+getSaldoDinheiro();
	}
}
