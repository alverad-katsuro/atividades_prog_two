import java.util.Scanner;
public class Menu { //ISSO E SO UM PROTOTIPO. SUJEITO AS MUDANCAS CONFORME PROGRESSAO
    public static void main(String[] args) {
        Scanner menu_options = new Scanner(System.in);
        Scanner for_numbers = new Scanner(System.in);
        while (true) {
            System.out.println("Digite 1 para abrir a calculadora basica");
            System.out.println("Digite 2 para abrir a calculadora de raizes");
            System.out.println("Digite 0 para sair do programa");
            char menu_checker = menu_options.next().charAt(0); //talvez substituir por int e tratamento de erro
            switch (menu_checker) {
                case ('0'): {
                    menu_options.close();
                    for_numbers.close();
                    System.exit(0);
                    break;
                }
                case ('1'): {
                    System.out.println("Bem-vindo a calculadora basica!");
                    System.out.println("Digite 1 para utilizar a calculadora basica");
                    System.out.println("Digite 0 para sair da calculadora basica");
                    char calcbas_checker = menu_options.next().charAt(0);
                    switch (calcbas_checker) {
                        case ('1'): {
                           // CalculadoraBasica calc_bas = new CalculadoraBasica(); //construtores ainda n bem definidos
                            System.out.print("Digite o valor do primeiro numero: "); //ent sujeito as mudancas
                            double number_1 = for_numbers.nextDouble();
                            System.out.print("\n");
                            System.out.println("Digite + para a operacao de soma"); //esses simbolos estao no ASCII
                            System.out.println("Digite - para a operacao de subtracao"); //ent devem funcionar
                            System.out.println("Digite * para a operacao de multiplicacao"); //mas eu nao testei
                            System.out.println("Digite / para a operacao de divisao"); //:D
                            System.out.println("Digite ^ para a operacao de exponeciacao");
                            System.out.println("Digite % para a operacao de resto");
                            char operation_checker = menu_options.next().charAt(0);
                            System.out.print("Digite o valor do segundo numero: ");
                            double number_2 = for_numbers.nextDouble();
                            System.out.print("\n");
                            switch (operation_checker) {
                                case ('+'): {// soma
                                   // System.out.println(calc_bas.soma(number_1, number_2));
                                    break;
                                }
                                case ('-'): {//subtracao
                                   // System.out.println(calc_bas.subtracao(number_1, number_2));
                                    break;
                                }
                                case ('*'): {//mult
                                   // System.out.println(calc_bas.multiplicacao(number_1, number_2));
                                    break;
                                }
                                case ('/'): {//div
                                   // System.out.println(calc_bas.divisao(number_1, number_2));
                                    break;
                                }
                                case ('^'): {//exponenciacao
                                   // System.out.println(calc_bas.exponenciacao(number_1, number_2));
                                    break;
                                }
                                case ('%'): {//resto
                                   // System.out.println(calc_bas.resto(number_1, number_2));
                                    break;
                                }
                                default: {
                                    break; //its time to stop
                                }
                            }
                        }
                        case ('0'): {
                            break; //it's all break? always has been
                        }
                    }
                    break; //yameroooo
                }
                case ('2'): {
                    System.out.println("Bem-vindo a calculadora de raizes!"); //ent sujeito as mudancas
                    System.out.println("Digite 1 para utilizar a calculadora raizes");
                    System.out.println("Digite 0 para sair da calculadora de raizes");
                    char raiz_calc_checker = menu_options.next().charAt(0);
                    switch (raiz_calc_checker) {
                        case ('1'): {
                            //CalculadoraRaizes calc_rz = new CalculadoraRaizes(); //construtores ainda n bem definidos
                            System.out.print("Digite o valor de a: ");
                            double a = for_numbers.nextDouble();
                            System.out.print("\n");
                            System.out.print("Digite o valor de b: ");
                            double b = for_numbers.nextDouble();
                            System.out.print("\n");
                            System.out.print("Digite o valor de c: ");
                            double c = for_numbers.nextDouble();
                            System.out.print("\n");
                            //calc_rz.printRaizes(a, b, c);
                            break;  
                        }
                        case ('0'): {
                            break; //sleepy
                        }
                        default: {
                            break; //ignore i'm sleepy
                        }
                    }
                }
                default: {
                    break; //still sleepy
                }
            }
        }
    }
}