package com.freesher.timer


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.freesher.timer.utils.TimerUtils
import kotlinx.android.synthetic.main.fragment_set_timer.*

/**
 * A simple [Fragment] subclass.
 */
class SetTimerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_set_timer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Setup timer"
        timeTextView.setText(TimerUtils.getCorrectTimerString(320))
        Log.e("MyActivity",TimerUtils.getCorrectTimerString(320))
        startBtn.setOnClickListener {
            val action = SetTimerFragmentDirections.actionSetTimerFragmentToTimerFragment()
            action.time = 2000
            findNavController(this).navigate(action)
        }
    }


}
