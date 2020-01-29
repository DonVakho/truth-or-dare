package com.practice.game.states.play

import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.Window
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.practice.game.states.BaseState
import com.practice.game.states.DataState
import com.practice.game.states.GameStateManager

class PlayersState(gsm: GameStateManager) : BaseState() {

    init {
        backToHomeBtn(gsm)
        val btnNum = 2f
        val singleBound = SCREEN_WIDTH / (btnNum * 2 + 3)
        val btnH = SCREEN_HEIGHT / 10

        val window = Window("Players", skin)
        window.setSize(SCREEN_WIDTH - singleBound * 2, SCREEN_HEIGHT - btnH * 4)
        window.setPosition(singleBound, btnH * 2)

        val playersPane = ScrollPane(DataState.players)
        playersPane.width = window.width
        playersPane.height = window.height
        playersPane.setPosition(singleBound, btnH * 2)

        val table = Table()
        table.add(playersPane).fill().expand()

        window.add(table)
        val startBtn = createTxtButton("start",
                skin,
                "default",
                singleBound,
                btnH / 2,
                singleBound * 2,
                btnH,
                5.0f)
        startBtn.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                gsm.set(ChoiceState(gsm))
            }
        })

        val addBtn = createTxtButton(
                "add",
                skin,
                "maroon",
                singleBound * 4,
                btnH / 2,
                singleBound * 2,
                btnH,
                5.0f)
        addBtn.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                gsm.set(AddPlayerState(gsm))
            }
        })
        stage.addActor(window)
        stage.addActor(startBtn)
        stage.addActor(addBtn)
    }

    override fun dispose() {

    }
}