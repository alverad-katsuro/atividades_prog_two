package com.resolucao;
import java.io.FileReader;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.resolucao.classes.Areas;
import com.resolucao.classes.Empresa;
import com.resolucao.classes.Funcionario;


public class Start {
    
    public static void main(String[] path) {
        try {
            Gson gson = new Gson();
            Reader read = new FileReader(path[0]);
            System.out.println(read);
            JsonReader reader = gson.newJsonReader(read);
            JsonElement element = JsonParser.parseReader(reader);
            JsonObject objeto = element.getAsJsonObject();
            Areas area = new Areas();
            // Trata as areas retirando as caracteristicas do json -> ex: RH --> Recursos Humanos
            while (!objeto.get("areas").getAsJsonArray().isEmpty()) {
                area.addAreas(objeto.get("areas")
                .getAsJsonArray()
                .remove(0)
                .toString()
                .replace("{", "")
                .replace("\"", "")
                .replace("}", "")
                .replace(":", "")
                .replace("codigo", "")
                .replace("nome", "")
                .split(","));
            }
            Empresa empresa = new Empresa();
            empresa.setArea(area);
            // add os funcionarios na empresa e instancia eles como objeto
            while (!objeto.get("funcionarios").getAsJsonArray().isEmpty()) {
                Funcionario funcionario = gson.fromJson(objeto.get("funcionarios").getAsJsonArray().remove(0).getAsJsonObject(), Funcionario.class);
                funcionario.setArea(area.getAreas_comp(funcionario.getArea()));
                empresa.addFuncionarios(funcionario);
            }
            /// output dos requisitos
            empresa.maiorMenorSalario();
            empresa.maiorMenorSalario_area();
            empresa.moreFunc();
            empresa.sobrenomeIgual();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
