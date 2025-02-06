package org.example.ui

import ShoesUi

data class MainMenuUi( val userUi: UserUi, var shoesUi: ShoesUi) {
    val menuItems = listOf(
        "1.Авторизоваться",
        "2.Зарегистрироваться",
        "3.Выйти"
    )

    private fun dispMenuItem(menuItem: () -> Unit){
        try {
            menuItem()
        }catch (e:Exception) {
            println(e.message)
            userUi.userauto?.let {
                displayMenuForAutorization()
                return
            }
            displayAutorizationMenu()
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
        "3.Каталог",
        "4.Выйти"

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
                displayKatalog()
            }
            4->{
            return
            }
            else->{
                displayAutorizationMenu()
            }
        }
    }
    val Katalog = listOf(
        "1.Посмотреть каталог",
        "2.Мои Объявления",
        "4.Выйти"
    )

    fun displayKatalog(){
        println(Katalog.joinToString("\n"))
        val menuPos = readlnOrNull()?.toIntOrNull()
        if (menuPos == null) displayKatalog()
        when (menuPos){

            1-> {
                dispMenuItem {
                    shoesUi.getAllFilterShoes()
                    displayKatalog()
                }
            }
            2->{
                dispMenuItem {
                    dispMyKatalog()
                }
            }
            3->{
                return (displayMenuForAutorization())
            }
            else->{
                displayKatalog()
            }
        }
    }

    val Mykatalog  = listOf(
        "1.Создать",
        "2.Редактировать",
        "3.Удалить",
        "4.Выход"
    )

    fun  dispMyKatalog(){
        println(Mykatalog.joinToString ("\n"))
        val menuPos = readlnOrNull()?.toIntOrNull()
        if(menuPos == null) dispMyKatalog()
        when(menuPos){

            1->{

            }
            2->{

            }
            3->{

            }
            4->{
                return displayKatalog()
            }
            else->{
                dispMyKatalog()
            }
        }
    }

}