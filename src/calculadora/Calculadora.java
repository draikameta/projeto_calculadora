package calculadora;

/**
 * <p><strong>Projeto Calculadora</strong></p>
 *
 * <p>Esta classe fornece operações matemáticas básicas como soma, subtração,
 * multiplicação e divisão, além de um método principal que seleciona a operação
 * desejada com base no operador informado pelo usuário.</p>
 *
 * <p>Este projeto é utilizado para demonstrar:</p>
 * <ul>
 *     <li>Técnicas de revisão estática (caixa branca)</li>
 *     <li>Testes funcionais (caixa preta)</li>
 *     <li>Aplicação de refatoração em código Java</li>
 *     <li>Documentação com JavaDoc</li>
 * </ul>
 *
 * <p>Após a refatoração, os métodos desta classe são <strong>métodos puros</strong>,
 * sem efeitos colaterais, o que permite maior legibilidade e facilita os testes
 * unitários.</p>
 *
 * @author Renan Machado de Almeida
 * @version 1.0
 */
public class Calculadora {

    /**
     * Cria uma nova instância da calculadora.
     */
    public Calculadora() {
        // Classe sem estado: nenhuma inicialização necessária
    }

    /**
     * Soma dois números inteiros.
     *
     * @param a primeiro operando
     * @param b segundo operando
     * @return o resultado da soma de {@code a} e {@code b}
     */
    public int somar(int a, int b) {
        return a + b;
    }

    /**
     * Subtrai dois números inteiros.
     *
     * @param a minuendo
     * @param b subtraendo
     * @return o resultado da subtração {@code a - b}
     */
    public int subtrair(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dois números inteiros.
     *
     * @param a primeiro fator
     * @param b segundo fator
     * @return o produto de {@code a} por {@code b}
     */
    public int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Divide dois números inteiros, impedindo a divisão por zero.
     *
     * @param a dividendo
     * @param b divisor (não pode ser zero)
     * @return o quociente inteiro da divisão {@code a / b}
     * @throws IllegalArgumentException se {@code b} for igual a zero
     */
    public int dividir(int a, int b) {
        // Validação antes da divisão: evita ArithmeticException
        if (b == 0) {
            throw new IllegalArgumentException("Divisão por zero não é permitida.");
        }
        return a / b;
    }

    /**
     * Executa a operação matemática solicitada com base no operador informado.
     *
     * <p>Operadores aceitos:</p>
     * <ul>
     *     <li>"+": Soma</li>
     *     <li>"-": Subtração</li>
     *     <li>"*": Multiplicação</li>
     *     <li>"/": Divisão</li>
     * </ul>
     *
     * <p>Qualquer operador inválido resulta em exceção.</p>
     *
     * @param a        primeiro operando
     * @param b        segundo operando
     * @param operador símbolo da operação desejada
     * @return o resultado da operação correspondente ao operador informado
     * @throws IllegalArgumentException se o operador for nulo, não for um símbolo
     *                                  válido ou se houver divisão por zero
     */
    public int calcular(int a, int b, String operador) {
        // Operador nulo seria um NullPointerException no switch; tratamos como inválido
        if (operador == null) {
            throw new IllegalArgumentException("Operador inválido: " + operador);
        }

        return switch (operador) {
            case "+" -> somar(a, b);
            case "-" -> subtrair(a, b);
            case "*" -> multiplicar(a, b);
            case "/" -> dividir(a, b);
            default -> throw new IllegalArgumentException("Operador inválido: " + operador);
        };
    }
}
