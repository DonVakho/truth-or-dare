package com.practice.game.states

import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import kotlin.random.Random

class DataState {

    companion object {

        var players: Table = Table()

        var playersNames: ArrayList<String> = ArrayList()

        private var prevIndex = -1

        private var dares: ArrayList<Int> = ArrayList()

        private var questions: ArrayList<Int> = ArrayList()

        private var daresNum = 23

        private var questionsNum = 19

        init {
            dares.addAll(1..daresNum)
            questions.addAll(1..questionsNum)
        }

        fun removeDare(value: Int) {
            if (dares.size > 1) {
                dares.remove(value)
                daresNum--
            }
        }

        fun removeQuestion(value: Int) {
            if (questions.size > 1) {
                questions.remove(value)
                questionsNum--
            }
        }

        fun getQuestion(): Int {
            return questions[Random.nextInt(questionsNum)]
        }

        fun getDare(): Int {
            return dares[Random.nextInt(daresNum)]
        }

        fun addPlayer(name: String, skin: Skin) {
            players.add(Label(name, skin))
            players.row()
        }

        fun getPlayer(): String {
            return if (playersNames.size > 0) {
                var index = Random.nextInt(playersNames.size)
                while (playersNames.size > 1 && index == prevIndex) {
                    index = Random.nextInt(playersNames.size)
                }
                prevIndex = index
                playersNames[index]
            } else ""
        }

        fun clear() {
            playersNames.clear()
            players.clear()
            dares.clear()
            questions.clear()
            prevIndex = -1
            daresNum = 23
            questionsNum = 19
            dares.addAll(1..daresNum)
            questions.addAll(1..questionsNum)
        }
    }
}