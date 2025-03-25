import java.util.*

data class Funcionario(
    val matricula: String,
    val nome: String,
    val salario: Double
)

fun main() {
    val scanner = Scanner(System.`in`)
    var funcionarios: List<Funcionario> = emptyList()

    while (true) {
        println("\n=== MENU PRINCIPAL ===")
        println("a) Cadastrar 20 empregados")
        println("b) Pesquisar por matrícula")
        println("c) Mostrar empregados com salário acima de R\$1000")
        println("d) Mostrar empregados com salário abaixo de R\$1000")
        println("e) Mostrar empregados com salário igual a R\$1000")
        println("f) Sair")

        print("\nEscolha uma opção: ")
        when (scanner.nextLine().lowercase()) {
            "a" -> {
                funcionarios = cadastrarFuncionarios(scanner)
                println("\nCadastro concluído e registros ordenados por matrícula.")
            }
            "b" -> {
                if (funcionarios.isEmpty()) {
                    println("\nCadastre os funcionários primeiro (opção a).")
                } else {
                    pesquisarPorMatricula(funcionarios, scanner)
                }
            }
            "c" -> {
                if (funcionarios.isEmpty()) {
                    println("\nCadastre os funcionários primeiro (opção a).")
                } else {
                    mostrarFuncionariosPorFaixaSalarial(funcionarios, "acima")
                }
            }
            "d" -> {
                if (funcionarios.isEmpty()) {
                    println("\nCadastre os funcionários primeiro (opção a).")
                } else {
                    mostrarFuncionariosPorFaixaSalarial(funcionarios, "abaixo")
                }
            }
            "e" -> {
                if (funcionarios.isEmpty()) {
                    println("\nCadastre os funcionários primeiro (opção a).")
                } else {
                    mostrarFuncionariosPorFaixaSalarial(funcionarios, "igual")
                }
            }
            "f" -> {
                println("\nEncerrando o programa...")
                return
            }
            else -> println("\nOpção inválida. Por favor, escolha uma opção de 'a' a 'f'.")
        }
    }
}

fun cadastrarFuncionarios(scanner: Scanner): List<Funcionario> {
    val funcionarios = mutableListOf<Funcionario>()
    println("\n--- Cadastro de Funcionários ---")

    for (i in 1..20) {
        println("\nFuncionário $i/20")
        print("Matrícula: ")
        val matricula = scanner.nextLine()
        print("Nome: ")
        val nome = scanner.nextLine()
        print("Salário: R$ ")
        val salario = scanner.nextLine().toDoubleOrNull() ?: 0.0

        funcionarios.add(Funcionario(matricula, nome, salario))
    }

    return funcionarios.sortedBy { it.matricula }
}

fun pesquisarPorMatricula(funcionarios: List<Funcionario>, scanner: Scanner) {
    print("\nDigite a matrícula a ser pesquisada: ")
    val matricula = scanner.nextLine()

    val funcionario = funcionarios.find { it.matricula == matricula }

    if (funcionario != null) {
        println("\nFuncionário encontrado:")
        println("Matrícula: ${funcionario.matricula}")
        println("Nome: ${funcionario.nome}")
        println("Salário: R$ ${"%.2f".format(funcionario.salario)}")
    } else {
        println("\nFuncionário com essa matrícula não encontrado.")
    }
}

fun mostrarFuncionariosPorFaixaSalarial(funcionarios: List<Funcionario>, faixa: String) {
    val (filtrados, titulo) = when (faixa) {
        "acima" -> Pair(funcionarios.filter { it.salario > 1000 }, "Funcionários com salário acima de R\$1000,00")
        "abaixo" -> Pair(funcionarios.filter { it.salario < 1000 }, "Funcionários com salário abaixo de R\$1000,00")
        else -> Pair(funcionarios.filter { it.salario == 1000.0 }, "Funcionários com salário igual a R\$1000,00")
    }

    println("\n--- $titulo ---")
    if (filtrados.isEmpty()) {
        println("Nenhum funcionário encontrado nesta faixa salarial.")
    } else {
        filtrados.forEach { func ->
            println("Matrícula: ${func.matricula} | Nome: ${func.nome} | Salário: R$ ${"%.2f".format(func.salario)}")
        }
    }
}