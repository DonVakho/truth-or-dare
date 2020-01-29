package com.practice.game.states.play

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.GlyphLayout
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.practice.game.states.BaseState
import com.practice.game.states.DataState
import com.practice.game.states.GameStateManager

class ChoiceState(gsm: GameStateManager) : BaseState() {

    private val font: BitmapFont = BitmapFont()

    private val playerLabel = GlyphLayout()

    init {
        backToPlayerListBtn(gsm)
        font.color = Color.BLACK
        font.data.setScale(4f)
        playerLabel.setText(font, DataState.getPlayer())
        val btnNum = 2f
        val singleBound = SCREEN_WIDTH / (btnNum * 2 + 13)
        val btnH = SCREEN_HEIGHT / 3
        val truthBtn = createTxtButton("TRUTH",
                skin,
                "default",
                singleBound,
                (btnH / 2),
                singleBound * 7,
                btnH,
                5.0f)
        truthBtn.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                gsm.set(CardState(gsm, "questions", DataState.getQuestion()))
            }
        })

        val dareBtn = createTxtButton(
                "DARE",
                skin,
                "maroon",
                singleBound * 9,
                (btnH / 2),
                singleBound * 7,
                btnH,
                5.0f)
        dareBtn.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                gsm.set(CardState(gsm, "dares", DataState.getDare()))
            }
        })

        stage.addActor(truthBtn)
        stage.addActor(dareBtn)
    }

    override fun dispose() {
    }

    override fun render(sb: SpriteBatch) {
        sb.begin()
        font.draw(sb, playerLabel, (SCREEN_WIDTH - playerLabel.width) / 2, (SCREEN_HEIGHT / 3) * 2)
        sb.end()
        super.render(sb)
    }
}