val scanner = Scanner(System.`in`)

import java.lang.System.exit
import java.util.*

fun mainMenu() : int {
    println("")
    println("---------")
    println("NOTE KEEPER APP")
    println("---------")
    println("NOTE MENU")
    println("1) Add a note")
    println("2) List all notes")
    println("3) Update a note")
    println("4) Delete a note")
    println("---------")
    println("0) Exit")
    println("---------")
    print ("==>> ")
    return scanner.nextInt()
}

fun runMenu() {
    do {
        val option = mainMenu()
        when (option) {
            1  -> addNote()
            2  -> listNotes()
            3  -> updateNote()
            4  -> deleteNote()
            0  -> exitApp()
            else -> println("Invalid option entered: " + option)
        }
    } while (true)
}

fun addNote() {
    println("You chose add note")
}
fun listNotes() {
    println("You chose list notes")
}
fun updateNote() {
    println("You chose update note")
}
fun deleteNote() {
    println("You chose delete note")
}
fun exitApp() {
    println("Exiting...bye")
    exit(0)
}