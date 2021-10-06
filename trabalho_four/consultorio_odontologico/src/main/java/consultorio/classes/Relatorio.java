package consultorio.classes;

import consultorio.bd.AgendarConsulta;

public class Relatorio {
    private Relatorio(){}

    public static void clientesQueVieram(String data){
        String comando_sql = "SELECT * FROM consulta WHERE data = "+ data +" and realizada=REALIZADA";
        System.out.printf("Foram atendidos %d clientes %s%n", AgendarConsulta.searchConsultaLogical(comando_sql).size(), data);
    }

    public static void clientesQueNaoVieram(){
        String option[] = {"realizada", "CANCELADA"};
        System.out.printf("%d clientes não vieram ou cancelaram%n", AgendarConsulta.searchConsulta(option).size());
    }


    public static void clientesReagendados(){
        String option[] = {"realizada", "REAGENDADOS"};
        System.out.printf("Há %d clientes esperando atendimento%n", AgendarConsulta.searchConsulta(option).size());
    }

    public static void clientesQueVieramMes(String data[]){
        String comando_sql = "SELECT * FROM consulta WHERE realizada=REALIZADO and data BETWEEN "+ data[0] +" and " + data[1] + " order by data";
        System.out.printf("Foram atendidos %d clientes no mês%n", AgendarConsulta.searchConsultaLogical(comando_sql).size());
    }

    public static void clientesQueNaoVieramMes(String data[]){
        String comando_sql = "SELECT * FROM consulta WHERE realizada=CANCELADO and data BETWEEN "+ data[0] +" and " + data[1] + " order by data";
        System.out.printf("%d clientes não vieram ou cancelaram%n", AgendarConsulta.searchConsultaLogical(comando_sql).size());
    }


    public static void clientesReagendadosMes(String data[]){
        String comando_sql = "SELECT * FROM consulta WHERE realizada=REAGENDADO and data BETWEEN "+ data[0] +" and " + data[1] + " order by data";
        System.out.printf("Há %d clientes reagendados%n", AgendarConsulta.searchConsultaLogical(comando_sql).size());
    }
    
    public static void clientesAtendidos(){
        String option[] = {"realizada", "ATENDIDO"};
        System.out.printf("Foram atendidos %d clientes%n", AgendarConsulta.searchConsulta(option).size());
    }

    public static void clientesPendentes(){
        String option[] = {"realizada", "PENDENTES"};
        System.out.printf("Há %d clientes esperando atendimento%n", AgendarConsulta.searchConsulta(option).size());
    }


    public static void clientesQueVieram(String data, String crm_odonto){
        String comando_sql = "SELECT * FROM consulta WHERE data = "+ data +" and realizada=REALIZADA and crm_dentista=" + crm_odonto;
        System.out.printf("Foram atendidos %d pelo Dentista de CRM %s %s%n", AgendarConsulta.searchConsultaLogical(comando_sql).size(), crm_odonto, data);
    }

    public static void clientesQueNaoVieram(String data, String crm_odonto){
        String comando_sql = "SELECT * FROM consulta WHERE data = "+ data +" and realizada=CANCELADA and crm_dentista=" + crm_odonto;
        System.out.printf("Não compareceram %d clientes do Dentista de CRM %s %s%n", AgendarConsulta.searchConsultaLogical(comando_sql).size(), crm_odonto, data);
    }

    public static void clientesReagendados(String data, String crm_odonto){
        String comando_sql = "SELECT * FROM consulta WHERE data = "+ data +" and realizada=REAGENDADO and crm_dentista=" + crm_odonto;
        System.out.printf("Não compareceram %d clientes do Dentista de CRM %s %s%n", AgendarConsulta.searchConsultaLogical(comando_sql).size(), crm_odonto, data);
    }

    public static void clientesAtendidos(String crm_odonto){
        String comando_sql = "SELECT * FROM consulta WHERE realizada=REALIZADA and crm_dentista=" + crm_odonto;
        System.out.printf("Não compareceram %d clientes do Dentista de CRM %s %s%n", AgendarConsulta.searchConsultaLogical(comando_sql).size(), crm_odonto);
    }

    public static void clientesPendentes(String crm_odonto){
        String comando_sql = "SELECT * FROM consulta WHERE (realizada=REAGENDADO or realizada=PENDENTE) and crm_dentista=" + crm_odonto;
        System.out.printf("Não compareceram %d clientes do Dentista de CRM %s %s%n", AgendarConsulta.searchConsultaLogical(comando_sql).size(), crm_odonto);
    }
}
