@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1


import lesson1.task1.sqr
import java.lang.Math.*
import kotlin.math.sqrt

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result *= i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var number: Int = n
    var count: Int = 0
    do {
        count++
        number /= 10;
    } while (number != 0)

    return count
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var fib: Int = 1
    var fib1: Int = 1
    var fib2: Int = 2
    if (n <= 2) return 1
    else {
        for (i in 3..n) {
            fib2 = fib1 + fib
            fib = fib1
            fib1 = fib2
        }
    }
    return fib2
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {

    var i: Int = min(m, n)
    while (true) {
        if (i % m == 0 && i % n == 0) break
        i += 1
    }
    return (i)
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var i: Int = 2
    while (n.toDouble() % i.toDouble() != 0.0) i += 1
    return (i)
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var i: Int = n
    do {
        i -= 1
    } while (n.toDouble() % i.toDouble() != 0.0)
    return (i)
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    if (m == n) {
        return m == 1;
    } else {
        if (m > n) {
            return isCoPrime(m - n, n);
        } else {
            return isCoPrime(n - m, m);
        }
    }
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    var intSq: Boolean = false
    for (i in m..n) {
        if (sqrt(i.toDouble()) % 1.0 == 0.0) intSq = true
    }
    return intSq
}

/**
 * Средняя
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var currentX: Int = x
    var numOfIter: Int = 0
    while (currentX != 1) {
        if (currentX % 2 == 0) currentX /= 2
        else currentX = currentX * 3 + 1
        numOfIter++
    }
    return (numOfIter)
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */

fun sin(x: Double, eps: Double): Double {
    var i: Double = 3.0
    var res_x: Double = x
    var d: Double = x
    do {
        d *= (-x * x / (i * (i - 1.0)))
        res_x += d
        i += 2.0
    } while (d >= eps)
    return (res_x)
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var a: Int = n
    var ch: Int
    ch = 0
    while (a > 0) {
        ch = ch * 10 + a % 10
        a = a / 10
    }
    return ch
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    var N: Int = n
    var rev: Int = 0
    var dig: Int = 0
    while (N > 0) {
        dig = N % 10
        rev = rev * 10 + dig
        N /= 10
    }
    return n == rev
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean = digitCountInNumber(n, n % 10) != digitNumber(n)

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var i: Int = 0
    var len: Int = 0
    do {
        i++
        len += digitNumber(sqr(i))
    } while (len < n)
    val feb: Int = sqr(i)
    val derivative: Int = len - n
    return if (derivative == 0) {
        (feb % 10)
    } else {
        ((feb / (pow(10.0, derivative.toDouble()).toInt())) % 10)
    }
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    var i: Int = 0
    var len: Int = 0
    do {
        i++
        len += digitNumber(fib(i))
    } while (len < n)
    val feb: Int = fib(i)
    val derivative: Int = len - n
    return if (derivative == 0) {
        (feb % 10)
    } else {
        ((feb / (pow(10.0, derivative.toDouble()).toInt())) % 10)
    }
}
