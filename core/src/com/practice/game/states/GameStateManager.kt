package com.practice.game.states

import com.badlogic.gdx.graphics.g2d.SpriteBatch

import java.util.Stack

class GameStateManager {

    private val states: Stack<IState> = Stack()

    fun push(state: IState) {
        states.push(state)
    }

    fun set(state: IState) {
        states.pop().dispose()
        states.push(state)
    }

    fun render(sb: SpriteBatch) {
        states.peek().render(sb)
    }
}
