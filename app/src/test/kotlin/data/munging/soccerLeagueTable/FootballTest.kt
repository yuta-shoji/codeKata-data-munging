package data.munging.soccerLeagueTable

import data.munging.DefaultService
import data.munging.Repository
import org.junit.Test
import kotlin.test.assertEquals


class FootballTest {
    @Test
    fun `得失点差が最も少ないチームを返す`() {
        val repository = Repository()
        val service = DefaultService(repository)
        val soccerLeagueTable = SoccerLeagueTable(service)


        val actualTeam: String = soccerLeagueTable.smallestGoalDifference()


        assertEquals("Aston_Villa", actualTeam)
    }
}
