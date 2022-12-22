package data.munging.weather

import junit.framework.TestCase.assertEquals
import org.junit.Test

class WeatherTest {
    @Test
    fun `import csv and return days with the smallest temperature spread`() {
        val weather = Weather()


        val actualSmallestTemperatureSpread: Int = weather.smallestTemperatureSpread()


        assertEquals(14, actualSmallestTemperatureSpread)
    }

}