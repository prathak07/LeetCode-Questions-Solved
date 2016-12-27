/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/

public class MinStack {
    Stack<Integer> real;
    Stack<Integer> temp;
    /** initialize your data structure here. */
    public MinStack() {
        real = new Stack<>();
        temp = new Stack<>();
    }
    
    public void push(int x) {
        real.push(x);
        if(temp.isEmpty()) {
            temp.push(x);
        }
        else {
            int y = temp.peek();
            if(x<y) {
                temp.push(x);
            }
            else {
                temp.push(y);
            }
        }
    }
    
    public void pop() {
        if(real.isEmpty()) {
            return;
        }
        real.pop();
        temp.pop();
    }
    
    public int top() {
        if(real.isEmpty()) {
            return -1;
        }
        return real.peek();
    }
    
    public int getMin() {
        if(temp.isEmpty()) {
            return -1;
        }
        return temp.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */