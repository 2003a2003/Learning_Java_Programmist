package lesson4.part_05.frame_09;

public class Demo {
    public static void main(String[] args) {
        Stack stack = new Stack();
        //Add object to stack
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        stack.push("Four");
        stack.push("Five");
        stack.push("Six");
        stack.push("Seven");
        stack.push("Eight");
        stack.push("Nine");

        //Print stack
        stack.printList();

        //remove first object
        stack.pop();
        System.out.println();
        stack.printList();
        System.out.println();

        //get first object
        System.out.println(stack.peak());
    }
}
