package calculadora;

/**
 * Testes unitários da classe {@link Calculadora}.
 *
 * <p>Cada teste exibe as <strong>entradas utilizadas</strong>, o
 * <strong>resultado esperado</strong> e o <strong>resultado obtido</strong>.
 * Os casos de erro verificam as exceções lançadas com {@code try/catch}.</p>
 *
 * @author Renan Machado de Almeida
 * @version 1.0
 */
public class TesteCalculadora {

    /** Total de testes executados. */
    private static int total = 0;

    /** Total de testes aprovados. */
    private static int aprovados = 0;

    /**
     * Construtor privado: a classe serve apenas para executar os testes.
     */
    private TesteCalculadora() {
        // Não deve ser instanciada
    }

    /**
     * Executa todos os testes da calculadora e exibe o resumo.
     * Encerra com código 1 se algum teste falhar.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        System.out.println("=== TESTES DA CALCULADORA ===");

        testarResultado(calc, 2, 3, "+", 5);
        testarResultado(calc, 10, 4, "-", 6);
        testarResultado(calc, 3, 5, "*", 15);
        testarResultado(calc, 8, 2, "/", 4);

        testarErro(calc, 8, 0, "/", "Divisão por zero não é permitida."); // exceção
        testarErro(calc, 5, 5, "x", "Operador inválido: x");              // exceção
        testarErro(calc, 5, 5, null, "Operador inválido: null");          // exceção

        System.out.println("=== RESULTADO: " + aprovados + "/" + total + " testes aprovados ===");
        if (aprovados != total) {
            System.exit(1);
        }
    }

    /**
     * Testa uma operação que deve retornar um valor.
     *
     * @param calc     calculadora sob teste
     * @param a        primeiro operando
     * @param b        segundo operando
     * @param operador operador da operação
     * @param esperado resultado esperado
     */
    private static void testarResultado(Calculadora calc, int a, int b, String operador, int esperado) {
        String obtido;
        try {
            obtido = String.valueOf(calc.calcular(a, b, operador));
        } catch (IllegalArgumentException e) {
            obtido = "exceção: " + e.getMessage();
        }
        registrar(a, b, operador, String.valueOf(esperado), obtido);
    }

    /**
     * Testa uma operação que deve lançar {@link IllegalArgumentException}.
     *
     * @param calc             calculadora sob teste
     * @param a                primeiro operando
     * @param b                segundo operando
     * @param operador         operador da operação
     * @param mensagemEsperada mensagem esperada na exceção
     */
    private static void testarErro(Calculadora calc, int a, int b, String operador, String mensagemEsperada) {
        String obtido;
        try {
            obtido = "sem exceção, retornou " + calc.calcular(a, b, operador);
        } catch (IllegalArgumentException e) {
            obtido = e.getMessage();
        }
        registrar(a, b, operador, mensagemEsperada, obtido);
    }

    /**
     * Compara esperado e obtido, atualiza os contadores e imprime o resultado.
     *
     * @param a        primeiro operando
     * @param b        segundo operando
     * @param operador operador da operação
     * @param esperado resultado esperado (texto)
     * @param obtido   resultado obtido (texto)
     */
    private static void registrar(int a, int b, String operador, String esperado, String obtido) {
        boolean passou = esperado.equals(obtido);
        total++;
        if (passou) {
            aprovados++;
        }
        System.out.println("[" + (passou ? "PASSOU" : "FALHOU") + "] Entradas: a=" + a
                + ", b=" + b + ", operador=\"" + operador + "\"");
        System.out.println("   Esperado: " + esperado);
        System.out.println("   Obtido  : " + obtido);
    }
}
