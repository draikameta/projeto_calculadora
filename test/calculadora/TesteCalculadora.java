package calculadora;

public class TesteCalculadora {

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        // Testes rápidos
        testar(calc, 2, 3, "+", 5);   // esperado: 5
        testar(calc, 10, 4, "-", 6);  // esperado: 6
        testar(calc, 3, 5, "*", 15);  // esperado: 15
        testar(calc, 8, 2, "/", 4);   // esperado: 4
        testar(calc, 8, 0, "/", 0);   // divisao por zero
        testar(calc, 5, 5, "x", 0);   // operação inválida
    }

    // Executa a operação e mostra entradas, resultado esperado e resultado obtido
    static void testar(Calculadora calc, int a, int b, String op, int esperado) {
        System.out.println("Entradas: a=" + a + ", b=" + b + ", op=\"" + op + "\"");
        int obtido = calc.calc(a, b, op);
        System.out.println("Esperado: " + esperado + " | Obtido: " + obtido
                + " -> " + (esperado == obtido ? "OK" : "FALHOU"));
        System.out.println();
    }
}
