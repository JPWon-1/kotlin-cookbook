import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

interface IStaticHelper {
    fun foo() : String
    fun bar() : String
}

class StaticHelper {
    companion object : IStaticHelper {
        override fun foo() = "foo"
        override fun bar() = "bar"
    }
}

class Caller(private val helper: IStaticHelper = StaticHelper.Companion) {
    fun callsTheHelper(): String {
        return helper.foo()
    }
}

class CompanionObjectTest {
    @Test
    fun testCallsTheHelper() {
//        val helper = mock();
//        val caller = Caller(helper)
//        Assertions.assertThat(caller.callsTheHelper()).isEqualTo("foo")
    }
}