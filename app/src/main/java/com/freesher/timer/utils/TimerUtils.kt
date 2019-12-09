package com.freesher.timer.utils

class TimerUtils {
    companion object {
        fun getCorrectTimerString(time: Int): String {
            val minutes = time / 60 as Int
            val seconds = time % 60

            return String.format("%02d:%02d",minutes,seconds)
        }
        fun getSecondsFromString(time:String):Int{
            val values = time.split(":")
            var seconds = 0
            seconds = (values[0] as Int)*60 + (values[1] as Int)
            return seconds
        }
    }
}