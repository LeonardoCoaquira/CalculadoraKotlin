import kotlin.math.pow
import kotlin.math.sqrt

interface OperacionesBasicas {
    fun suma(num1: Double, num2: Double): Double
    fun resta(num1: Double, num2: Double): Double
    fun multiplicacion(num1: Double, num2: Double): Double
    fun division(num1: Double, num2: Double): Double
}

interface OperacionesAvanzadas {
    fun potencia(numero: Double, potencia: Double): Double
    fun raiz(numero: Double, raiz: Double): Double
    fun factorial(numero: Double): Double
    fun sumatoria(numero: Double): Double
}

class ImplementacionOperaciones : OperacionesBasicas, OperacionesAvanzadas {
    override fun suma(num1: Double, num2: Double): Double {
        return num1 + num2
    }

    override fun resta(num1: Double, num2: Double): Double {
        return num1 - num2
    }

    override fun multiplicacion(num1: Double, num2: Double): Double {
        return num1 * num2
    }

    override fun division(num1: Double, num2: Double): Double {
        if (num2 == 0.0) {
            println("Error: No es posible dividir entre cero")
            return Double.NaN
        } else {
            return num1 / num2
        }
    }

    override fun potencia(numero: Double, potencia: Double): Double {
        return numero.pow(potencia)
    }

    override fun raiz(numero: Double, raiz: Double): Double {
        return numero.pow(1 / raiz)
    }

    override fun factorial(numero: Double): Double {
        if (numero == 0.0) {
            return 1.0
        } else {
            return numero * factorial(numero - 1)
        }
    }

    override fun sumatoria(numero: Double): Double {
        return (1..numero.toInt()).sum().toDouble()
    }

    fun mostrarMenu() {
        while (true) {
            println("Indique la acción que desea realizar:")
            println("1. Suma")
            println("2. Resta")
            println("3. Multiplicación")
            println("4. División")
            println("5. Potencia")
            println("6. Raíz")
            println("7. Factorial")
            println("8. Sumatoria")
            println("9. Salir")

            print("Ingrese el número de la opción deseada: ")
            val opcion = readLine()

            when (opcion) {
                "9" -> {
                    println("¡Hasta luego!")
                    return
                }
                "1", "2", "3", "4" -> {
                    print("Ingrese el primer número: ")
                    val num1 = readLine()?.toDoubleOrNull() ?: run {
                        println("Error: Valor inválido. Intente de nuevo.")
                        return
                    }

                    print("Ingrese el segundo número: ")
                    val num2 = readLine()?.toDoubleOrNull() ?: run {
                        println("Error: Valor inválido. Intente de nuevo.")
                        return
                    }

                    val resultado = when (opcion) {
                        "1" -> suma(num1, num2)
                        "2" -> resta(num1, num2)
                        "3" -> multiplicacion(num1, num2)
                        "4" -> division(num1, num2)
                        else -> 0.0
                    }

                    println("El resultado es: $resultado")
                }
                "5", "6", "7", "8" -> {
                    print("Ingrese el número: ")
                    val numero = readLine()?.toDoubleOrNull() ?: run {
                        println("Error: Valor inválido. Intente de nuevo.")
                        return
                    }

                    val resultado = when (opcion) {
                        "5" -> potencia(numero, 2.0)
                        "6" -> raiz(numero, 2.0)
                        "7" -> factorial(numero)
                        "8" -> sumatoria(numero)
                        else -> 0.0
                    }

                    println("El resultado es: $resultado")
                }
                else -> {
                    println("Error: Opción inválida. Intente de nuevo.")
                }
            }

            print("¿Desea realizar otra operación? (S/N): ")
            val otraOperacion = readLine()?.toUpperCase()
            if (otraOperacion != "S") {
                println("¡Hasta luego!")
                return
            }
        }
    }
}

fun main() {
    val implementacionOperaciones = ImplementacionOperaciones()
    implementacionOperaciones.mostrarMenu()
}