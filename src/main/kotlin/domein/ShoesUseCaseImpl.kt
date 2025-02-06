import org.example.data.ShoesRepository
import org.example.domein.Request.GetAllFilterShoesRequest
import org.example.domein.Request.ShoesAddRequest
import org.example.domein.Request.UpdateShoesRequest
import org.example.domein.Response.ShoesResponse
import org.example.domein.ShoesDTOToShoesResponse
import org.example.domein.ShoesUseCase

class ShoesUseCaseImpl(private val shoesRepository: ShoesRepository.ShoesRepository): ShoesUseCase {
    override fun addShoes(addShoesRequest: ShoesAddRequest): ShoesResponse {
        val isUnique = shoesRepository.getAllShoes().filter {
                shoes -> shoes.shoesName == addShoesRequest.shoesName
        }
        if (isUnique.isNotEmpty()) {
            throw IllegalArgumentException("Такое имя уже существует.")
        }
        val newShoes = shoesRepository.addShoes(addShoesRequest)
        return ShoesDTOToShoesResponse(newShoes)
    }

    override fun getAllFilterShoes(getAllFilterShoesRequest: GetAllFilterShoesRequest): List<ShoesResponse>  {
        val shoesList = shoesRepository.getAllShoes()

        return shoesList
            .filter { shoes ->
                getAllFilterShoesRequest.shoesName?.let { name ->
                    shoes.shoesName.contains(name, ignoreCase = true)
                } ?: true
            }
            .map { shoes -> shoes.mapToShoesResponse() }
    }

    override fun updateShoes(updateShoesRequest: UpdateShoesRequest): ShoesResponse {
        shoesRepository.findShoesById(updateShoesRequest.shoesId)
            ?: throw IllegalArgumentException("Такого id не существует")
        shoesRepository.removeShoes(updateShoesRequest.shoesId)
        val shoesDTO = shoesRepository.addShoesById(updateShoesRequest)
        return shoesDTO.mapToShoesResponse()
    }

    override fun removeShoesById(shoesId: Int): Boolean {
        return shoesRepository.removeShoes(shoesId)
    }


}