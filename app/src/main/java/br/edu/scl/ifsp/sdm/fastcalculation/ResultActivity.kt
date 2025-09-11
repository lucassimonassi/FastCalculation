package br.edu.scl.ifsp.sdm.fastcalculation

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import br.edu.scl.ifsp.sdm.fastcalculation.databinding.ActivityResultBinding
import br.edu.scl.ifsp.sdm.fastcalculation.Extras.EXTRA_POINTS
import br.edu.scl.ifsp.sdm.fastcalculation.Extras.EXTRA_SETTINGS

class ResultActivity : AppCompatActivity() {

    private val binding: ActivityResultBinding by lazy {
        ActivityResultBinding.inflate(layoutInflater)
    }

    private lateinit var settings: Settings

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val points = intent.getFloatExtra(EXTRA_POINTS, 0f)
        settings = intent.getParcelableExtra<Settings>(EXTRA_SETTINGS) ?: Settings()

        val formattedPoints = "%.1f".format(points)
        binding.resultTv.text = "Nota: $formattedPoints"

        binding.restartBt.setOnClickListener {
            val gameIntent = Intent(this, GameActivity::class.java)
            gameIntent.putExtra(EXTRA_SETTINGS, settings)
            startActivity(gameIntent)
            finish()
        }
    }
}