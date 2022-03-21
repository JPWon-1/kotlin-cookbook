import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SingletonTest {
    @Test
    fun callSingleton() {
        assertEquals(mySingleton.myProperty, 3)
        assertEquals(mySingleton.myFunction(), "HELLO")
    }
}

// 코틀린에서 싱글톤은 class 대신 object만 선언하면 된다.
// 이를 객체 선언 이라고 한다(object declaration)
object mySingleton {
    val myProperty = 3
    fun myFunction() = "HELLO"
}