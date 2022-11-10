package data.munging

import org.junit.Test
import kotlin.test.assertEquals

class WeatherTest {
    @Test
    fun `import csv and return days with the smallest temperature spread`() {
        val weather = Weather()


        val actualSmallestTemperatureSpread: Int = weather.getSmallestTemperatureSpread()


        assertEquals(14, actualSmallestTemperatureSpread)
    }

}