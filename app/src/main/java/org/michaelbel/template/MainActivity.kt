package org.michaelbel.template

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commitNow
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.template.movie.ui.MovieFragment

@AndroidEntryPoint
class MainActivity: AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.commitNow {
                replace(R.id.container, MovieFragment.newInstance())
            }
        }
    }
}