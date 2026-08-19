package br.edu.ifsp.scl.sc3038432.trucoscoreboard

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.sc3038432.trucoscoreboard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var target = 12
    private var teamAPoints = 0
    private var teamBPoints = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        with(amb) {

            val appButtons = listOf(
                teamAPlusOneBt, teamBPlusOneBt, teamAPlusThreeBt, teamBPlusThreeBt
            )

            fun maoDeOnze() {
                Toast.makeText(
                    this@MainActivity,
                    "Mão de 11: ${if (teamAPoints == 11) "Team A" else "Team B"}",
                    Toast.LENGTH_LONG
                ).show()
                teamAPlusThreeBt.visibility = View.INVISIBLE
                teamBPlusThreeBt.visibility = View.INVISIBLE
            }

            fun winnerWarning() {
                Toast.makeText(
                    this@MainActivity,
                    "The Winner is: ${if (teamAPoints == target) "Team A" else "Team B"}",
                    Toast.LENGTH_LONG
                ).show()
            }

            fun updateScoreDisplay() {
                if (teamAPoints == target || teamBPoints == target) {
                    winnerWarning()
                    appButtons.forEach { it.visibility = View.INVISIBLE }
                }

                if (teamAPoints > target || teamBPoints > target) {
                    Toast.makeText(this@MainActivity, "The Game is over!", Toast.LENGTH_SHORT).show()
                    return
                }

                teamAScoreTv.text = teamAPoints.toString()
                teamBScoreTv.text = teamBPoints.toString()

                if (teamAPoints == 11 || teamBPoints == 11) {
                    maoDeOnze()
                }
            }

            listOf(
                // "to" é uma função infixa que cria um Pair de dois valores
                // cada par associa um botão numa lambda que será executada quando for clicado
                teamAPlusOneBt to { teamAPoints++ }, // = Pair(teamAPlusOneBt, { teamAPoints++ })
                teamBPlusOneBt to { teamBPoints++ },
                teamAPlusThreeBt to { teamAPoints += 3 },
                teamBPlusThreeBt to { teamBPoints += 3 }).forEach { (button, action) -> // action é a lambda associada
                button.setOnClickListener {
                    action() // executa a lambda
                    updateScoreDisplay()
                }
            }

            resetBt.setOnClickListener {
                teamAPoints = 0
                teamBPoints = 0
                updateScoreDisplay()
                appButtons.forEach { it.visibility = View.VISIBLE }
            }
        }
    }
}