package consultorio.classes;

public class Cliente extends Pessoa{
	protected String plano;
	protected int idclient;
	
	public Cliente(String nome, String cpf, String telefone, String email, String sexo, int idade, String pais,
			String estado, String cidade, String bairro, String rua, String numero, String complemento, String plano) {
		super(nome, cpf, telefone, email, sexo, idade, pais, estado, cidade, bairro, rua, numero, complemento);
		this.plano = plano;
	}

	public Cliente(String endereco, String nome, String cpf, String telefone, String email, String sexo, int idade,
			String plano, int idclient) {
		super(endereco, nome, cpf, telefone, email, sexo, idade);
		this.plano = plano;
		this.idclient = idclient;
	}

	public Cliente(String endereco, String nome, String cpf, String telefone, String email, String sexo, int idade,
			String plano) {
		super(endereco, nome, cpf, telefone, email, sexo, idade);
		this.plano = plano;
		}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public int getIdclient() {
		return idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}	

	@Override
	public void infoBasic(){
		System.out.printf("%d %s %s %s %s %s %s%n", getIdclient(), getNome(), getCpf(), getEmail(), getTelefone(), getPlano(), getEndereco());
	}
}
