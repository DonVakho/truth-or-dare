package com.practice.game.states.play

import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.practice.game.states.BaseState
import com.practice.game.states.GameStateManager
import com.badlogic.gdx.scenes.scene2d.ui.TextField
import com.practice.game.states.DataState

class AddPlayerState(gsm: GameStateManager) : BaseState() {

    init {

        skin.getFont("font").data.setScale(3f)
        val nameField = TextField("", skin)
        nameField.setSize((SCREEN_WIDTH / 3) * 2, SCREEN_HEIGHT / 15)
        nameField.setPosition((SCREEN_WIDTH - nameField.width) / 2, SCREEN_HEIGHT / 2)

        stage.addActor(nameField)
        val btnNum = 2f
        val singleBound = SCREEN_WIDTH / (btnNum * 2 + 3)
        val btnH = SCREEN_HEIGHT / 10
        val backBnt = createTxtButton("back",
                skin,
                "maroon",
                singleBound,
                btnH / 2,
                singleBound * 2,
                btnH,
                5.0f)
        backBnt.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                gsm.set(PlayersState(gsm))
            }
        })

        val addBtn = createTxtButton(
                "add",
                skin,
                "default",
                singleBound * 4,
                btnH / 2,
                singleBound * 2,
                btnH,
                5.0f)
        addBtn.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                DataState.addPlayer(nameField.text, skin)
                DataState.playersNames.add(nameField.text)
                gsm.set(PlayersState(gsm))
            }
        })
        stage.addActor(backBnt)
        stage.addActor(addBtn)
    }

    override fun dispose() {

    }
}