/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package data.munging.soccerLeagueTable

import org.junit.Test
import kotlin.test.assertEquals


class FootballTest {
    @Test
    fun `得失点差が最も少ないチームを返す`() {
        val soccerLeagueTable = SoccerLeagueTable()


        val actualTeam: String = soccerLeagueTable.smallestGoalDifference()


        assertEquals("Aston_Villa", actualTeam)
    }
}