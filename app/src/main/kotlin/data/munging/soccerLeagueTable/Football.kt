package data.munging.soccerLeagueTable

import data.munging.ImportCsv
import kotlin.math.abs

class SoccerLeagueTable {
    fun smallestGoalDifference(): String {
        val csvPath = "/Users/yutashoji/dev/codekata/data-munging/app/src/csv/football.csv"
        val csv = ImportCsv().importCsvAllLines(csvPath)

        var isNotFirst = false
        var targetTeam = ""
        var smallestGoalDifference = 0
        var index = 0

        csv.forEachLine { line: String ->
            val row = line.split(",")
            if (isNotFirst && row[0].contains("-").not()) {

                val positiveGoalDifference = abs(row[6].toInt() - row[8].toInt())

                if (index == 1 || smallestGoalDifference > positiveGoalDifference) {
                    smallestGoalDifference = positiveGoalDifference
                    targetTeam = row[1].replace(" ", "")
                }
            } else {
                isNotFirst = true
            }
            index++
        }
        return targetTeam
    }
}