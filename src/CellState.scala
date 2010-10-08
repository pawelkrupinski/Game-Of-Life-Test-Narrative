package net.pawel

trait CellState {
  def mutate(neighbours: Int): CellState;
}

case object Alive extends CellState {
  override def mutate(neighbours: Int) = if (neighbours < 2 || neighbours > 3) Dead else Alive
}

case object Dead extends CellState {
  override def mutate(neighbours: Int) = if (neighbours == 3) Alive else Dead
}