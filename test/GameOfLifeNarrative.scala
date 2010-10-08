package net.pawel

import collection.mutable.ListBuffer
import org.junit.Assert._
import org.hamcrest.CoreMatchers

trait GameOfLifeNarrative extends Ordering.IntOrdering {

  implicit def aliveToHasCell(state: CellState) = new {
    def cell(resultState: CellState) = new Me(state, resultState)
  }

  class Me(state: CellState, expectedResult: CellState) {
    self =>
    val numbers = new ListBuffer[Int]
    var function: ((Int, Int) => Boolean) = null

    def string(param: String) = self
    def when = string _
    def to = string _

    def are(function: (Int, Int) => Boolean) = {
      self.function = function
      self
    }

    def are(neighbours: Int) = {
      self.function = equiv
      numbers += neighbours
      self
    }

    def is(function: (Int, Int) => Boolean) = are(function)

    def or(neighbours: Int) = are(neighbours: Int)  

    def than(number: Int) = {
      numbers ++= ((0 to 8) filter(function(_, number)))
      self
    }

    def neighbours {
      numbers.toList.foreach(neighbours => assertThat(state + " with " + neighbours + " neighbours should become " + expectedResult,
        state.mutate(neighbours), CoreMatchers.is(expectedResult)))
    }
  }

  type Compare = ((Int, Int) => Boolean)
  val fewer: Compare = lt
  val more: Compare = gt

  val dies = Dead
  val lives = Alive
  val springs = Alive
  val are, there, life = ""
}