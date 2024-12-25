import kotlin.math.sqrt
import kotlin.math.pow

data class Point(val x: Double, val y: Double) {

    fun distanceTo(other: Point): Double {
        return sqrt((other.x - x).pow(2) + (other.y - y).pow(2))
    }
}

fun main() {
    try {
        println("Введите количество точек (должно быть больше 2):")
        val n = readLine()!!.toInt()
        if (n <= 2) throw IllegalArgumentException("Количество точек должно быть больше двух.")

        val points = mutableListOf<Point>()

        for (i in 1..n) {
            println("Введите координаты точки $i (x y):")
            val (x, y) = readLine()!!.split(" ").map { it.toDoubleOrNull() ?: throw IllegalArgumentException("Некорректный ввод координат.") }
            val newPoint = Point(x, y)
            if (newPoint in points) throw IllegalArgumentException("Точки не должны совпадать.")
            points.add(newPoint)
        }

        var minDistance = Double.MAX_VALUE
        var maxDistance = Double.MIN_VALUE

        for (i in 0 until points.size) {
            for (j in i + 1 until points.size) {
                val distance = points[i].distanceTo(points[j])
                if (distance < minDistance) minDistance = distance
                if (distance > maxDistance) maxDistance = distance
            }
        }

        println("Минимальное расстояние между точками: $minDistance")
        println("Максимальное расстояние между точками: $maxDistance")

    } catch (e: Exception) {
        println("Ошибка: ${e.message}. Убедитесь, что вводите данные корректно.")
    }
}
