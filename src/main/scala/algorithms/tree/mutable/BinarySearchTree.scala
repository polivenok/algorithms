package algorithms.tree.mutable

import scala.collection.mutable.ArrayBuffer

/**
 * Simple binary search tree (mutable).
 * @param value of root element
 * @tparam T type of value
*/
class BinarySearchTree[T <% Ordered[T]](value: T) {

  private var _left: BinarySearchTree[T] = null
  private var _right: BinarySearchTree[T] = null

  def this(list: T*) {
    this(list.head)
    list.tail.foreach(this + _)
  }

  def +(value: T) {
    if (value > this.value) {
      if (_right == null) _right = new BinarySearchTree[T](value)
      else _right + value
    }
    else {
      if (_left == null) _left = new BinarySearchTree[T](value)
      else _left + value
    }
  }

  def left = _left

  def right = _right

  def preOrder(callback: T => Unit) {
    callback(value)
    if (_left != null) _left.preOrder(callback)
    if (_right != null) _right.preOrder(callback)
  }

  def postOrder(callback: T => Unit) {
    if (_left != null) _left.postOrder(callback)
    if (_right != null) _right.postOrder(callback)
    callback(value)

  }

  def inOrder(callback: T => Unit) {
    if (_left != null) _left.inOrder(callback)
    callback(value)
    if (_right != null) _right.inOrder(callback)
  }

  def sorted() = {
    val arr = new ArrayBuffer[T]()
    inOrder(arr.append(_))
    arr
  }

  def contains(value: T): Boolean = {
    if (value == this.value) return true
    if (value > this.value) if (_right == null) false else _right.contains(value)
    else if (_left == null) false else _left.contains(value)
  }

}

