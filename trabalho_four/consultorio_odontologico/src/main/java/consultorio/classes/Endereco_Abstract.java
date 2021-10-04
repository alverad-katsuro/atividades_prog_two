package consultorio.classes;

public abstract class Endereco_Abstract implements Endereco_Interface {
	protected String pais;
	protected String estado;
	protected String cidade;
	protected String bairro;
	protected String rua;
	protected String numero;
	protected String complemento;
	
	
	public Endereco_Abstract(String pais, String estado, String cidade, String bairro, String rua, String numero,
			String complemento) {
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
	}
	
	public Endereco_Abstract(String endereco) {
		String endereco_split[] = endereco.split(",");
		setRua(endereco_split[0]);
		setNumero(endereco_split[1]);
		setBairro(endereco_split[2]);
		setCidade(endereco_split[3]);
		setEstado(endereco_split[4]);
		setPais(endereco_split[5]);
		setComplemento(endereco_split[6]);
	}

	@Override
	public String getEnderecoComplemento() {
		return (getRua()+", "+getNumero()+", "+getBairro()+", "+getCidade()+", "+getEstado()+", "+getPais()+", "+getComplemento());
	}
	
	@Override
	public String getEndereco() {
		return (getRua()+", Nº"+getNumero()+", "+getBairro()+", "+getCidade()+", "+getEstado()+", "+getPais());
	}

	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	

}
