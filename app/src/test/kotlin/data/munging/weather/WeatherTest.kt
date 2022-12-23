package data.munging.weather

import data.munging.DefaultService
import data.munging.Repository
import junit.framework.TestCase.assertEquals
import org.junit.Test

class WeatherTest {
    @Test
    fun `import csv and return days with the smallest temperature spread`() {
        val repository = Repository()
        val service = DefaultService(repository)
        val weather = Weather(service)


        val actualSmallestTemperatureSpread: Int = weather.smallestTemperatureSpread()


        assertEquals(14, actualSmallestTemperatureSpread)
    }

}