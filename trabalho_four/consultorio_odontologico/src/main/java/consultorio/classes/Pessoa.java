package consultorio.classes;

import consultorio.classes.Enum.Sexo;

public abstract class Pessoa extends Endereco_Abstract {
	protected String nome;
	protected String cpf;
	protected String telefone;
	protected String email;
	protected Sexo sexo;
	protected int idade;
	
	public Pessoa(String nome, String cpf, String telefone, String email, String sexo,
			int idade, String pais, String estado, String cidade, String bairro, String rua, String numero,
			String complemento) {
		super(pais, estado, cidade, bairro, rua, numero, complemento);
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.sexo = comparaSexo(sexo.toUpperCase());
		this.idade = idade;
	}

	public Pessoa(String endereco, String nome, String cpf, String telefone, String email, String sexo, int idade) {
		super(endereco);
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.sexo = comparaSexo(sexo.toUpperCase());
		this.idade = idade;
	}

	public static void describe(Pessoa pessoa) {
		pessoa.infoBasic();
	}

	public abstract void infoBasic();
	
	public String getNome() {
		return nome;
	}
	protected void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	protected void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	protected void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	protected void setEmail(String email) {
		this.email = email;
	}
	public Sexo getSexo() {
		return sexo;
	}
	protected void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public int getIdade() {
		return idade;
	}
	protected void setIdade(int idade) {
		this.idade = idade;
	}

	public static Sexo comparaSexo(String sexo){
		switch (sexo) {
			case "MASCULINO":
				return Sexo.MASCULINO;
			case "FEMININO":
				return Sexo.FEMININO;
		}
		return null;
	}
}
