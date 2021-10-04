package consultorio.classes;

import consultorio.classes.Enum.Especializacoes;
import consultorio.classes.Enum.Stats_Consulta;

public class Consulta {
    private int IdConsulta;
    private Especializacoes especializacao;
    private String crm_dentista;
    private String cpf_cliente;
    private String data;
    private float valor;
    private Stats_Consulta realizada;
    
  
    public Consulta(String especializacao, String crm_dentista, String cpf_cliente, String data, float valor,
            String realizada) {
        this.especializacao = comparadorEspecialidade(especializacao);
        this.crm_dentista = crm_dentista;
        this.cpf_cliente = cpf_cliente;
        this.data = data;
        this.valor = valor;
        this.realizada = comparadorStatus(realizada);
    }

    public Consulta(int idConsulta, String especializacao, String crm_dentista, String cpf_cliente,
            String data, float valor, String realizada) {
        IdConsulta = idConsulta;
        this.especializacao = comparadorEspecialidade(especializacao);
        this.crm_dentista = crm_dentista;
        this.cpf_cliente = cpf_cliente;
        this.data = data;
        this.valor = valor;
        this.realizada = comparadorStatus(realizada);
    }

    @Override
    public String toString() {
        return "Consulta [IdConsulta=" + IdConsulta + ", cpf_cliente=" + cpf_cliente + ", crm_dentista=" + crm_dentista
                + ", data=" + data + ", especializacao=" + especializacao + ", realizada=" + realizada + ", valor="
                + valor + "]";
    }

    public Stats_Consulta getRealizada() {
        return realizada;
    }

    public void setRealizada(Stats_Consulta realizada) {
        this.realizada = realizada;
    }

    public int getIdConsulta() {
        return IdConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        IdConsulta = idConsulta;
    }

    public Especializacoes getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(Especializacoes especializacao) {
        this.especializacao = especializacao;
    }

    public String getCrm_dentista() {
        return crm_dentista;
    }

    public void setCrm_dentista(String crm_dentista) {
        this.crm_dentista = crm_dentista;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
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

    public static Stats_Consulta comparadorStatus(String string){
        if (string.equals(Stats_Consulta.REALIZADA.toString())){
            return Stats_Consulta.REALIZADA;
        } else if (string.equals(Stats_Consulta.PENDENTE.toString())){
            return Stats_Consulta.PENDENTE;
        } else if (string.equals(Stats_Consulta.CANCELADA.toString())){
            return Stats_Consulta.CANCELADA;
        } else {
            return null;
        }
    }
}
