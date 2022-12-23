package data.munging.weather

import data.munging.DefaultService

class Weather(private val service: DefaultService) {
    fun smallestTemperatureSpread(): Int {
        val csvPath = "/Users/yutashoji/dev/codekata/data-munging/app/src/csv/weather-from-code-kata.csv"
        val csv = service.importCsv(csvPath)

        var smallestTemperatureSpread = 0
        var targetDay = 0
        var isNotFirst = false
        var index = 0

        csv.forEachLine { line: String ->
            val row = line.split(",")
            if (isNotFirst && row[0].contains("mo").not()) {

                val maxT: Int = row[1].replaceAndToInt()
                val minT: Int = row[2].replaceAndToInt()
                val temperatureSpread = maxT - minT

                if (index == 1 || temperatureSpread < smallestTemperatureSpread) {
                    smallestTemperatureSpread = temperatureSpread
                    targetDay = row[0].replaceAndToInt()
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
}
