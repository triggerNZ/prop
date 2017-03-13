

trait Monoid[T] {
  def append(a: T, b: T): T
  def identity: T
}

object Monoid {
  implicit def listMonoid[T]: Monoid[List[T]] = new Monoid[List[T]] {
    def identity = List[T]()
    def append(a: List[T], b: List[T]) = a ++ b
  }

  implicit val stringMonoid: Monoid[String] = new Monoid[String] {
    def identity = ""
    def append(a: String, b: String) = a ++ b
  }

  implicit class MonoidSyntax[T : Monoid](m: T) {
    def +++(other: T) = implicitly[Monoid[T]].append(m, other)
  }
}
