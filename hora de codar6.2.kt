import java.util.*

data class Aluno(
    val nome: String,
    val notas: List<Double>
)

fun cadastrarAlunos(): List<Aluno> {
    val alunos = mutableListOf<Aluno>()
    val scanner = Scanner(System.`in`)

    for (i in 1..20) {
        println("\nCadastro do aluno $i:")
        print("Nome: ")
        val nome = scanner.nextLine()

        val notas = mutableListOf<Double>()
        for (j in 1..4) {
            print("Nota $j: ")
            val nota = scanner.nextDouble()
            notas.add(nota)
        }
        scanner.nextLine() // Consumir a quebra de linha pendente

        alunos.add(Aluno(nome, notas))
    }

    // Ordenar alunos por nome após o cadastro
    return alunos.sortedBy { it.nome }
}

fun calcularMedia(notas: List<Double>): Double {
    return notas.average()
}

fun pesquisarPorNome(alunos: List<Aluno>, nome: String): Aluno? {
    return alunos.find { it.nome.equals(nome, ignoreCase = true) }
}

fun mostrarTodosAlunos(alunos: List<Aluno>) {
    println("\nLista de Alunos:")
    alunos.forEach { aluno ->
        val media = calcularMedia(aluno.notas)
        val situacao = if (media >= 5) "Aprovado" else "Reprovado"
        println("Nome: ${aluno.nome}, Notas: ${aluno.notas}, Média: $media, Situação: $situacao")
    }
}

fun men() {
    val scanner = Scanner(System.`in`)
    var alunos: List<Aluno> = listOf()

    while (true) {
        println("\nMenu de Opções:")
        println("1. Cadastrar 20 alunos")
        println("2. Pesquisar aluno por nome")
        println("3. Apresentar todos os alunos")
        println("4. Sair")
        print("Escolha uma opção: ")
        val opcao = scanner.nextLine()

        when (opcao) {
            "1" -> alunos = cadastrarAlunos()
            "2" -> {
                print("Digite o nome a ser pesquisado: ")
                val nome = scanner.nextLine()
                val aluno = pesquisarPorNome(alunos, nome)
                if (aluno != null) {
                    val media = calcularMedia(aluno.notas)
                    val situacao = if (media >= 5) "Aprovado" else "Reprovado"
                    println("\nRegistro encontrado:")
                    println("Nome: ${aluno.nome}, Notas: ${aluno.notas}, Média: $media, Situação: $situacao")
                } else {
                    println("Aluno não encontrado.")
                }
            }
            "3" -> mostrarTodosAlunos(alunos)
            "4" -> {
                println("Saindo do programa...")
                break
            }
            else -> println("Opção inválida. Tente novamente.")
        }
    }
}

fun main() {
    men()
}