package org.example.ui

import org.example.domein.Request.ShoesAddRequest
import org.example.domein.Response.ShoesResponse
import org.example.domein.ShoesUseCase

class ShoesUi(private val shoesUseCase: ShoesUseCase){
    var shoesadd: ShoesResponse? = null

    fun Addshoes() {
        println("Назовите товар!")
        val shoesname = readlnOrNull()
        checkNotNull(shoesname){
            "Имя должно быть указано"
        }
        println("Дайте описание товару")
        val shoesDescription = readlnOrNull()

        println("Задайте URL")
        val shoesUrl = readlnOrNull()

        println("Назначте категорию")
        val category = readlnOrNull()

        val addShoesRequest = ShoesAddRequest(
            shoesId = shoesadd!!.shoesId,
            shoesName = shoesname,
            shoesDescription = shoesDescription,
            shoesUrl = shoesUrl,
            category = category
        )
        val shoe = shoesUseCase.addShoes(addShoesRequest)
        shoesadd=shoe
        println(ShoesResponseToString(shoe))
    }

    fun showAllShoes(){
        val vseshoes = shoesUseCase.returnAllShoes()
        println("Название${ vseshoes.map { shoesUi -> shoesUi.shoesName }}")
        println("Ссылка${ vseshoes.map { shoesUi -> shoesUi.shoesUrl } }")
        println("Описание${ vseshoes.map { shoesUi -> shoesUi.shoesDescription } }")
        println("Категория${vseshoes.map { shoesUi ->shoesUi.category}}")


    }

    fun showShoes(shoesID:Int){
        val search = shoesUseCase.returnShoes(shoesID)
        println(ShoesResponseToString(search))
    }

    fun removeShoes(shoesID: ShoesUi){
        val delete = readln()
            shoesUseCase.removeShoes(delete.toInt())
        println("Товар удалён")
    }


    fun ShoesResponseToString(shoesResponse: ShoesResponse?): String{
        val printOutput = StringBuilder()
        printOutput.append("${shoesResponse?.shoesName}\n")
        printOutput.appendLine()
        if(!shoesResponse?.shoesDescription.isNullOrBlank()){
            printOutput.appendLine()
            printOutput.append(shoesResponse?.shoesDescription)
        }
        if(!shoesResponse?.shoesUrl.isNullOrBlank()){
            printOutput.appendLine()
            printOutput.append(shoesResponse?.shoesUrl)
        }
        if(!shoesResponse?.category.isNullOrBlank()){
            printOutput.appendLine()
            printOutput.append(shoesResponse?.category)
        }
        return printOutput.toString()
    }
}