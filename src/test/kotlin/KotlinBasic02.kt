import kotlin.test.Test

// 사용자 정의 획득자와 설정자 생성
class KotlinBasic02 {

    @Test
    fun `Task클래스를 인스턴스화 할 때 priority에 값을 할당할 수 없다`() {
        // apply 를 통해서 속성을 정의할 수 있지만 생성자를 통해 인스턴스화 할 때는 불가능 함.
        var myTask1 = Task("JP").apply{ priority = 4 }
        var myTask2 = Task("JP")
        println(myTask1.priority) //4
        println(myTask1.name)
        println(myTask2.priority) //3
        println(myTask2.name)
    }

}

class Task(val name: String) {
    var priority = 3;
}