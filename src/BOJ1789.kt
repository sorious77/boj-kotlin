fun main() {
    var number = readln().toLong()

    if(number == 1L) {
        println(1)
        return
    }

    var answer = 0

    for(i in 1 until number) {
        if(number >= i) {
            number -= i
            answer += 1
        } else break
    }

    println(answer)
}