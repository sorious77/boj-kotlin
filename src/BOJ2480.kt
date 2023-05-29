fun main() {
    var numbers = readln().split(" ").map { it.toInt() }

    numbers = numbers.sortedDescending()

    if(numbers[0] == numbers[2]) {
        println("${10000 + 1000 * numbers[0]}")
    } else if((numbers[0] == numbers[1]) || (numbers[1] == numbers[2])) {
        println("${1000 + 100 * numbers[1]}")
    } else {
        println("${100 * numbers[0]}")
    }
}