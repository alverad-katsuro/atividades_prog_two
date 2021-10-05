package consultorio.classes;

import consultorio.bd.AgendarConsulta;

public class Relatorio {
    private Relatorio(){}

    public void clientesQueVieram(String data){
        String comando_sql = "SELECT * FROM consulta WHERE data = "+ data +" and realizada=REALIZADA";
        System.out.printf("Foram atendidos %d clientes %s", AgendarConsulta.searchConsultaLogical(comando_sql).size(), data);
    }

    public void clientesQueNaoVieram(){
        String option[] = {"realizada", "CANCELADA"};
        System.out.printf("%d clientes não vieram ou cancelaram", AgendarConsulta.searchConsulta(option).size());
    }


    public void clientesReagendados(){
        String option[] = {"realizada", "REAGENDADOS"};
        System.out.printf("Há %d clientes esperando atendimento", AgendarConsulta.searchConsulta(option).size());
    }

    public void clientesQueVieramMes(String data[]){
        String comando_sql = "SELECT * FROM consulta WHERE realizada=REALIZADO and data BETWEEN "+ data[0] +" and " + data[1] + " order by data";
        System.out.printf("Foram atendidos %d clientes no mês", AgendarConsulta.searchConsultaLogical(comando_sql).size());
    }

    public void clientesQueNaoVieramMes(String data[]){
        String comando_sql = "SELECT * FROM consulta WHERE realizada=CANCELADO and data BETWEEN "+ data[0] +" and " + data[1] + " order by data";
        System.out.printf("%d clientes não vieram ou cancelaram", AgendarConsulta.searchConsultaLogical(comando_sql).size());
    }


    public void clientesReagendadosMes(String data[]){
        String comando_sql = "SELECT * FROM consulta WHERE realizada=REAGENDADO and data BETWEEN "+ data[0] +" and " + data[1] + " order by data";
        System.out.printf("Há %d clientes reagendados", AgendarConsulta.searchConsultaLogical(comando_sql).size());
    }
    
    public void clientesAtendidos(){
        String option[] = {"realizada", "ATENDIDO"};
        System.out.printf("Foram atendidos %d clientes", AgendarConsulta.searchConsulta(option).size());
    }

    public void clientesPendentes(){
        String option[] = {"realizada", "PENDENTES"};
        System.out.printf("Há %d clientes esperando atendimento", AgendarConsulta.searchConsulta(option).size());
    }


    public void clientesQueVieram(String data, String crm_odonto){
        String comando_sql = "SELECT * FROM consulta WHERE data = "+ data +" and realizada=REALIZADA and crm_dentista=" + crm_odonto;
        System.out.printf("Foram atendidos %d pelo Dentista de CRM %s %s", AgendarConsulta.searchConsultaLogical(comando_sql).size(), crm_odonto, data);
    }

    public void clientesQueNaoVieram(String data, String crm_odonto){
        String comando_sql = "SELECT * FROM consulta WHERE data = "+ data +" and realizada=CANCELADA and crm_dentista=" + crm_odonto;
        System.out.printf("Não compareceram %d clientes do Dentista de CRM %s %s", AgendarConsulta.searchConsultaLogical(comando_sql).size(), crm_odonto, data);
    }

    public void clientesReagendados(String data, String crm_odonto){
        String comando_sql = "SELECT * FROM consulta WHERE data = "+ data +" and realizada=REAGENDADO and crm_dentista=" + crm_odonto;
        System.out.printf("Não compareceram %d clientes do Dentista de CRM %s %s", AgendarConsulta.searchConsultaLogical(comando_sql).size(), crm_odonto, data);
    }

    public void clientesAtendidos(String crm_odonto){
        String comando_sql = "SELECT * FROM consulta WHERE realizada=REALIZADA and crm_dentista=" + crm_odonto;
        System.out.printf("Não compareceram %d clientes do Dentista de CRM %s %s", AgendarConsulta.searchConsultaLogical(comando_sql).size(), crm_odonto);
    }

    public void clientesPendentes(String crm_odonto){
        String comando_sql = "SELECT * FROM consulta WHERE (realizada=REAGENDADO or realizada=PENDENTE) and crm_dentista=" + crm_odonto;
        System.out.printf("Não compareceram %d clientes do Dentista de CRM %s %s", AgendarConsulta.searchConsultaLogical(comando_sql).size(), crm_odonto);
    }
}
