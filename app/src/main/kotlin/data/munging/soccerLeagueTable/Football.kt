package data.munging.soccerLeagueTable

import data.munging.ImportCsv

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

                val forScore = row[6].toInt()
                val againstScore = row[8].toInt()
                val powAgainstScore = Math.pow((forScore - againstScore).toDouble(), 2.0)
                val goalDifference = Math.sqrt(powAgainstScore).toInt()

                if (index == 1 || smallestGoalDifference > goalDifference) {
                    smallestGoalDifference = goalDifference
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