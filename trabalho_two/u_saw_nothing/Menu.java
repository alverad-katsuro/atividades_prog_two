import java.util.Scanner;
public class Menu {
    static Scanner global_scanner = new Scanner(System.in);
    private static Funcionario validateID(String id) {
        for (Funcionario self_id : getEmpresa().getContratos().getFuncionarios()) {
            if (((self_id.getContrato()).toString()).equals(id)) {
                return self_id;
            } 
        }
        return null;
    }

    private static void registrarFuncionario() {
        System.out.print("\nINSERIR NOME: ");
        String name = global_scanner.nextLine(); 
        System.out.print("\nINSERIR SOBRENOME: ");
        //String surname = global_scanner.nextLine(); 
        System.out.print("\nINSERIR CPF: ");
        long cpf = global_scanner.nextLong();
        Pessoa x = new Pessoa(name, cpf);
        System.out.print("\nINSERIR ENDERECO: ");
        //
        System.out.print("\nINSERIR IDADE: ");
        System.out.print("\nINSERIR SEXO: ");
        System.out.print("\nINSERIR EMAIL: ");
        System.out.print("\nINSERIR TELEFONE: ");
        System.out.print("--------------------------");
        System.out.print("\nINSERIR SETOR: ");
        Setor section = Setor.valueOf(global_scanner.nextLine());
        System.out.print("\nINSERIR CARGO: ");
        System.out.print("\nINSERIR SALARIO: ");
        Contrato a = new Contrato(section, x);
        System.out.print("--------------------------");
        System.out.print("\nDADOS INSERIDOS CORRETAMENTE?");
        //GERAR ID FUNCAO
        // System.out.printf("ID GERADO: %n");
    }

    private static void findFuncionario() {
        System.out.print("\nPROCURAR POR NOME OU CPF? ");
        String name_or_cpf = global_scanner.nextLine();
        switch (name_or_cpf) {
            case (NOME): {
                System.out.print("\nDIGITE O NOME DO FUNCIONARIO: ");
                String name_find = global_scanner.nextLine();
                System.out.println((buscaFuncionario(name_find))? "\nFUNCIONARIO ENCONTRADO" : "\nFUNCIONARIO NAO ENCONTRADO");
                break;
            }
            case (CPF): {
                System.out.print("\nDIGITE O CPF: ");
                long cpf_find = global_scanner.nextLong();
                System.out.println((buscaFuncionario(cpf_find))? "\nFUNCIONARIO ENCONTRADO" : "\nFUNCIONARIO NAO ENCONTRADO");
                break;
            }
        }
    }

    private static void atualizarFuncionario() {
        System.out.print("\nINSIRA O ID DO FUNCIONARIO: ");
        String id = global_scanner.nextLine();
        Funcionario reference = validateID(id);
        if (reference != null) {
            System.out.print("DIGITE O ATRIBUTO QUE VOCE QUER MODIFICAR: ");
            String mod_att = global_scanner.nextLine();
            switch (mod_att) {
                case ("NOME"): {
                    System.out.print("\nINSERIR NOME: ");
                    String change_nome = global_scanner.nextLine();
                    reference.setNome(change_nome);
                    break;
                }
                case ("SOBRENOME"): {
                    System.out.print("\nINSERIR SOBRENOME: ");
                    String change_sobrenome = global_scanner.nextLine();
                    //reference.setSobrenome(change_sobrenome);
                    break;
                }
                case ("ENDERECO"): {
                    String change_rua, change_bairro, change_cidade, change_estado;
                    System.out.print("\nINSERIR RUA: ");
                    change_rua = global_scanner.nextLine();
                    System.out.print("\nINSERIR BAIRRO: ");
                    change_bairro = global_scanner.nextLine();
                    System.out.print("\nINSERIR CIDADE: ");
                    change_cidade = global_scanner.nextLine();
                    System.out.print("\nINSERIR ESTADO: "); 
                    change_estado = global_scanner.nextLine();
                    reference.setEndereco(change_rua, change_bairro, change_cidade, change_estado);
                    break;
                }
                case ("IDADE"): {
                    System.out.print("INSERIR IDADE: ");
                    int change_idade = global_scanner.nextInt();
                    reference.setIdade(change_idade);
                    break;
                }
                case ("SEXO"): {
                    System.out.print("INSERIR SEXO (M/F): ");
                    char change_sexo = global_scanner.next().charAt(0);
                    reference.setSexo(change_sexo);
                    break;
                }
                case ("CPF"): {
                    System.out.print("INSERIR CPF: ");
                    long change_cpf = global_scanner.nextLong();
                    reference.setCPF(change_cpf);
                    break;
                }
                case ("EMAIL"): {
                    System.out.print("INSERIR EMAIL: ");
                    String change_email = global_scanner.nextLine();
                    reference.setEmail(change_email);
                    break;
                }
                case ("TELEFONE"): {
                    System.out.print("INSERIR TELEFONE: ");
                    long change_telefone = global_scanner.nextLong();
                    reference.setTelefone(change_telefone);
                    break;
                }
                case ("SETOR"): {
                    System.out.print("INSERIR SETOR: ");
                    reference.setSetor(change_setor);
                    break;
                }
                case ("CARGO"): {
                    System.out.print("INSERIR CARGO: ");
                    reference.setCargo(change_cargo);
                    break;
                }
                case ("SALARIO"): {
                    System.out.print("INSERIR SALARIO: ");
                    float change_salario = global_scanner.nextFloat();
                    reference.setSalario(change_salario);
                    break;
                }
            }
        }
        //System.out.print("DADOS INSERIDOS CORRETAMENTE? (S/N)");
        //char confirm = global_scanner.next().charAt(0);
        //if (confirm.equals('S')) {
        //    System.out.println("ALTERACOES FEITAS COM SUCESSO");
        //}
        //else if (confirm.equals('N')) {
        //    System.out.println("OPERACAO CANCELADA!");
        //}
    }

    private static void demitirFuncionarioPerCPF() { //COMPLETO E ACHO QUE BOM
        System.out.print("INSERIR CPF: ");
        String dmtr_per_cpf = global_scanner.nextLine();
        System.out.println((Contrato.demitirFuncionario(dmtr_per_cpf))? "FUNCIONARIO DEMITIDO" : "FUNCIONARIO NAO ENCONTRADO");
    }

    private static void todosFuncionarios() { //VOU VER SE DEIXO MAIS BONITO DEPENDENDO DE COMO SEJA IMPIRMIDO
        Interface.getFuncionarios();
    }

    private static void visualizarFuncionarioPor() {
        String filtro = global_scanner.nextLine();
        switch (filtro) {
            case ("SETOR"): {
                Setor section_choice = global_scanner.nextLine().toUpperCase();
                Interface.getFuncionarios(section_choice);
                break;
            }
            case ("SEXO"): {
                char sex_choice = global_scanner.next().charAt(0);
                Interface.getFuncionarios(sex_choice);
                break;
            }
            case ("ESTADO"): {
                String state_choice = global_scanner.nextLine();
                Interface.getFuncionarios(state_choice);//imprime funcionarios por estado
                break;
            }
        }
    }

    private static void setoresFuncionariosSalario() {
       // getFuncionarioMaxSal();
        //getFuncionarioMinSal();
    }
    
    private static void setoresNumeroFuncionarios() {
        getFuncionarios(); //getFuncionariosMinMaxQuantity()
    }
     
    public static void main(String[] args) {
        System.out.print("1. REGISTRAR FUNCIONARIO\n2. ENCONTRAR FUNCIONARIO\n3. ATUALIZAR OS DADOS\n4. DEMITIR FUNCIONARIO");
        System.out.print("5. TODOS OS FUNCIONARIOS\n6. VISUALIZAR FUNCIONARIO\n7. VISUALIZAR SETORES\n8. MAIOR E MENOR SALARIO");
        System.out.print("\nESCOLHER AÇÃO: ");
        int main_action = global_scanner.nextInt(); 
        switch (main_action) {
            case (1): {
                registrarFuncionario();
                break;
            }
            case (2): {
                findFuncionario();
                break;
            }
            case (3): {
                atualizarFuncionario();
                break;
            }
            case (4): {
                demitirFuncionarioPerCPF();
                break;
            }
            case (5): {
                todosFuncionarios();
                break;
            }
            case (6): {
                visualizarFuncionarioPor();
                break;
            }
            case (7): {
                setoresFuncionariosSalario();
                break;
            }
            case (8): {
                setoresNumeroFuncionarios();
                break;
            }
            case (0): {
                global_scanner.close();
                System.exit(0);
            }
            default: {
                break;
            }
        }
    }
}