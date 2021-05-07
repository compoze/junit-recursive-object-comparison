package com.junit.objectequality.hello;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class HelloObjectTest {

    @Test
    public void areObjectsEqual(){
        final HelloObject helloObjectOne = new HelloObject("name", "description");
        final HelloObject helloObjectTwo = new HelloObject("name", "description");

        /**
         * The below will fail the object equality based on the memory address comparison. The error will look
         * something like below:
         *
         * org.opentest4j.AssertionFailedError:
         * Expected :com.junit.objectequality.hello.HelloObject@6302bbb1
         * Actual   :com.junit.objectequality.hello.HelloObject@31304f14
         */

        assertEquals(helloObjectOne, helloObjectTwo);
    }

    @Test
    public void areObjectsEqualUsingRecursiveComparison(){
        final HelloObject helloObjectOne = new HelloObject("name", "description");
        final HelloObject helloObjectTwo = new HelloObject("name", "description");

        /**
         * This will pass object equality based on recursive comparison
         */
        assertThat(helloObjectOne).usingRecursiveComparison().isEqualTo(helloObjectTwo);
    }

    @Test
    public void objectsAreNotEqualUsingRecursiveComparison(){
        final HelloObject helloObjectOne = new HelloObject("name", "description");
        final HelloObject helloObjectTwo = new HelloObject("differentName", "description");

        /**
         * This will failed object equality based on recursive comparison. The error will look something
         * like below:
         *
         * java.lang.AssertionError:
         * Expecting:
         *   <com.junit.objectequality.hello.HelloObject@740773a3>
         * to be equal to:
         *   <com.junit.objectequality.hello.HelloObject@37f1104d>
         * when recursively comparing field by field, but found the following difference:
         *
         * field/property 'name' differ:
         * - actual value   : "name"
         * - expected value : "differentName"
         */
        assertThat(helloObjectOne).usingRecursiveComparison().isEqualTo(helloObjectTwo);
    }


}