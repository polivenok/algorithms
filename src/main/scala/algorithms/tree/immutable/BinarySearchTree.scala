package algorithms.tree.immutable

/*
 * Simple binary search tree (immutable)
 */
abstract sealed class BinarySearchTree[+T <% Ordered[T]] {
  def left: BinarySearchTree[T]

  def right: BinarySearchTree[T]

  def value: T

  def isEmpty: Boolean

  //strange signature is due to 'covariant type error'
  def contains[E >: T <% Ordered[E]](el: E): Boolean = {
    def traverse(node: BinarySearchTree[E], x: Option[E]): Boolean = {
      if (node.isEmpty) x.contains(el)
      else if (el < node.value) traverse(node.left, x)
      else traverse(node.right, Some(node.value))
    }
    traverse(this, None)
  }

  def inOrder[E >: T <% Ordered[E]](callback: E => Unit) {
    if (!isEmpty) {
      left.inOrder(callback)
      callback(value)
      right.inOrder(callback)
    }
  }

  def sorted: List[T] = {
    def traverse(t: BinarySearchTree[T], l: List[T]): List[T] =
      if (t.isEmpty) l
      else traverse(t.left, t.value :: traverse(t.right, l))
    traverse(this, Nil)
  }


  //can be named as '+'
  def add[E >: T <% Ordered[E]](el: E): BinarySearchTree[E] =
    if (isEmpty) Branch(el, Leaf, Leaf)
    else if (el < value) Branch(value, left add el, right)
    else if (el > value) Branch(value, left, right add el)
    else this

  def min: T = {
    def findMin(tree: BinarySearchTree[T], min: T): T =
      if (tree.isEmpty) min
      else findMin(tree.left, tree.value)
    if (isEmpty) throw new NoSuchElementException("Tree is empty")
    else findMin(left, value)
  }

  //can be named as '-'
  def remove[E >: T <% Ordered[E]](el: E): BinarySearchTree[E] =
    if(isEmpty) throw new NoSuchElementException("Tree is empty")
    else if (el < value) Branch(value, left.remove(el), right)
    else if (el > value) Branch(value, left, right.remove(el))
    else {
      if (left.isEmpty && right.isEmpty) Leaf
      else if (left.isEmpty) right
      else if (right.isEmpty) left
      else {
        val successor = right.min
        Branch(successor, left, right.remove(successor))
      }
    }
}

case object Leaf extends BinarySearchTree[Nothing] {
  override def left: BinarySearchTree[Nothing] = null

  override def value: Nothing = throw new NoSuchElementException("Tree is empty")

  override def right: BinarySearchTree[Nothing] = null

  override def isEmpty: Boolean = true
}

case class Branch[T <% Ordered[T]](value: T, left: BinarySearchTree[T], right: BinarySearchTree[T]) extends BinarySearchTree[T] {
  override def isEmpty: Boolean = false
}

object BinarySearchTree {
  def apply[T <% Ordered[T]](xs: T*): BinarySearchTree[T] = {
    var root: BinarySearchTree[T] = Leaf
    for (x <- xs) root = root add x
    root
  }
}

