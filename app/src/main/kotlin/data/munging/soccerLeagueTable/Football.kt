package data.munging.soccerLeagueTable

import data.munging.DefaultService
import kotlin.math.abs

class SoccerLeagueTable(private val service: DefaultService) {
    fun smallestGoalDifference(): String {
        val csvPath = "/Users/yutashoji/dev/codekata/data-munging/app/src/csv/football.csv"
        val csv = service.importCsv(csvPath)

        csv.forEachLine { line: String ->
            val row = line.split(",")
            if (service.isNotFirstAndNotContainsAnyString(row[0], "-")) {

                val positiveGoalDifference = abs(row[6].toInt() - row[8].toInt())

                if (service.isNotFirstOrCurrentSmallerThanSmallestDifference(positiveGoalDifference)) {
                    service.updateSmallestAndTarget(positiveGoalDifference, row[1].replace(" ", ""))
                }
            }
            service.incrementIndex()
        }
        return service.target()
    }
}