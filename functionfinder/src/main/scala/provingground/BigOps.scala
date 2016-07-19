package provingground
import provingground.HoTT._
import ScalaRep._
import IntTypes._
import EnumType._
import ListType._
import scala.reflect.runtime.universe.{Try => UnivTry, Function => FunctionUniv, _}

object BigOps {

  val A = "A" :: Type // a type symbol

  val f = "f" :: A ->: N

  val en = "enumeration" :: EnumTyp(A)

  val BigSum = {
    lambda(A)(
        lambda(en)(
            lambda(f)({
              val enlist = enumlist(A)(en)
              val lst = lmap(A)(N)(f)(enlist)
              foldLeft(N)(N)(lst)(N.sum)
            })
        )
    )
  }
}
