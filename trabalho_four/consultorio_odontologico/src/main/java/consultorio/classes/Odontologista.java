package consultorio.classes;

public class Odontologista extends Pessoa{
	protected String crm;
	protected int iddentista;
	
	public Odontologista(String nome, String cpf, String telefone, String email, String sexo, int idade, String pais,
			String estado, String cidade, String bairro, String rua, String numero, String complemento, String crm) {
		super(nome, cpf, telefone, email, sexo, idade, pais, estado, cidade, bairro, rua, numero, complemento);
		this.crm = crm;
	}

	public Odontologista(String endereco, String nome, String cpf, String telefone, String email, String sexo,
			int idade, String crm, int iddentista) {
		super(endereco, nome, cpf, telefone, email, sexo, idade);
		this.crm = crm;
		this.iddentista = iddentista;
	}

	public Odontologista(String endereco, String nome, String cpf, String telefone, String email, String sexo,
			int idade, String crm) {
		super(endereco, nome, cpf, telefone, email, sexo, idade);
		this.crm = crm;
	}

	public String getCRM() {
		return crm;
	}

	public void setCRM(String plano) {
		this.crm = plano;
	}

	public int getiddentista() {
		return iddentista;
	}

	public void setIddentista(int iddentista) {
		this.iddentista = iddentista;
	}

	@Override
	public void infoBasic(){
		System.out.printf("%d %s %s %s %s %s%n", getiddentista(), getNome(), getCpf(), getEmail(), getTelefone(), getEndereco());
	}
}
