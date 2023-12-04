package com.algoritmi;

import java.util.Stack;

class SpecialStack {
    private Stack<Integer> mainStack = new Stack<>();   // основной стек для хранения элементов
    private Stack<Integer> minStack = new Stack<>();    // стек для отслеживания минимального элемента

    public void push(int item) {
        mainStack.push(item);

        // Если минимальный стек пустой или новый элемент меньше или равен текущему минимуму,
        // добавляем его в минимальный стек
        if (minStack.isEmpty() || item <= minStack.peek()) {
            minStack.push(item);
        }
    }

    public int pop() {
        if (!mainStack.isEmpty()) {
            int item = mainStack.pop();

            // Если удаленный элемент является текущим минимумом, удаляем его из минимального стека
            if (item == minStack.peek()) {
                minStack.pop();
            }

            return item;
        } else {
            return -1; // или выбросить исключение, в зависимости от требований
        }
    }

    public int getMin() {
        // Возвращаем текущий минимум из минимального стека
        if (!minStack.isEmpty()) {
            return minStack.peek();
        } else {
            return -1; // или выбросить исключение, в зависимости от требований
        }
    }

    public boolean isEmpty() {
        // Возвращаем true, если основной стек пустой, иначе false
        return mainStack.isEmpty();
    }

    public static void main(String[] args) {
        SpecialStack specialStack = new SpecialStack();

        specialStack.push(3);
        specialStack.push(5);
        System.out.println("Минимальный элемент: " + specialStack.getMin());  // Ожидаем: 3

        specialStack.push(2);
        specialStack.push(1);
        System.out.println("Минимальный элемент: " + specialStack.getMin());  // Ожидаем: 1

        specialStack.pop();
        System.out.println("Минимальный элемент: " + specialStack.getMin());  // Ожидаем: 2
    }
}