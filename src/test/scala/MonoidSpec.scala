import org.scalacheck.Prop.forAll

import org.specs2._

import Monoid._

object MonoidSpec extends Specification with ScalaCheck {
  def is = s2"""
    identity       $identity
    associativity  $associativity
  """

  def identity = forAll { (x: List[Int]) =>
    x +++ Monoid.listMonoid.identity === x
  }

  def associativity = forAll { (x: List[Int], y: List[Int], z: List[Int]) =>
    (x +++ y) +++ z === x +++ (y +++ z)

  }
}
