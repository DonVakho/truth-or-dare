package com.practice.game.states.play

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.practice.game.states.BaseState
import com.practice.game.states.DataState
import com.practice.game.states.GameStateManager

class CardState(gsm: GameStateManager, choice: String, card: Int) : BaseState() {

    private val card: Sprite = Sprite(Texture("$choice/${card}.png"))

    private val btnNum = 2f

    private val singleBound = SCREEN_WIDTH / (btnNum * 2 + 3)

    init {
        backToPlayerListBtn(gsm)
        val btnH = SCREEN_HEIGHT / 10
        val removeBtn = createTxtButton("keep",
                skin,
                "default",
                singleBound,
                btnH / 2,
                singleBound * 2,
                btnH,
                5.0f)
        removeBtn.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                gsm.set(ChoiceState(gsm))
            }
        })

        val keepBtn = createTxtButton(
                "remove",
                skin,
                "maroon",
                singleBound * 4,
                btnH / 2,
                singleBound * 2,
                btnH,
                5.0f)
        keepBtn.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                if(choice == "dares"){
                    DataState.removeDare(card)
                }else{
                    DataState.removeQuestion(card)
                }
                gsm.set(ChoiceState(gsm))
            }
        })

        stage.addActor(removeBtn)
        stage.addActor(keepBtn)
    }

    override fun render(sb: SpriteBatch) {
        sb.begin()
        sb.draw(card,
                (SCREEN_WIDTH - CARD_WIDTH)/2,
                (SCREEN_HEIGHT - CARD_HEIGHT) / 2,
                CARD_WIDTH,
                CARD_HEIGHT)
        sb.end()
        super.render(sb)
    }

    override fun dispose() {
    }
}