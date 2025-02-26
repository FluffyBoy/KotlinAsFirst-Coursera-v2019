@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr
import java.lang.Math.pow
import kotlin.math.abs

import kotlin.math.sqrt

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean = when {
    number / 1000 + (number / 100) % 10 == (number / 10) % 10 + number % 10 -> true
    else -> false
}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */

fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean = when {
    x1 == x2 || y1 == y2 || abs(x1 - x2) == abs(y1 - y2) -> true
    else -> false
}


/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
    val viscouse: Boolean = when {
        year % 400 == 0 -> true
        year % 100 == 0 -> false
        year % 4 == 0 -> true
        else -> false
    }
    if (month == 2 && viscouse) return 29
    else {
        return when (month) {
            1 -> 31
            2 -> 28
            3 -> 31
            5 -> 31
            7 -> 31
            8 -> 31
            10 -> 31
            12 -> 31
            else -> 30
        }
    }
}

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean = when {
    r1 + sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) <= r2 -> true
    else -> false
}

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
    val max_side: Int = maxOf(a, b, c)
    var min_max_side: Int=0
    var min_min_side: Int=0
    if (max_side == a) {
        min_max_side = maxOf(b, c)
        min_min_side = minOf(b, c)
    }
    if (max_side == b) {
        min_max_side = maxOf(a, c)
        min_min_side = minOf(a, c)
    }
    if (max_side == c) {
        min_max_side = maxOf(b, a)
        min_min_side = minOf(b, a)
    }
    val max_dim: Int = maxOf(r, s)
    val min_dim: Int = minOf(r, s)
    return when {
        min_dim >= min_min_side && max_dim >= min_max_side -> true
        else -> false
    }
}
