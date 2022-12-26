import java.util.*
import kotlin.system.exitProcess


fun main() {
    val peraturan = Rule()
    val masuk = Intro()
    masuk.sambutan()

    val input = Scanner(System.`in`)
    val pointList: MutableList<Any> = mutableListOf()

    var player1 = readLine()
    var player2 = readLine()
    var ronde_smntr: Int = 0
    var ronde: Int
    var lanjut: Char

    while (true) {
        println("Mau berapa ronde?")
        println("=====(Ronde)=====")
        println("Satu Ronde")
        println("Tiga Ronde")
        println("Ketik 0 untuk keluar")
        print("Masukkan Jumlah Ronde : ")
        ronde = input.next().toInt()

        when (ronde) {
            1 -> {
                print("Pemain 1 pilih petarungmu : ")
                player1 = input.next()
                print("Pemain 2 pilih petarungmu : ")
                player2 = input.next()
                peraturan.rules(player1, player2)

                print("Apakah kamu mau main lagi? (y/n) ")
                lanjut = input.next().single()
                if (lanjut == 'y') {
                    ronde = 2
                }
                if (lanjut == 'n') {
                    println("Terimakasih sudah bermain")
                }
            }

            3 -> {
                for (i in 1..10) {
                    if (ronde_smntr < ronde) {
                        print("1. Masukkan pemain 1: ")
                        player1 = input.next()
                        print("2. Masukkan pemain 2: ")
                        player2 = input.next()

                        val result = peraturan.rules(player1, player2)
                        println("")
                        println(result)
                        println("")
                        pointList += result
                        if (result == "Seri") {
                            ronde_smntr += 1
                        }
                    }
                    if (ronde_smntr == ronde) {
                        val countPlayerOneIsWinner = pointList.count { it == "Pemain 1 MENANG!" }
                        val countPlayerTwoIsWinner = pointList.count { it == "Pemain 2 MENANG!" }

                        println("Skor: Player 1 ($countPlayerOneIsWinner) vs Player 2 ($countPlayerTwoIsWinner) ")
                        if (countPlayerOneIsWinner > countPlayerTwoIsWinner) {
                            println("Selamat Player 1 MENANG!")
                        } else {
                            println("Selamat Player 2 MENANG!")
                        }

                        print("Apakah kamu mau main lagi? (y/n) ")
                        lanjut = input.next().single()
                        if (lanjut == 'y') {
                            ronde_smntr = 0
                            break
                        }
                        if (lanjut == 'n') {
                            println("")
                            println("Terimakasih sudah bermain")
                            exitProcess(0)
                        }
                    }
                }
            }
            0 ->{
                println("")
                println("Arigatou Gozaimasu Sudah Bermain Dengan Kami")
                exitProcess(0)
            }
            else -> println("Eror, mohon coba lagi")
        }
    }
}