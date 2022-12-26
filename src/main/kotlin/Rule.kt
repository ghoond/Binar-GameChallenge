class Rule {
    private var status: String = ""

    fun rules(player1: String, player2: String): String {
        if (player1.lowercase().equals(player2.lowercase())) {
            status = "SERI"
        } else if (player1.lowercase().equals("batu")) {
            return if (player2.lowercase().equals("gunting")) {
                "Pemain 1 MENANG!"
            } else {
                "Pemain 2 MENANG!"
            }
        } else if (player1.lowercase().equals("gunting")) {
            return if (player2.lowercase().equals("kertas")) {
                "Pemain 1 MENANG!"
            } else {
                "Pemain 2 MENANG!"
            }
        } else if (player1.lowercase().equals("kertas")) {
            return if (player2.lowercase().equals("batu")) {
                "Pemain 1 MENANG!"
            } else {
                "Pemain 2 MENANG!"
            }
        }
        return TODO("Provide the return value")
    }
}