package n2b1_compiladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class N2B1_Compiladores {

    /*
    
    Para utilizar o programa, digite no console o código a ser validado.
    Haverá um menu a cada validação podendo continuar validando códigos ou
    sair do sistema.
    
    */
    public static void main(String[] args) {
        Map<String, String> openToClosedCharacters = new HashMap<>();
        openToClosedCharacters.put("(", ")");
        openToClosedCharacters.put("[", "]");
        openToClosedCharacters.put("{", "}");
        openToClosedCharacters.put("<", ">");
        
        Map<String, String> closeToOpenedCharacters = new HashMap<>();
        closeToOpenedCharacters.put(")", "(");
        closeToOpenedCharacters.put("]", "[");
        closeToOpenedCharacters.put("}", "}");
        closeToOpenedCharacters.put(">", "<");
        
        Scanner scan = new Scanner(System.in);
        
        boolean invalidCode = false;
        boolean close = false;
        
        while(!close) {
   
            List<String> stack = new ArrayList();

            System.out.print("Insira o código a ser validado: ");
            String code = scan.nextLine();

            code = code.replaceAll("\\s+","");

            for (String character : code.split("")) {
                if (openToClosedCharacters.containsKey(character)) {
                    stack.add(character);
                } else if (closeToOpenedCharacters.containsKey(character)) {
                    if (stack.size() > 0 && character.equals(openToClosedCharacters.get(stack.get(stack.size() -1)))) {
                        stack.remove(stack.size() -1);
                    } else {
                        System.out.println("Não - Inválido");
                        invalidCode = true;
                        break;
                    }
                } else {
                    System.out.println("Não - Inválido");
                    invalidCode = true;
                    break;
                }
            }

            if (!invalidCode && !code.isEmpty() && stack.size() == 0) {
                System.out.println("OK - Válido");
            } else if (!invalidCode) {
                System.out.println("Não - Inválido");
            }
            
            invalidCode = false;
        
            System.out.println("");
            System.out.println("--------Opções---------");
            System.out.println("1 - Continuar validando");
            System.out.println("2 - Sair");
            System.out.print("Digite a opção desejada: ");
            System.out.println("");
            String opcao = scan.nextLine();
            switch (opcao)
            {
                case "1":
                    close = false;
                    break;
                case "2":
                    close = true;
                    break;
                default:
                    close = true;
                    System.out.println("Opção inválida!");
            }
        }

    }
    
}
