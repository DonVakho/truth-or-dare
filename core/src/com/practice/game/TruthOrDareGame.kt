package com.practice.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.practice.game.states.DataState
import com.practice.game.states.GameStateManager
import com.practice.game.states.play.StartPageState

class TruthOrDareGame : ApplicationAdapter() {

    private val gsm: GameStateManager = GameStateManager()

    private var batch: SpriteBatch?= null

    override fun create() {
        batch = SpriteBatch()
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f)
        gsm.push(StartPageState(gsm))
    }
    override fun render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        gsm.render(batch!!)
    }

    override fun dispose() {
        super.dispose()
        batch?.dispose()
    }


}
