import kotlin.test.Test
import kotlin.test.assertEquals

class LazyLoadingProperty02 {
    // 클래스의 속성을 클라이언트에게 노출하고 싶지만 해당 속성을 초기화하거나 읽는 방법을 제어해야할 때 사용하는 방법
    // lazy 대리자를 사용하여 좀 더 쉽게 코딩할 수 있다.
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

class Customer02(val name: String) {

    val messages: List<String> by lazy { loadMessages() }

    private fun loadMessages(): MutableList<String> =
        mutableListOf(
            "Initial contact",
            "Convinced them to use Kotlin",
            "Sold training class. Sweet."
        ).also { println("loaded messages") }
}

