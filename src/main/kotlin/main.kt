fun main(args: Array<String>) {
    println("Hello World!")

    //args[0]的意思为：从命令行接收第一个字符串参数
    //命令行运行此代码：
    //$ kotlinc main.kt  //编译成MainKt.class
    //$ kotlin MainKt 123 ----> 输出 Hello 123
    //Customer(args[0]).greet()
    Customer("sekai").greet()

    val dog = Dog("Wang Jiaming", 126)
    println(dog.dogName)
    dog.dogWeight = 128

    println(add3Nums(1,2,3))

    println(variMul(1,3,5,7,8))

    val cat : Cat = BigCat("Lei")
    cat.sayHello()

    //声明可为空的参数
    var myStr : String? = "Wang Ximing"
    println(myStr)
    myStr = null
    println(myStr)

    //when语法
    cases("Hello")
    cases(6L)
    cases(6)
    cases("I don't know")

    println(whenAssign("Hello"))
    val tiger : Tiger = Dongbeihu("Wang Jiaming")
    println("The Dongbeihu comes from " + tiger.origin)
    tiger.sayHello()

    val tiger2 = Tiger("Wang Ximing", "Hunan")
    tiger2.sayHello()
}

//val是不变变量， var是可变变量
class Dog(val dogName: String, var dogWeight: Int)

//省略函数体
fun add3Nums(a:Int, b:Int, c:Int) = a + b + c

//多个变量用vararg
fun variMul(vararg v:Int): Int{
    var sum = 0
    for (vt in v){
        sum += vt
    }
    return sum
}

open class Cat(val name: String){
    open fun sayHello(){
        print("Meow meow")
    }
}

//继承
class BigCat(val name2: String) : Cat(name = name2) {
    //重写
    override fun sayHello() {
        println("$name say Meow!!!")
        println("$name2 say Meow too!!!")
    }
}

class Customer(private val name : String){
    fun greet(){
        println("Hello $name!")
    }
}

fun cases(obj : Any){
    when(obj){
        1 -> println("One")
        "Hello" -> println(obj)
        is Long -> println("A long number")
        !is String -> println("Is not a string")
        else -> println("Unknown")
    }
}

fun whenAssign(obj: Any): Any {
    return when (obj) {
        1 -> "One"
        "Hello" -> true
        is Long -> "A long number"
        !is String -> "Is not a string"
        else -> "Unknown"
    }
}

open class Tiger(val name: String, val origin : String){
    fun sayHello(){
        println("$name, The tiger from $origin says: Goah!")
    }
}

class Dongbeihu(name: String) : Tiger(name = name, origin = "Northeast China")