package consultorio.classes;

import consultorio.classes.Enum.Especializacoes;

public class Odontologista extends Pessoa{
	protected String crm;
	protected int iddentista;
	protected Especializacoes especializacoes;
	
	public Odontologista(String nome, String cpf, String telefone, String email, String sexo, int idade, String pais,
			String estado, String cidade, String bairro, String rua, String numero, String complemento, String crm, 
			String especializacao) {
		super(nome, cpf, telefone, email, sexo, idade, pais, estado, cidade, bairro, rua, numero, complemento);
		this.especializacoes = comparadorEspecialidade(especializacao);
		this.crm = crm;
	}

	public Odontologista(String endereco, String nome, String cpf, String telefone, String email, String sexo,
			int idade, String crm, int iddentista, String especializacao) {
		super(endereco, nome, cpf, telefone, email, sexo, idade);
		this.crm = crm;
		this.iddentista = iddentista;
		this.especializacoes = comparadorEspecialidade(especializacao);
	}

	public Odontologista(String endereco, String nome, String cpf, String telefone, String email, String sexo,
			int idade, String crm, String especializacao) {
		super(endereco, nome, cpf, telefone, email, sexo, idade);
		this.crm = crm;
		this.especializacoes = comparadorEspecialidade(especializacao);
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public int getIddentista() {
		return iddentista;
	}
	
	public void setIddentista(int iddentista) {
		this.iddentista = iddentista;
	}

	public Especializacoes getEspecializacoes() {
		return especializacoes;
	}

	public void setEspecializacoes(Especializacoes especializacoes) {
		this.especializacoes = especializacoes;
	}


	@Override
	public void infoBasic(){
		System.out.printf("%d %s %s %s %s %s%n", getIddentista(), getNome(), getCpf(), getEmail(), getTelefone(), getEndereco());
	}

	public static Especializacoes comparadorEspecialidade(String string){
        if (string.equals(Especializacoes.PROTETICO.toString())){
            return Especializacoes.PROTETICO;
        } else if (string.equals(Especializacoes.DENTISTA.toString())){
            return Especializacoes.DENTISTA;
        } else if (string.equals(Especializacoes.CIRURGIAO.toString())){
            return Especializacoes.CIRURGIAO;
        } else {
            return null;
        }
    }
}
