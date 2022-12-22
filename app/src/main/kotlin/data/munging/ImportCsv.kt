package data.munging

import java.io.BufferedReader
import java.io.FileInputStream
import java.io.InputStreamReader

class ImportCsv {
    fun importCsvAllLines(path: String): BufferedReader {
        return BufferedReader(
            InputStreamReader(
                FileInputStream(path)
            )
        )
    }
}