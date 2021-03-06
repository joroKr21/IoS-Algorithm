package assigner.model

import assigner._

/**
 * Configuration data for running an instance of the algorithm.
 * @param iterations     number of iterations without improvement to stop
 * @param startingPoints number of different initial assignments to check
 * @param tabuSize       size of the tabu list / queue
 * @param diverse        should the algorithm optimize diversity or equality?
 */
case class Settings(
    iterations:     Int     = default.iterations,
    initialMoves:   Int     = default.initialMoves,
    startingPoints: Int     = default.startingPoints,
    tabuSize:       Int     = default.tabuSize,
    diverse:        Boolean = default.diverse) {

  /**
   * Validate the configuration.
   * Errors will prevent the algorithm from running.
   * Warnings can be ignored, but are probably faulty input.
   * @return a sequence of any warnings and/or errors in the data
   */
  def validate: Validation = {
    val negIt = maybeErr(iterations <= 0,
      s"Non-positive number of iterations: $iterations")

    val negSp = maybeErr(startingPoints <= 0,
      s"Non-positive number of starting points: $startingPoints")

    val negTs = maybeWarn(tabuSize <= 0,
      s"Tabu list will not be used due to a non-positive size of $tabuSize")

    val tabuIt = maybeWarn(tabuSize >= iterations,
      s"The size of tabu list: $tabuSize > number of iterations: $iterations")

    val negIm = maybeErr(initialMoves < 0,
      s"Negative number of random initial moves: $initialMoves")

    Seq(negIt, negSp, negTs, tabuIt, negIm) reduce { _ merge _ }
  }
}
