import kotlin.test.Test
import kotlin.test.assertEquals

class LazyLoadingProperty01 {
    // 클래스의 속성을 클라이언트에게 노출하고 싶지만 해당 속성을 초기화하거나 읽는 방법을 제어해야할 때 사용하는 방법
    @Test
    fun `load messages` () {
        val customer = Customer("Fred").apply { messages }
        val customer2 = Customer("Fred")
        val listOfString = listOf<String>("a", "b", "c")
        println("listofString==="+listOfString.toString())
        val customer3 = Customer("Fred").apply { listOfString }
        assertEquals(3,customer.messages.size)
        assertEquals(3,customer2.messages.size)
        println(customer.messages.toString())
        println(customer2.messages.toString())
        println(customer3.messages.toString())
    }
}

class Customer(val name: String) {
    private var _messages : List<String>? = null

    val messages : List<String>
        get() {
            if(_messages == null ) {
                _messages = loadMessages()
            }
            return _messages!! // !! 은 null 이 아님을 단언함.
        }

    private fun loadMessages(): MutableList<String> =
        mutableListOf(
            "Initial contact",
            "Convinced them to use Kotlin",
            "Sold training class. Sweet."
        ).also { println("loaded messages") }
}

