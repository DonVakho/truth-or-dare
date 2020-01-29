package com.practice.game.states.play

import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.practice.game.states.BaseState
import com.practice.game.states.DataState
import com.practice.game.states.GameStateManager

class StartPageState(gsm: GameStateManager) : BaseState() {

    init {
        DataState.clear()
        val btnNum = 2f
        val singleBound = SCREEN_HEIGHT / (btnNum * 2 + 3)
        val btnW = SCREEN_WIDTH / 2
        val exitBtn = createTxtButton("exit",
                skin,
                "maroon",
                (SCREEN_WIDTH - btnW) / 2,
                singleBound * 2,
                btnW,
                singleBound,
                5.0f)
        exitBtn.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                //Exit game
            }
        })

        val playBtn = createTxtButton(
                "play",
                skin,
                "default",
                (SCREEN_WIDTH - btnW) / 2,
                singleBound * 4,
                btnW,
                singleBound,
                5.0f)
        playBtn.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                println("setting playersstate")
                gsm.set(PlayersState(gsm))
            }
        })

        stage.addActor(exitBtn)
        stage.addActor(playBtn)

    }

    override fun dispose() {
    }
}
