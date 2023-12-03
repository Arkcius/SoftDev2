package unit07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unit07.practicum.HeapPQ;
import unit07.practicum.ListPQ;

public class PracticumTest {
    @Test
    public void queue() {
        HeapPQ<Integer> hp = new HeapPQ<>();
        hp.enqueue(8);
        hp.enqueue(7);
        hp.enqueue(6);
        hp.enqueue(9);
        int actual = hp.dequeue();
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public void size() {
        HeapPQ<Integer> hp = new HeapPQ<>();
        hp.enqueue(8);
        hp.enqueue(7);
        hp.enqueue(6);
        hp.enqueue(9);
        int actual = hp.size();
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void Listqueue() {
        ListPQ<Integer> hp = new ListPQ<>();
        hp.enqueue(8);
        hp.enqueue(7);
        hp.enqueue(6);
        hp.enqueue(9);
        int actual = hp.dequeue();
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public void listsize() {
        ListPQ<Integer> hp = new ListPQ<>();
        hp.enqueue(8);
        hp.enqueue(7);
        hp.enqueue(6);
        hp.enqueue(9);
        int actual = hp.size();
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void Listqueue2() {
        ListPQ<Integer> hp = new ListPQ<>();
        hp.enqueue(8);
        hp.enqueue(7);
        hp.enqueue(6);
        hp.enqueue(9);
        hp.dequeue();
        hp.dequeue();
        hp.enqueue(2);
        hp.enqueue(6);
        int actual = hp.dequeue();
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void queue2() {
        HeapPQ<Integer> hp = new HeapPQ<>();
        hp.enqueue(8);
        hp.enqueue(7);
        hp.enqueue(6);
        hp.enqueue(9);
        hp.dequeue();
        hp.dequeue();
        hp.enqueue(2);
        hp.enqueue(6);
        int actual = hp.dequeue();
        int expected = 2;
        assertEquals(expected, actual);
    }
}
