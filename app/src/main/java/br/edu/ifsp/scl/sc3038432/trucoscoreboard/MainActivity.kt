package br.edu.ifsp.scl.sc3038432.trucoscoreboard

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.scl.sc3038432.trucoscoreboard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var team_a_points = 1
    private var team_b_points = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        with(amb) {

            fun updatePoints() {
                teamAScoreTv.text = team_a_points.toString()
                teamBScoreTv.text = team_b_points.toString()
            }

            resetBt.setOnClickListener {
                team_a_points = 0
                team_b_points = 0
                listOf(
                    teamAPlusOneBt, teamBPlusOneBt, teamAPlusThreeBt, teamBPlusThreeBt
                ).forEach { it.visibility = View.VISIBLE }
            }
        }
    }
}