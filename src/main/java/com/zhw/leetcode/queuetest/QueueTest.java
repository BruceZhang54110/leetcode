package com.zhw.leetcode.queuetest;

public class QueueTest {


    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        System.out.println(queue.isFilled());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

        queue.push(6);
        queue.push(5);
        queue.push(4);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

    }

    static class Queue {
        /**
         * 队列长度（容量）
         */
        private int size;

        /**
         * 数组容器
         */
        private Integer[] queue;

        /**
         * 队尾指针
         */
        private int rear;

        /**
         * 队首指针
         */
        private int front;

        public Queue(int size) {
            this.size = size;
            this.queue = new Integer[size];
            this.front = 0;
            this.rear = 0;
        }

        /**
         * 入队
         * @param element
         */
        boolean push(int element) {
            if (!isFilled()) {
                this.rear = (this.rear + 1) % size;
                this.queue[rear] = element;
                return true;
            }
            return false;
        }

        /**
         * 出队
         */
        Integer pop() {
            if (!isEmpty()) {
                this.front = (front + 1) % this.size;
                return this.queue[front];
            }
            return null;
        }

        /**
         * 判断队空
         * @return
         */
        boolean isEmpty() {
            return this.rear == this.front;
        }

        /**
         * 判断是否队满
         * @return
         */
        boolean isFilled() {
            return (rear + 1) % size == front;
        }
    }
}


