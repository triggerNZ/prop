import org.scalacheck._
import Arbitrary._
import Prop.forAll

import org.specs2._


object ListMonoidSpec extends MonoidLaws[List[Int]] {
  def monoid = implicitly[Monoid[List[Int]]]
  def arb = implicitly[Arbitrary[List[Int]]]
}

object StringMonoidSpec extends MonoidLaws[String] {
  def monoid = implicitly[Monoid[String]]
  def arb = implicitly[Arbitrary[String]]
}

trait MonoidLaws[M] extends Specification with ScalaCheck {
  implicit def monoid: Monoid[M]
  implicit def arb: Arbitrary[M]

  def is = s2"""
    identity       $identity
    associativity  $associativity
  """

  def identity = forAll { (x: M) =>
    monoid.append(x, monoid.identity) === x
  }

  def associativity = forAll { (x: M, y: M, z: M) =>
    monoid.append(monoid.append(x, y), z) === monoid.append(x, monoid.append(y,  z))
  }
}
