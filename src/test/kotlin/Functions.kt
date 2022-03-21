import org.junit.jupiter.api.Test
import java.math.BigInteger
import kotlin.test.assertEquals

class Functions {

    // fold 함수는 배열 또는 반복 가능한 컬렉션에 적용할 수 있는 축약 연산이다.
    @Test
    fun `sum using fold`() {
        val numbers = intArrayOf(3, 1, 4, 1, 5, 9)
        assertEquals(numbers.sum(), sumWithTrace(*numbers))
    }

    fun sumWithTrace(vararg nums: Int) = nums.fold(0) { acc, n ->
        println("acc = $acc, n = $n")
        acc + n
    }

    @Test
    fun `factorial`() {
        recursiveFactorial(10)
        factorialFold(10);
    }

    // 아래와 같은 재귀함수를 fold함수를 사용하여 다시 짤 수 있다.
    fun recursiveFactorial(n: Long): BigInteger =
        when (n) {
            0L, 1L -> BigInteger.ONE
            else -> BigInteger.valueOf(n) * recursiveFactorial(n - 1)

        }

    fun factorialFold(n: Long): BigInteger =
        when (n) {
            0L, 1L -> BigInteger.ONE
            else -> (2..n).fold(BigInteger.ONE) { acc, i ->
                println("$acc $i")
                acc * BigInteger.valueOf(i)
            }
        }

    // 피보나치
    fun fibonacciFold(n: Int) =
        (2 until n).fold(1 to 1) { (prev, curr), _ ->
            curr to ( prev + curr )}.second
}








