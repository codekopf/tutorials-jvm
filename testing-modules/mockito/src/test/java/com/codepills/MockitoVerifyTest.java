package com.codepills;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class MockitoVerifyTest {

    @Mock
    Counter counter;

    @Test
    public void testMockitoVerifyMethodCalls() {

        Account account = new Account(counter);

        // Verification using only() and atLeastOnce()
        account.incrementCounter();
        Mockito.verify(counter, only()).increment();
        Mockito.verify(counter, atLeastOnce()).increment();

        // Verification using times(X)
        for (int i = 0; i < 4; i++) {
            account.incrementCounter();
        }
        Mockito.verify(counter, times(5)).increment();

        // Verification using atLeast(X), atMost(X), never()
        for (int i = 0; i < 5; i++) {
            account.incrementCounter();
        }
        Mockito.verify(counter, atLeast(5)).increment();
        Mockito.verify(counter, atMost(10)).increment();
        Mockito.verify(counter, never()).getCount();
    }

    private class Account {

        private Counter counter;

        public Account(Counter counter) {
            this.counter = counter;
        }

        public void incrementCounter() {
            this.counter.increment();
        }

        public void resetCounter() {
            this.counter.reset();
        }

        public int getCounterValue() {
            return this.counter.getCount();
        }
    }

    private class Counter {

        private int counter;

        public Counter() {
            this.counter = 0;
        }

        public void increment() {
            this.counter++;
        }

        public void reset() {
            this.counter = 0;
        }

        public int getCount() {
            return this.counter;
        }
    }
}
