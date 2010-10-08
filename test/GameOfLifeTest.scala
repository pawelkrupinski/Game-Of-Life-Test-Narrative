package net.pawel

import org.junit.Test

class GameOfLifeTest extends GameOfLifeNarrative {

  @Test
  def Life_Test {
    Alive cell dies when there are more than 3 neighbours

    Alive cell dies when there are fewer than 2 neighbours

    Alive cell lives when there are 2 or 3 neighbours

    Dead cell springs to life when there are 3 neighbours
  }
}