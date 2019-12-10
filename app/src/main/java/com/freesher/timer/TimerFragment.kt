package com.freesher.timer


import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.freesher.timer.utils.TimerUtils
import kotlinx.android.synthetic.main.fragment_timer.*

/**
 * A simple [Fragment] subclass.
 */
class TimerFragment : Fragment() {
    val TimerFragmentArgs by navArgs<TimerFragmentArgs>()
    var time:Int = 0
    lateinit var timer:CountDownTimer
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
        time  = TimerFragmentArgs.time
        timeTextView.setText(TimerUtils.getCorrectTimerString(time))
        timer = object : CountDownTimer(time*1000L,1000){
            override fun onFinish() {
                time-=1
                timeTextView.text = TimerUtils.getCorrectTimerString(time)
                message.text = "Finish"
            }

            override fun onTick(millisUntilFinished: Long) {
                time-=1
                timeTextView.text = TimerUtils.getCorrectTimerString(time)
            }

        }
        stopBtn.visibility = View.GONE
        pauseBtn.visibility = View.GONE
        startBtn.setOnClickListener {
            timer.start()
            stopBtn.visibility = View.VISIBLE
            pauseBtn.visibility = View.VISIBLE
            startBtn.visibility = View.GONE
        }
        pauseBtn.setOnClickListener {
            timer.cancel()
            startBtn.visibility = View.VISIBLE
            pauseBtn.visibility = View.GONE
        }
        stopBtn.setOnClickListener {
            time = 0
            timeTextView.text = TimerUtils.getCorrectTimerString(time)
            timer.onFinish()
            timer.cancel()
            startBtn.visibility = View.GONE
            pauseBtn.visibility = View.GONE
        }

    }


}
