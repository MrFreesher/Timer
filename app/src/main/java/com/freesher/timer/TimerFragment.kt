package com.freesher.timer


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.freesher.timer.utils.TimerUtils
import kotlinx.android.synthetic.main.fragment_timer.*

/**
 * A simple [Fragment] subclass.
 */
class TimerFragment : Fragment() {
    val TimerFragmentArgs by navArgs<TimerFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_timer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Countdown timer"
        val time  = TimerFragmentArgs.time
        //timeTextView.setText()

    }


}
