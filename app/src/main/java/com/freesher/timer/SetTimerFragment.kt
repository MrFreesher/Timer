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
    var time = 0
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
        timeTextView.text = TimerUtils.getCorrectTimerString(time)
        Log.e("MyActivity",TimerUtils.getCorrectTimerString(time))
        startBtn.setOnClickListener {
            val action = SetTimerFragmentDirections.actionSetTimerFragmentToTimerFragment()
            action.time = time
            findNavController(this).navigate(action)
        }
        plusOneMinBtn.setOnClickListener {
            if((time+60)<3600 && time<3600) {
              increaseTime(60)
            }
        }
        minusOneMinBtn.setOnClickListener{
            if((time-60)>-1){
                decreaseTime(60)
            }
        }
        plusSecondsBtn.setOnClickListener{
            if((time+60)<3600 || time<3600) {
              increaseTime(15)
            }
        }
        minutSecondsBtn.setOnClickListener {
            if((time-15)>-1){
                decreaseTime(15)
            }
        }

    }
    fun decreaseTime(value:Int){
        time-=value
        timeTextView.text = TimerUtils.getCorrectTimerString(time)
    }
    fun increaseTime(value:Int){
        time+=value
        timeTextView.text = TimerUtils.getCorrectTimerString(time)
    }

}
