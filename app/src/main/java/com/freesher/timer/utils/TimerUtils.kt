package com.freesher.timer.utils

class TimerUtils {
    companion object {
        fun getCorrectTimerString(time: Int): String {
            val minutes = time / 60 as Int
            val seconds = time % 60

            return String.format("%02d:%02d",minutes,seconds)
        }

    }
}