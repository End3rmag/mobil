package org.example.ui

data class MainMenuUi( val userUi: UserUi, var shoesUi: ShoesUi) {
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
            println(e.message)
            shoesUi.shoesadd.let {
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
        "3.Мои товары",
        "4.Каталог",
        "5.Выйти"

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
                displayMyKatalog()
            }
            4->{
                displayKatalog()
            }
            5->{
            return
            }
            else->{
                displayAutorizationMenu()
            }
        }
    }
    val myKatalog = listOf(
        "1.Создать объявление",
        "2.Удалить объявление",
        "3.Выйти"
    )

    fun displayMyKatalog(){
        println(myKatalog.joinToString("\n"))
        val menuPos = readlnOrNull()?.toIntOrNull()
        if (menuPos == null) displayMyKatalog()
        when (menuPos){
            1->{
                dispMenuItem {
                    shoesUi.Addshoes()
                    displayMyKatalog()
                }
            }
            2->{
                dispMenuItem {
                    shoesUi.removeShoes(shoesUi)
                    displayMyKatalog()
                }
            }
            3->{
                return(displayMenuForAutorization())
            }
            else->{
                displayMyKatalog()
            }
        }
    }

    val katalogs = listOf(
        "1.Посмотореть все",
        "2.Найти товар",
        "3.Выйти"
    )

    fun displayKatalog(){
        println(katalogs.joinToString("\n"))
        val menuPos = readlnOrNull()?.toIntOrNull()
        if (menuPos == null) displayKatalog()
        when (menuPos){
            1->{
                dispMenuItem {
                    shoesUi.showAllShoes()
                    displayKatalog()
                }
            }
            2->{
                dispMenuItem {
                    println("Введите номер товара")
                    val nado = readlnOrNull()?.toIntOrNull()
                    checkNotNull(nado)
                    shoesUi.showShoes(nado)
                    displayKatalog()
                }
            }
            3->{
                return(displayMenuForAutorization())
            }
            else->{
                displayKatalog()
            }
        }
    }
}