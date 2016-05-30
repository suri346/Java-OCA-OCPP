package eu.chargetime.ocpp.model.test;

import eu.chargetime.ocpp.PropertyConstraintException;
import eu.chargetime.ocpp.model.ResetRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * ChargeTime.eu - Java-OCA-OCPP
 * <p>
 * MIT License
 * <p>
 * Copyright (C) 2016 Thomas Volden <tv@chargetime.eu>
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public class ResetRequestTest {
    ResetRequest request;

    @Before
    public void setUp() throws Exception {
        request = new ResetRequest();
    }

    @Test
    public void setType_illegalString_throwsPropertyConstraintException() {
        // Given
        String illegal = "some type";

        try {
            // When
            request.setType(illegal);

            Assert.fail("Expected PropertyConstraintException");
        } catch (PropertyConstraintException ex) {
            assertThat(ex.getFieldKey(), equalTo("type"));
            assertThat(ex.getFieldValue(), equalTo(illegal));
        }
    }

    @Test
    public void setType_hard_typeIsSet() throws Exception {
        // Given
        String resetType = "Hard";

        // When
        request.setType(resetType);

        // Then
        assertThat(request.getType(), equalTo(resetType));
    }

    @Test
    public void setType_soft_typeIsSet() throws Exception {
        // Given
        String resetType = "Soft";

        // When
        request.setType(resetType);

        // Then
        assertThat(request.getType(), equalTo(resetType));
    }

    @Test
    public void validate_returnFalse() {
        // When
        boolean isValid = request.validate();

        // Then
        assertThat(isValid, is(false));
    }

    @Test
    public void validate_typeIsSet_returnTrue() throws Exception {
        // Given
        request.setType("Hard");

        // When
        boolean isValid = request.validate();

        // Then
        assertThat(isValid, is(true));
    }
}