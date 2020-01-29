package com.practice.game.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.viewport.ScreenViewport
import com.practice.game.states.play.CardState
import com.practice.game.states.play.PlayersState
import com.practice.game.states.play.StartPageState

abstract class BaseState : IState {

    protected val SCREEN_WIDTH = Gdx.graphics.width.toFloat()

    protected val SCREEN_HEIGHT = Gdx.graphics.height.toFloat()

    protected val CARD_WIDTH = SCREEN_WIDTH * 0.9f

    protected val CARD_HEIGHT = CARD_WIDTH / 1.49937888f

    protected val stage: Stage = Stage(ScreenViewport())

    protected val skin = Skin(Gdx.files.internal("gdxSkins/orange/skin/uiskin.json"))

    init {
        Gdx.input.inputProcessor = stage
    }

    protected fun createTxtButton(name: String, skin: Skin, style: String, x: Float, y: Float, width: Float, height: Float, scale: Float): TextButton {
        val btn = TextButton(name, skin, style)
        btn.setSize(width, height)
        btn.setPosition(x, y)
        btn.label.setFontScale(scale)
        return btn
    }

    protected fun backToHomeBtn(gsm: GameStateManager) {
        val btn = TextButton("home", skin)
        btn.setSize(SCREEN_WIDTH / 8, SCREEN_WIDTH/8)
        btn.setPosition(SCREEN_WIDTH/15, SCREEN_HEIGHT - (btn.height + SCREEN_HEIGHT / 30))
        btn.label.setFontScale(2f)
        btn.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                gsm.set(StartPageState(gsm))
            }
        })
        stage.addActor(btn)
    }

    protected fun backToPlayerListBtn(gsm: GameStateManager) {
        val btn = TextButton("back", skin)
        btn.setSize(SCREEN_WIDTH / 8, SCREEN_WIDTH/8)
        btn.setPosition(SCREEN_WIDTH/15, SCREEN_HEIGHT - (btn.height + SCREEN_HEIGHT / 30))
        btn.label.setFontScale(2f)
        btn.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                gsm.set(PlayersState(gsm))
            }
        })
        stage.addActor(btn)
    }


    override fun render(sb: SpriteBatch) {
        stage.act()
        stage.draw()
    }

}