import java.util.Scanner

data class Pessoa(val nome: String, val altura: Double)

fun main() {
    val scanner = Scanner(System.`in`)
    val pessoas = mutableListOf<Pessoa>()
    var opcao: Int

    do {
        println("\n=== MENU ===")
        println("1. Cadastrar 15 pessoas")
        println("2. Mostrar pessoas ≤ 1.5m")
        println("3. Mostrar pessoas > 1.5m")
        println("4. Mostrar pessoas > 1.5m e < 2.0m")
        println("5. Calcular média das alturas")
        println("6. Sair")
        print("Escolha uma opção: ")

        opcao = scanner.nextInt()
        scanner.nextLine() // Consumir a quebra de linha

        when (opcao) {
            1 -> {
                pessoas.clear()
                for (i in 1..15) {
                    print("Digite o nome da pessoa $i: ")
                    val nome = scanner.nextLine()
                    print("Digite a altura da pessoa $i (em metros): ")
                    val altura = scanner.nextDouble()
                    scanner.nextLine() // Consumir a quebra de linha
                    pessoas.add(Pessoa(nome, altura))
                }
                println("Cadastro concluído!")
            }
            2 -> {
                if (pessoas.isEmpty()) {
                    println("Nenhuma pessoa cadastrada ainda.")
                } else {
                    println("\nPessoas com altura ≤ 1.5m:")
                    val filtradas = pessoas.filter { it.altura <= 1.5 }
                    if (filtradas.isEmpty()) {
                        println("Nenhuma pessoa encontrada nesta faixa de altura.")
                    } else {
                        filtradas.forEach { println("Nome: ${it.nome}, Altura: ${it.altura}m") }
                    }
                }
            }
            3 -> {
                if (pessoas.isEmpty()) {
                    println("Nenhuma pessoa cadastrada ainda.")
                } else {
                    println("\nPessoas com altura > 1.5m:")
                    val filtradas = pessoas.filter { it.altura > 1.5 }
                    if (filtradas.isEmpty()) {
                        println("Nenhuma pessoa encontrada nesta faixa de altura.")
                    } else {
                        filtradas.forEach { println("Nome: ${it.nome}, Altura: ${it.altura}m") }
                    }
                }
            }
            4 -> {
                if (pessoas.isEmpty()) {
                    println("Nenhuma pessoa cadastrada ainda.")
                } else {
                    println("\nPessoas com altura > 1.5m e < 2.0m:")
                    val filtradas = pessoas.filter { it.altura > 1.5 && it.altura < 2.0 }
                    if (filtradas.isEmpty()) {
                        println("Nenhuma pessoa encontrada nesta faixa de altura.")
                    } else {
                        filtradas.forEach { println("Nome: ${it.nome}, Altura: ${it.altura}m") }
                    }
                }
            }
            5 -> {
                if (pessoas.isEmpty()) {
                    println("Nenhuma pessoa cadastrada ainda.")
                } else {
                    val media = pessoas.map { it.altura }.average()
                    println("\nMédia das alturas: ${"%.2f".format(media)}m")
                }
            }
            6 -> println("Saindo do programa...")
            else -> println("Opção inválida. Tente novamente.")
        }
    } while (opcao != 6)
}