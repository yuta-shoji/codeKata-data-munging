package data.munging

import java.io.BufferedReader

class DefaultService(private val repository: Repository) {
    fun isNotFirstAndNotContainsAnyString(str: String): Boolean {
        return false
    }

    fun importCsv(path: String): BufferedReader {
        return ImportCsv().importCsvAllLines(path)
    }

    fun isNotFirstIsTrue() {
        repository.isNotFirst = true
    }

    fun incrementIndex() {
        repository.index++
    }
}