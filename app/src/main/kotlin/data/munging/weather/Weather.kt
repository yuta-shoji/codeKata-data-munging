package data.munging.weather

import data.munging.DefaultService

class Weather(private val service: DefaultService) {
    fun smallestTemperatureSpread(): Int {
        val csvPath = "/Users/yutashoji/dev/codekata/data-munging/app/src/csv/weather-from-code-kata.csv"
        val csv = service.importCsv(csvPath)

        csv.forEachLine { line: String ->
            val row = line.split(",")
            if (service.isNotFirstAndNotContainsAnyString(row[0], "mo")) {

                val temperatureSpread = row[1].replaceAndToInt() - row[2].replaceAndToInt()

                if (service.isNotFirstOrCurrentSmallerThanSmallestDifference(temperatureSpread)) {
                    service.updateSmallestAndTarget(temperatureSpread, row[0])
                }
            }
            service.incrementIndex()
        }
        return service.target().replace("*", "").toInt()
    }

    private fun String.replaceAndToInt(): Int {
        return this.replace("*", "").toInt()
    }
}
