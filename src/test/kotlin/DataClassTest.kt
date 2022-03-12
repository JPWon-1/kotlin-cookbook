import kotlin.test.Test
import kotlin.test.assertEquals

class DataClassTest {
    @Test
    fun `data 클래스는 hashcode()를 생성한다`() {
        val p1 = Product("baseball", 10.0)
        val p2 = Product("baseball", 10.0, false)
        assertEquals(p1, p2)
        assertEquals(p1.hashCode(), p2.hashCode())
    }

    @Test
    fun `data 클래스는 equals()를 생성한다`() {
        val p1 = Product("baseball", 10.0)
        val p2 = Product(price = 10.0, onSale = false, name = "baseball")

        val products = setOf(p1, p2) //중복된 객체는 set에 추가되지 않음
        assertEquals(1, products.size)
    }


}

data class Product(
    val name: String,
    val price: Double,
    var onSale: Boolean = false
)