package smartbox.components;

import smartbox.*;

public class Stack extends Component implements IStack{

	private java.util.Stack<Double> stack;
	
	public Stack() {
		super();
		stack = new java.util.Stack<Double>();
	}

	public java.util.Stack<Double> getStack() {
		return stack;
	}

	public void setStack(java.util.Stack<Double> stack) {
		this.stack = stack;
	}

	@Override
	public void push(Double num) {
		stack.push(num);
	}

	@Override
	public void pop() {
		stack.pop();
	}

	@Override
	public Double top() {
		return stack.peek();
	}

	@Override
	public void clear() {
		stack.clear();
	}

	@Override
	public Boolean isEmpty() {
		return stack.isEmpty();
	}

	// ???
}