package data.munging

import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

class Weather {
    fun getSmallestTemperatureSpread(): Int {
        val csv = importCsvAllLines()

        var smallestTemperatureSpread = 0
        var isNotFirst = false

        csv.forEachLine { line: String ->
            if (isNotFirst) {
                val row = line.split(",")

                if (row[0].contains("mo").not()) {

                    val maxT: Int = row[1].replace("*", "").toInt()
                    val minT: Int = row[2].replace("*", "").toInt()

                    val temperatureSpread = maxT - minT

                    if (temperatureSpread < smallestTemperatureSpread) {
                        smallestTemperatureSpread = temperatureSpread
                    }
                }
            } else {
                isNotFirst = true
            }
        }

        return smallestTemperatureSpread
    }

    private fun importCsvAllLines(): BufferedReader {
        return BufferedReader(
            InputStreamReader(
                FileInputStream("/Users/yutashoji/dev/codekata/data-munging/app/src/main/kotlin/data/munging/weather-from-code-kata.csv")
            )
        )
    }
}
