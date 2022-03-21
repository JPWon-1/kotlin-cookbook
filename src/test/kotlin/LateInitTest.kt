import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class LateInitDemo {
    lateinit var name: String

    fun initName() {
        println("before assignment : ${::name.isInitialized}")
        name = "WORLD"
        println("After assignment : ${::name.isInitialized}")
    }
}

class LateInitTest {
    // Lateinit과 lazy의 차이는?
    // lateinit 변경자는 var 속성에 사용된다.
    // lazy 대리자는 속성에 처음 접근할 때 평가되는 람다를 받는다.
    // 초기화 비용이 높은데 lazy를 사용한다면 초기화는 반드시 실패한다.
    // lazy는 val 속성에 사용할 수 있는 반면 lateinit은 var속성에만 적용할 수 있다.
    // 마지막으로 lateinit속성은 속성에 접근할 수 있는 모든 곳에서 초기화할 수 있기 때문에 앞의 예제에서처럼 객체 바깥쪽에서도 초기화 할 수 있다.
    @Test
    fun initName() {
        LateInitDemo().initName()
    }

    @Test
    fun `초기화되지 않은 lateinit 변수를 호출하면 UninitializedPropertyAccessException을 발생`() {
        assertThrows<UninitializedPropertyAccessException> {
            LateInitDemo().name
        }
    }

    @Test
    fun `lateinit 변수를 초기화 시키면 익셉션을 던지지 않는다`() {
        assertDoesNotThrow { LateInitDemo().apply { name = "Dolly" } }
    }
}