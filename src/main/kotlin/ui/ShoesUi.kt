package org.example.ui

import org.example.data.Model.ShoesDTO
import org.example.data.shoesList
import org.example.domein.Request.ShoesAddRequest
import org.example.domein.Response.ShoesResponse
import org.example.domein.ShoesUseCase

class ShoesUi(private val shoesUseCase: ShoesUseCase){
    var shoesadd: ShoesResponse? = null

    fun Addshoes(){
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
            shoesId  = shoesadd!!.shoesId,
            shoesName = shoesname,
            shoesDescription = shoesDescription,
            shoesUrl = shoesUrl,
            category = category
        )
        shoesUseCase.addShoes(addShoesRequest)
    }

    fun showAllShoes(){
        shoesUseCase.returnAllShoes()
        println(ShoesResponseToString(shoesadd))
    }

    fun showShoes(shoesID:Int){
        shoesUseCase.returnShoes(shoesID)
        println(ShoesResponseToString(shoesadd))
    }

    fun removeShoes(shoesID:Int){
        shoesUseCase.returnShoes(shoesID)
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