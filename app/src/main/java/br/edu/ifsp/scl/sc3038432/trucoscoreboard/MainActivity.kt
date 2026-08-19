package br.edu.ifsp.scl.sc3038432.trucoscoreboard

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.scl.sc3038432.trucoscoreboard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var teamAPoints = 1
    private var teamBPoints = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        with(amb) {

            fun updateScoreDisplay() {
                teamAScoreTv.text = teamAPoints.toString()
                teamBScoreTv.text = teamBPoints.toString()
            }

            listOf(
                // "to" é uma função infixa que cria um Pair de dois valores
                // cada par associa um botão numa lambda que será executada quando for clicado
                teamAPlusOneBt to { teamAPoints ++ }, // = Pair(teamAPlusOneBt, { teamAPoints++ })
                teamBPlusOneBt to { teamBPoints ++ },
                teamAPlusThreeBt to {teamAPoints += 3},
                teamBPlusThreeBt to {teamBPoints += 3}
            ).forEach { (button, action) -> // action é a lambda associada
                button.setOnClickListener {
                    action() // executa a lambda
                    updateScoreDisplay()
                }
            }

            resetBt.setOnClickListener {
                teamAPoints = 0
                teamBPoints = 0
                listOf(
                    teamAPlusOneBt, teamBPlusOneBt, teamAPlusThreeBt, teamBPlusThreeBt
                ).forEach { it.visibility = View.VISIBLE }
            }
        }
    }
}