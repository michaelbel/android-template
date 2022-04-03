package org.michaelbel.template.app.samples.lemonade

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.google.android.material.snackbar.Snackbar
import org.michaelbel.template.R

class LemonadeActivity: ComponentActivity() {

    /**
     * Anything labeled var instead of val is expected to be changed in the functions but DO NOT
     * alter their initial values declared here, this could cause the app to not function properly.
     */
    // Default the state to select
    private var lemonadeState = "select"
    // Default lemonSize to -1
    private var lemonSize = -1
    // Default the squeezeCount to -1
    private var squeezeCount = -1

    private var lemonTree = LemonTree()
    private var lemonImage: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lemonade)

        if (savedInstanceState != null) {
            lemonadeState = savedInstanceState.getString(LEMONADE_STATE, "select")
            lemonSize = savedInstanceState.getInt(LEMON_SIZE, -1)
            squeezeCount = savedInstanceState.getInt(SQUEEZE_COUNT, -1)
        }

        lemonImage = findViewById(R.id.image_lemon_state)
        setViewElements()
        lemonImage?.setOnClickListener {
            clickLemonImage()
        }
        lemonImage?.setOnLongClickListener {
            showSnackbar()
        }
    }

    /**
     * This method saves the state of the app if it is put in the background.
     */
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(LEMONADE_STATE, lemonadeState)
        outState.putInt(LEMON_SIZE, lemonSize)
        outState.putInt(SQUEEZE_COUNT, squeezeCount)
        super.onSaveInstanceState(outState)
    }

    /**
     * Clicking will elicit a different response depending on the state.
     * This method determines the state and proceeds with the correct action.
     */
    private fun clickLemonImage() {
        when (lemonadeState) {
            SELECT -> {
                lemonadeState = SQUEEZE
                lemonSize = lemonTree.pick()
                squeezeCount = 0
            }
            SQUEEZE -> {
                squeezeCount++
                lemonSize--
                if(lemonSize == 0) {
                    lemonadeState = DRINK
                    lemonSize = -1
                }
            }
            DRINK -> lemonadeState = RESTART
            RESTART -> lemonadeState = SELECT
        }
        setViewElements()

    }

    /**
     * Set up the view elements according to the state.
     */
    private fun setViewElements() {
        val textAction: TextView = findViewById(R.id.text_action)
        when (lemonadeState) {
            SELECT -> {
                lemonImage?.setImageResource(R.drawable.lemon_tree)
                textAction.setText(R.string.lemon_select)
            }
            SQUEEZE -> {
                lemonImage?.setImageResource(R.drawable.lemon_squeeze)
                textAction.setText(R.string.lemon_squeeze)
            }
            DRINK -> {
                lemonImage?.setImageResource(R.drawable.lemon_drink)
                textAction.setText(R.string.lemon_drink)
            }
            RESTART -> {
                lemonImage?.setImageResource(R.drawable.lemon_restart)
                textAction.setText(R.string.lemon_empty_glass)
            }
        }
    }

    /**
     * Long clicking the lemon image will show how many times the lemon has been squeezed.
     */
    private fun showSnackbar(): Boolean {
        if (lemonadeState != SQUEEZE) {
            return false
        }
        val squeezeText = getString(R.string.squeeze_count, squeezeCount)
        Snackbar.make(
            findViewById(R.id.constraint_Layout),
            squeezeText,
            Snackbar.LENGTH_SHORT
        ).show()
        return true
    }
}

/**
 * A Lemon tree class with a method to "pick" a lemon. The "size" of the lemon is randomized
 * and determines how many times a lemon needs to be squeezed before you get lemonade.
 */
class LemonTree {
    fun pick(): Int {
        return (2..4).random()
    }
}

private const val LEMONADE_STATE = "LEMONADE_STATE"
private const val LEMON_SIZE = "LEMON_SIZE"
private const val SQUEEZE_COUNT = "SQUEEZE_COUNT"
// SELECT represents the "pick lemon" state
private const val SELECT = "select"
// SQUEEZE represents the "squeeze lemon" state
private const val SQUEEZE = "squeeze"
// DRINK represents the "drink lemonade" state
private const val DRINK = "drink"
// RESTART represents the state where the lemonade has be drunk and the glass is empty
private const val RESTART = "restart"