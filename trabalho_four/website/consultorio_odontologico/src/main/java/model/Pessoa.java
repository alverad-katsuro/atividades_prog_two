package model;

public class Pessoa extends Endereco_Abstract {
	protected String nome;
	protected String cpf;
	protected String telefone;
	protected String email;
	protected boolean sexo;
	protected int idade;
	
	public Pessoa(String nome, String cpf, String telefone, String email, boolean sexo,
			int idade, String pais, String estado, String cidade, String bairro, String rua, String numero,
			String complemento) {
		super(pais, estado, cidade, bairro, rua, numero, complemento);
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.sexo = sexo;
		this.idade = idade;
	}
	
	protected String getNome() {
		return nome;
	}
	protected void setNome(String nome) {
		this.nome = nome;
	}
	protected String getCpf() {
		return cpf;
	}
	protected void setCpf(String cpf) {
		this.cpf = cpf;
	}
	protected String getTelefone() {
		return telefone;
	}
	protected void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	protected String getEmail() {
		return email;
	}
	protected void setEmail(String email) {
		this.email = email;
	}
	protected boolean isSexo() {
		return sexo;
	}
	protected void setSexo(boolean sexo) {
		this.sexo = sexo;
	}
	protected int getIdade() {
		return idade;
	}
	protected void setIdade(int idade) {
		this.idade = idade;
	}	
}
