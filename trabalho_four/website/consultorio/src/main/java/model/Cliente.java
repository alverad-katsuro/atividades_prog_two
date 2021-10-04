package model;

public class Cliente extends Pessoa{
	protected String plano;
	final int idclient;
	
	public Cliente(String nome, String cpf, String telefone, String email, boolean sexo, int idade, String pais,
			String estado, String cidade, String bairro, String rua, String numero, String complemento, int idclient) {
		super(nome, cpf, telefone, email, sexo, idade, pais, estado, cidade, bairro, rua, numero, complemento);
		this.idclient = idclient;
	}


	
	
}
