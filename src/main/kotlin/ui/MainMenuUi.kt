package org.example.ui

data class MainMenuUi(private val userUi: UserUi) {

    val menuItems = listOf(
        "1.Авторизоваться",
        "2.Зарегистрироваться",
        "3.Выйти"
    )

    private fun dispMenuItem(menuItem: () -> Unit){
        try {
            menuItem()
        }catch (e:Exception){
            println(e.message)
            userUi.userauto?.let {
                displayMenuForAutorization()
                }
        }

    }
    fun displayAutorizationMenu() {
        println(menuItems.joinToString("\n"))
        val menuPos = readlnOrNull()?.toIntOrNull()
        if (menuPos == null) displayAutorizationMenu()
        when (menuPos){
            1 ->{
                    dispMenuItem {
                        userUi.autorize()
                        displayMenuForAutorization()
                    }
            }
            2 -> {
                dispMenuItem {
                    userUi.registration()
                    displayAutorizationMenu()
                }
            }
            3->return
            else -> {
                displayAutorizationMenu()
            }
        }
    }

    val profilItems = listOf(
        "1.Сменить пароль",
        "2.Изменить профиль",
        "3.Выйти"

    )
    fun displayMenuForAutorization(){
        println(profilItems.joinToString("\n"))
        val menuPos = readlnOrNull()?.toIntOrNull()
        if (menuPos == null) displayMenuForAutorization()
        when (menuPos){
            1->
                dispMenuItem{
                userUi.changePassword()
                    displayMenuForAutorization()
            }
            2->
                dispMenuItem{
                userUi.changeProfile()
                    displayMenuForAutorization()
            }
            3->{
                return
            }
            else->{
                displayAutorizationMenu()
            }
        }
    }
}