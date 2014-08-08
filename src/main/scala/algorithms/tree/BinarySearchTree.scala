package algorithms.tree

import scala.collection.mutable.ArrayBuffer

/**
 * Simple binary search tree.
 * @param value of root element
 * @tparam T type of value
  */
class BinarySearchTree[T <% Ordered[T]](val value: T) {

  private var _left: BinarySearchTree[T] = null
  private var _right: BinarySearchTree[T] = null

  def this(list: List[T]) {
    this(list.head)
    list.tail.foreach(insert)
  }

  def insert(value: T) {
    if (value > this.value) {
      if (_right == null) _right = new BinarySearchTree[T](value)
      else _right.insert(value)
    }
    else {
      if (_left == null) _left = new BinarySearchTree[T](value)
      else _left.insert(value)
    }
  }

  def left = _left

  def right = _right

  def preorder(callback: (T) => Unit) {
    callback(value)
    if (_left != null) _left.preorder(callback)
    if (_right != null) _right.preorder(callback)
  }

  def postorder(callback: (T) => Unit) {
    if (_left != null) _left.postorder(callback)
    if (_right != null) _right.postorder(callback)
    callback(value)

  }

  def inorder(callback: (T) => Unit) {
    if (_left != null) _left.inorder(callback)
    callback(value)
    if (_right != null) _right.inorder(callback)
  }

  def sorted() = {
    val arr = new ArrayBuffer[T]()
    inorder(arr.append(_))
    arr
  }

  def contains(value: T): Boolean = {
    if (value == this.value) return true
    if (value > this.value) if (_right == null) false else _right.contains(value)
    else if (_left == null) false else _left.contains(value)
  }

}

