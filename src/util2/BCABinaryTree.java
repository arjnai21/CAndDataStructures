package util2;

import java.util.Iterator;
import java.util.Stack;

public class BCABinaryTree<E extends Comparable<E>> implements Iterable<E> {
	BCATreeNode<E> root;

	public BCABinaryTree() {

	}

	public boolean insert (E e) {

		if (root == null) {
			root = new BCATreeNode<E>(e);
			return true;
		}

		else {
			BCATreeNode<E> parent = root;
			BCATreeNode<E> current = root;

			while (current != null) {
				int compare = e.compareTo(current.element);
				parent = current;
				if (compare < 0){
					current = current.left;
				}
				else if (compare > 0){
					current = current.right;
				}
				else {
					return false;
				}
			}

			// Attach it to the parent
			if (e.compareTo(parent.element) < 0)
				parent.left = new BCATreeNode<E> (e);
			else
				parent.right = new BCATreeNode<E> (e);

			return true;
		}
	}

	public void printTree() {
		printTree(root, "  ");
	}


	private void printTree(BCATreeNode<E> node, String indent){

		System.out.println(": " + node.element);

		if (node.left!= null) {
			System.out.print(indent);
			System.out.print("L");
			printTree(node.left, indent + "  ");

		}
		if (node.right!=null){
			System.out.print(indent);
			System.out.print("R");
			printTree(node.right, indent + "  ");

		}

	}

	public E getMinimum() {
		BCATreeNode<E> p = root;
		BCATreeNode<E> c = root;

		while (c != null) {
			p = c;
			c = c.left;
		}
		return p.element;
	}

	public E getMaximum() {
		BCATreeNode<E> p = root;
		BCATreeNode<E> c = root;

		while (c != null) {
			p = c;
			c = c.right;
		}
		return p.element;
	}


	public void inorder () {
		inorder (root);
	}

	public void inorder (BCATreeNode<E> e) {
		if (e.left != null)
			inorder (e.left);

		System.out.println(e.element);

		if (e.right != null)
			inorder (e.right);
	}

	public void preorder () {
		preorder (root);
	}

	public void preorder (BCATreeNode<E> e) {
		System.out.println(e.element);

		if (e.left != null)
			preorder (e.left);

		if (e.right != null)
			preorder (e.right);
	}

	public void postorder () {
		postorder (root);
	}

	public void postorder (BCATreeNode<E> e) {
		if (e.left != null)
			postorder (e.left);

		if (e.right != null)
			postorder (e.right);

		System.out.println(e.element);
	}

	@Override
	public Iterator<E> iterator() {
		return new InorderIterator();
	}


	private class InorderIterator implements Iterator<E> {
		private Stack<BCATreeNode<E>> stack = new Stack<>();
		private BCATreeNode<E> current;

		private InorderIterator() {
			current = root;
		}

		public E next() {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}

			current = stack.pop();
			BCATreeNode<E> node = current;
			current = current.right;

			return node.element;
		}

		public boolean hasNext() {
			return !(stack.isEmpty() && current == null);
		}
	}
}
