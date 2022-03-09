import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.assertAll
import kotlin.test.Test
import kotlin.test.assertEquals

class KotlinBasic01 {

    // 변수가 절대 널값을 허용하지 못하도록 하기 위해서는
    // 1. 물음표를 사용하지 않고 변수의 타입을 정의한다
    // 2. 널허용 타입을 사용할 경우 안전 호출 연산자(?.)나 엘비스 연산자(?:)와 결합해서 사용한다
    @Test
    fun `널 할당이 불가능한 변수 선언`(){
        var name: String
        name = "JP"
//        name = null // null can not be a value of a non-null type String

        class Person(val first: String,
                     val middle: String?,
                     val last: String
        )
        val jkRowling = Person("Joanne",null,"Rowling")
        val northWest = Person("North",null,"West")

        Assertions.assertEquals(name,"JP")
        Assertions.assertEquals(jkRowling.middle,null)
        Assertions.assertEquals(northWest.middle,null)
        val p = Person(first = "North", middle = null, last = "West")
        val middleLength = p.middle?.length;
//        val assertMiddleLength = p.middle!!.length;// null이 아님을 단언함.
        // !!. 문법은 꼭 필요한 경우가 아닌 경우 사용하지 말 것!
        val elvisMiddleLength = p.middle?.length ?: 0
        assertEquals(middleLength, null)
        assertEquals(elvisMiddleLength, 0)
        // !! 널 아님 단언 연산자가 하나라도 있다면 이는 코드 스멜이다!
        // 널 포인터 익셉션이 발생할 수 있는 여지를 만들 수 있다.

        // 타입세이프티하게 할당하기
        val personSafeType = p as? Person
    }

    @Test
    fun `to로 Pair 인스턴스 생성하기`(){
        val map = mapOf("a" to 1, "b" to 2, "c" to 3)
        assertAll(
            {assertThat(map.containsKey("a"))},
            {assertThat(map.containsKey("b"))},
            {assertThat(map.containsKey("c"))},
            {assertThat(map.containsValue(1))},
            {assertThat(map.containsValue(2))},
            {assertThat(map.containsValue(3))},
        )
    }

    @Test
    fun `생성자로 Pair만들기`(){
        val p1 = Pair("a",1)
        val p2 = "a" to 1
        assertThat(p1 == p2)

        // Pair 클래스 구조 분해
        val(x,y) = p1
        assertThat("a" == x)
        assertThat(1 == y)
    }

    // 컴파일 타임 상수 const
    // 컴파일 타임 상수는 반드시 객체나 동반 객체(companion object) 의 상위 속성 또는 멤버여야 한다
    // 컴파일 타임 상수는 문자열 또는 기본 타입이여야 한다.
    // 컴파일 타임 상수는 게터를 가질수 없다.
    // 컴파일 타임 상수는 컴파일 시점에 값을 사용할 수 있도록 메인 함수를 포함한 모든 함수의 바깥쪽에서 할당돼어야 한다.
    
}