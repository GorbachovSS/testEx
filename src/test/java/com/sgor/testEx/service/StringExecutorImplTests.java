package com.sgor.testEx.service;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.assertEquals;

@Test
public class StringExecutorImplTests {

    private final StringExecutorImpl stringExecutor = new StringExecutorImpl();

    @DataProvider
    public Object[][] getTestData() {
        return new Object[][]{
                {null, Optional.empty()},
                {"", Optional.empty()},
                {"aaaacccbb", Optional.of("a4c3b2")},
                {"aaaacccccccccbber", Optional.of("c9a4b2e1r1")},
                {"bbbbbbbbbbbfffffffffeeeeeeeerrrrrrrrrrrrrrrrrrrrrryujkbfd", Optional.of("f9e8r22b11y1u1j1k1b1f1d1")},
                {"abgv", Optional.of("a1b1g1v1")}
        };
    }

    @Test(dataProvider = "getTestData", description = "Тест compressString")
    public void compressStringTest(String testData, Optional<String> check) {

        Optional<String> optional = stringExecutor.compressString(testData);

        assertEquals(optional, check);
    }
}
