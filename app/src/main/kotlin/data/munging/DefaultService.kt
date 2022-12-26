package data.munging

import java.io.BufferedReader

class DefaultService(private val repository: Repository) {
    fun isNotFirstAndNotContainsAnyString(row: String, str: String): Boolean {
        return repository.index >= 1 && !row.contains(str)
    }

    fun importCsv(path: String): BufferedReader {
        return ImportCsv().importCsvAllLines(path)
    }

    fun incrementIndex() {
        repository.index++
    }

    fun isNotFirstOrCurrentSmallerThanSmallestDifference(current: Int): Boolean {
        return repository.index == 1 || repository.smallestDifference > current
    }

    fun updateSmallestAndTarget(smallestDifference: Int, newTarget: String) {
        repository.smallestDifference = smallestDifference
        repository.target =  newTarget
    }

    fun target(): String{
        return repository.target
    }
}