import org.example.domein.Request.GetAllFilterShoesRequest
import org.example.domein.Request.ShoesAddRequest
import org.example.domein.Request.UpdateShoesRequest
import org.example.domein.Response.ShoesResponse
import org.example.domein.ShoesUseCase

class ShoesUi(private val shoesUseCase: ShoesUseCase) {

    fun addShoes() {
        println("Введите название обуви: ")
        val shoesName = readlnOrNull()
        checkNotNull(shoesName) {
            "Имя не должно отсутствовать."
        }
        println("Введите описание обуви: ")
        val desc = readlnOrNull()
        checkNotNull(desc) {
            "Описание не должно отсутствовать."
        }
        println("Введите url обуви: ")
        val url = readlnOrNull()
        checkNotNull(url) {
            "url не должен отсутствовать."
        }
        println("Введите категорию обуви: ")
        val category = readlnOrNull()
        checkNotNull(category) {
            "Категория не должна отсутствовать."
        }
        val addShoesRequest = ShoesAddRequest(
            shoesName = shoesName,
            shoesDescription = desc,
            shoesUrl = url,
            category = category,
        )
        val shoes = shoesUseCase.addShoes(addShoesRequest)
        println(ShoesResponseToString(shoes))
    }

    fun ShoesResponseToString(shoesResponse: ShoesResponse): String{
        val printOutput = StringBuilder()
        printOutput.append("shoesName: ${shoesResponse.shoesName}")
        printOutput.appendLine()
        printOutput.append("shoesDesc: ${shoesResponse.shoesDescription}")
        printOutput.appendLine()
        printOutput.append("shoesUrl: ${shoesResponse.shoesUrl}")
        printOutput.appendLine()
        printOutput.append("category: ${shoesResponse.category}")
        printOutput.appendLine()
        return printOutput.toString()
    }

    fun getAllFilterShoes() {
        println("Введите фильтр по названию (без фильтра - нажмите enter)")
        val shoesName = readlnOrNull()
        val getAllFilterShoesRequest = GetAllFilterShoesRequest(
            shoesName = shoesName.toString()
        )
        val shoesList = shoesUseCase.getAllFilterShoes(getAllFilterShoesRequest)
        println("Найденная обувь по ващему запросу:")
        printShoesList(shoesList)
    }

    fun updateShoes() {
        println("Введите айди обуви, которую вы хотте обновить")
        val shoesId = Integer.parseInt(readln())
        println("Введите название обуви: ")
        val shoesName = readlnOrNull()
        checkNotNull(shoesName) {
            "Имя не должно отсутствовать."
        }
        println("Введите описание обуви: ")
        val desc = readlnOrNull()
        checkNotNull(desc) {
            "Описание не должно отсутствовать."
        }
        println("Введите url обуви: ")
        val url = readlnOrNull()
        checkNotNull(url) {
            "url не должен отсутствовать."
        }
        println("Введите категорию обуви: ")
        val category = readlnOrNull()
        checkNotNull(category) {
            "Категория не должна отсутствовать."
        }
        val updateShoesRequest = UpdateShoesRequest(
            shoesId = shoesId,
            shoesName = shoesName,
            shoesDescription = desc,
            shoesUrl = url,
            category = category,
        )
        val shoes = shoesUseCase.updateShoes(updateShoesRequest)
        println(ShoesResponseToString(shoes))
    }

    fun removeShoesById() {
        println("Ведтите айди обуви, которую хотите удалить:")
        val shoesId = Integer.parseInt(readln())
        val isRemoved = shoesUseCase.removeShoesById(shoesId)
        if (isRemoved) {
            println("Успешно удалено")
        }
        else (println("что- то пошло не так"))
    }

    private fun printShoesList(shoesResponseList: List<ShoesResponse>) {
        shoesResponseList.forEach { shoesResponse -> println(shoesResponse.shoesName) }
    }

}