package data.munging.weather

import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

class Weather {
    fun smallestTemperatureSpread(): Int {
        val csv = importCsvAllLines()

        var smallestTemperatureSpread = 0
        var targetDay = 0
        var isNotFirst = false
        var index = 0

        csv.forEachLine { line: String ->
            if (isNotFirst) {
                val row = line.split(",")

                if (row[0].contains("mo").not()) {
                    val maxT: Int = row[1].replaceAndToInt()
                    val minT: Int = row[2].replaceAndToInt()
                    val temperatureSpread = maxT - minT

                    if (index == 1) {
                        smallestTemperatureSpread = temperatureSpread
                    } else {
                        if (temperatureSpread < smallestTemperatureSpread) {
                            smallestTemperatureSpread = temperatureSpread
                            targetDay = row[0].replaceAndToInt()
                        }
                    }
                }
            } else {
                isNotFirst = true
            }
            index++
        }

        return targetDay
    }

    private fun String.replaceAndToInt(): Int {
        return this.replace("*", "").toInt()
    }

    private fun importCsvAllLines(): BufferedReader {
        return BufferedReader(
            InputStreamReader(
                FileInputStream("/Users/yutashoji/dev/codekata/data-munging/app/src/csv/weather-from-code-kata.csv")
            )
        )
    }
}