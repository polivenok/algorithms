package algorithms.tree.immutable

import scala.collection.mutable.ArrayBuffer

/*
 * Simple binary search tree (immutable)
 */
abstract sealed class BinarySearchTree[+T <% Ordered[T]] {
  def left: BinarySearchTree[T]

  def right: BinarySearchTree[T]

  def value: T

  def isEmpty: Boolean

  //strange signature due to 'covariant type error'
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

  def sorted[E >: T <% Ordered[E]] = {
    val arr = new ArrayBuffer[E]()
    inOrder(arr.append(_))
    arr
  }

  //can be named as '+'
  def add[E >: T <% Ordered[E]](el: E): BinarySearchTree[E] =
    if (isEmpty) Branch(el, Leaf, Leaf)
    else if (el < value) Branch(value, left add el, right)
    else if (el > value) Branch(value, left, right add el)
    else this

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

