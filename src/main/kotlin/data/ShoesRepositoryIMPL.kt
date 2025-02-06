import org.example.data.Model.ShoesDTO
import org.example.data.ShoesRepository
import org.example.data.shoesList
import org.example.domein.Request.ShoesAddRequest
import org.example.domein.Request.UpdateShoesRequest

class ShoesRepositoryImpl: ShoesRepository.ShoesRepository {
    private val shoesSource: MutableList<ShoesDTO> = shoesList.toMutableList()
    override fun addShoes(addShoesRequest: ShoesAddRequest): ShoesDTO {
        val newShoes = ShoesDTO(
            shoesId = shoesSource.size + 1,
            shoesName = addShoesRequest.shoesName,
            shoesDescription = addShoesRequest.shoesDescription,
            shoesURL = addShoesRequest.shoesUrl,
            cotegory = addShoesRequest.category
        )
        shoesSource.add(newShoes)
        return newShoes
    }

    override fun getAllShoes(): List<ShoesDTO> = shoesSource

    override fun removeShoes(shoesId: Int): Boolean {
        return shoesSource.removeIf { it.shoesId == shoesId }
    }

    override fun findShoesById(shoesId: Int): ShoesDTO? {
        return shoesSource.find { shoes -> shoesId == shoes.shoesId }
    }

    override fun addShoesById(updateShoesRequest: UpdateShoesRequest): ShoesDTO {
        val newShoes = ShoesDTO(
            shoesId = updateShoesRequest.shoesId,
            shoesName = updateShoesRequest.shoesName,
            shoesDescription = updateShoesRequest.shoesDescription,
            shoesURL = updateShoesRequest.shoesUrl,
            cotegory = updateShoesRequest.category,
        )
        shoesSource.add(newShoes)
        return newShoes
    }
}