import java.util.*

data class Pessoa(
    val nome: String,
    val endereco: String,
    val telefone: String
)

fun cadastrarPessoas(): List<Pessoa> {
    val pessoas = mutableListOf<Pessoa>()
    val scanner = Scanner(System.`in`)

    for (i in 1..10) {
        println("Cadastro da pessoa $i:")
        print("Nome: ")
        val nome = scanner.nextLine()
        print("Endereço: ")
        val endereco = scanner.nextLine()
        print("Telefone: ")
        val telefone = scanner.nextLine()
        pessoas.add(Pessoa(nome, endereco, telefone))
    }
    return pessoas
}

fun pesquisarPorNome(pessoas: List<Pessoa>, nome: String): Pessoa? {
    return pessoas.find { it.nome == nome }
}

fun ordenarPorNome(pessoas: List<Pessoa>): List<Pessoa> {
    return pessoas.sortedBy { it.nome }
}

fun mostrarPessoas(pessoas: List<Pessoa>) {
    pessoas.forEach { pessoa ->
        println("Nome: ${pessoa.nome}, Endereço: ${pessoa.endereco}, Telefone: ${pessoa.telefone}")
    }
}

fun menu() {
    val scanner = Scanner(System.`in`)
    var pessoas: List<Pessoa> = listOf()

    while (true) {
        println("\nMenu de Opções:")
        println("1. Cadastrar 10 registros")
        println("2. Pesquisar registro por nome")
        println("3. Classificar registros por nome")
        println("4. Apresentar todos os registros")
        println("5. Sair")
        print("Escolha uma opção: ")
        val opcao = scanner.nextLine()

        when (opcao) {
            "1" -> pessoas = cadastrarPessoas()
            "2" -> {
                print("Digite o nome a ser pesquisado: ")
                val nome = scanner.nextLine()
                val pessoa = pesquisarPorNome(pessoas, nome)
                if (pessoa != null) {
                    println("Registro encontrado: Nome: ${pessoa.nome}, Endereço: ${pessoa.endereco}, Telefone: ${pessoa.telefone}")
                } else {
                    println("Registro não encontrado.")
                }
            }
            "3" -> {
                pessoas = ordenarPorNome(pessoas)
                println("Registros ordenados por nome.")
            }
            "4" -> mostrarPessoas(pessoas)
            "5" -> {
                println("Saindo do programa...")
                break
            }
            else -> println("Opção inválida. Tente novamente.")
        }
    }
}

fun main() {
    menu()
}