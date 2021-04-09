/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2021 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package io.undertow.util;

import java.util.Collection;
import java.util.Map;

import io.undertow.UndertowMessages;

/**
 * A set of assertions and checks.
 *
 * @see <a href="https://github.com/wildfly/wildfly-common/blob/master/src/main/java/org/wildfly/common/Assert.java">Based on the work of David M. Lloyd</a>
 *
 */
public final class Assert {

    /**
     * Check that the named parameter is not {@code null}.  Use a standard exception message if it is.
     *
     * @param name the parameter name
     * @param value the parameter value
     * @param <T> the value type
     * @return the value that was passed in
     * @throws IllegalArgumentException if the value is {@code null}
     */
    public static <T> T checkNotNullParam(String name, T value) throws IllegalArgumentException {
        checkNotNullParamChecked("name", name);
        checkNotNullParamChecked(name, value);
        return value;
    }

    /**
     * Check that the named parameter is not {@code null}, using a {@code NullPointerException} as some specifications
     * require.  Use a standard exception message if it is.
     *
     * @param name the parameter name
     * @param value the parameter value
     * @param <T> the value type
     * @return the value that was passed in
     * @throws NullPointerException if the value is {@code null}
     */
    public static <T> T checkNotNullParamWithNullPointerException(String name, T value) throws NullPointerException {
        checkNotNullParamChecked("name", name);
        if (value == null) throw UndertowMessages.MESSAGES.argumentCannotBeNullNPE(name);
        return value;
    }

    private static <T> void checkNotNullParamChecked(final String name, final T value) {
        if (value == null) throw UndertowMessages.MESSAGES.argumentCannotBeNull(name);
    }

    /**
     * Check that a value within the named array parameter is not {@code null}.  Use a standard exception message if it
     * is.
     *
     * @param name the parameter name
     * @param index the array index
     * @param value the array element value
     * @param <T> the element value type
     * @return the array element value that was passed in
     * @throws IllegalArgumentException if the value is {@code null}
     */
    public static <T> T checkNotNullArrayParam(String name, int index, T value) throws IllegalArgumentException {
        checkNotNullParamChecked("name", name);
        if (value == null) throw UndertowMessages.MESSAGES.nullArrayParam(index, name);
        return value;
    }

    /**
     * Check that the named parameter is not empty.  Use a standard exception message if it is.
     *
     * @param name the parameter name
     * @param value the parameter value
     * @return the value that was passed in
     * @throws IllegalArgumentException if the value is empty
     */
    public static String checkNotEmptyParam(String name, String value) {
        checkNotNullParamChecked("name", name);
        checkNotNullParamChecked("value", value);
        if (value.isEmpty()) throw UndertowMessages.MESSAGES.emptyParam(name);
        return value;
    }
    /**
     * Check that the named parameter is not empty.  Use a standard exception message if it is.
     *
     * @param name the parameter name
     * @param value the parameter value
     * @return the value that was passed in
     * @throws IllegalArgumentException if the value is empty
     */
    public static CharSequence checkNotEmptyParam(String name, CharSequence value) {
        checkNotNullParamChecked("name", name);
        checkNotNullParamChecked("value", value);
        if (value.length() == 0) throw UndertowMessages.MESSAGES.emptyParam(name);
        return value;
    }

    /**
     * Check that the named parameter is not empty.  Use a standard exception message if it is.
     *
     * @param name the parameter name
     * @param value the parameter value
     * @return the value that was passed in
     * @throws IllegalArgumentException if the value is empty
     */
    public static <E, T extends Collection<E>> T checkNotEmptyParam(String name, T value) {
        checkNotNullParamChecked("name", name);
        checkNotNullParamChecked("value", value);
        if (value.isEmpty()) throw UndertowMessages.MESSAGES.emptyParam(name);
        return value;
    }

    /**
     * Check that the named parameter is not empty.  Use a standard exception message if it is.
     *
     * @param name the parameter name
     * @param value the parameter value
     * @return the value that was passed in
     * @throws IllegalArgumentException if the value is empty
     */
    public static <K, V, T extends Map<K, V>> T checkNotEmptyParam(String name, T value) {
        checkNotNullParamChecked("name", name);
        checkNotNullParamChecked("value", value);
        if (value.isEmpty()) throw UndertowMessages.MESSAGES.emptyParam(name);
        return value;
    }

    /**
     * Check that the named parameter is not empty.  Use a standard exception message if it is.
     *
     * @param name the parameter name
     * @param value the parameter value
     * @return the value that was passed in
     * @throws IllegalArgumentException if the value is empty
     */
    public static <T> T[] checkNotEmptyParam(String name, T[] value) {
        checkNotNullParamChecked("name", name);
        checkNotNullParamChecked("value", value);
        if (value.length == 0) throw UndertowMessages.MESSAGES.emptyParam(name);
        return value;
    }

    /**
     * Check that the named parameter is not empty.  Use a standard exception message if it is.
     *
     * @param name the parameter name
     * @param value the parameter value
     * @return the value that was passed in
     * @throws IllegalArgumentException if the value is empty
     */
    public static boolean[] checkNotEmptyParam(String name, boolean[] value) {
        checkNotNullParamChecked("name", name);
        checkNotNullParamChecked("value", value);
        if (value.length == 0) throw UndertowMessages.MESSAGES.emptyParam(name);
        return value;
    }

    /**
     * Check that the named parameter is not empty.  Use a standard exception message if it is.
     *
     * @param name the parameter name
     * @param value the parameter value
     * @return the value that was passed in
     * @throws IllegalArgumentException if the value is empty
     */
    public static byte[] checkNotEmptyParam(String name, byte[] value) {
        checkNotNullParamChecked("name", name);
        checkNotNullParamChecked("value", value);
        if (value.length == 0) throw UndertowMessages.MESSAGES.emptyParam(name);
        return value;
    }

    /**
     * Check that the named parameter is not empty.  Use a standard exception message if it is.
     *
     * @param name the parameter name
     * @param value the parameter value
     * @return the value that was passed in
     * @throws IllegalArgumentException if the value is empty
     */
    public static short[] checkNotEmptyParam(String name, short[] value) {
        checkNotNullParamChecked("name", name);
        checkNotNullParamChecked("value", value);
        if (value.length == 0) throw UndertowMessages.MESSAGES.emptyParam(name);
        return value;
    }

    /**
     * Check that the named parameter is not empty.  Use a standard exception message if it is.
     *
     * @param name the parameter name
     * @param value the parameter value
     * @return the value that was passed in
     * @throws IllegalArgumentException if the value is empty
     */
    public static int[] checkNotEmptyParam(String name, int[] value) {
        checkNotNullParamChecked("name", name);
        checkNotNullParamChecked("value", value);
        if (value.length == 0) throw UndertowMessages.MESSAGES.emptyParam(name);
        return value;
    }

    /**
     * Check that the named parameter is not empty.  Use a standard exception message if it is.
     *
     * @param name the parameter name
     * @param value the parameter value
     * @return the value that was passed in
     * @throws IllegalArgumentException if the value is empty
     */
    public static long[] checkNotEmptyParam(String name, long[] value) {
        checkNotNullParamChecked("name", name);
        checkNotNullParamChecked("value", value);
        if (value.length == 0) throw UndertowMessages.MESSAGES.emptyParam(name);
        return value;
    }

    /**
     * Check that the named parameter is not empty.  Use a standard exception message if it is.
     *
     * @param name the parameter name
     * @param value the parameter value
     * @return the value that was passed in
     * @throws IllegalArgumentException if the value is empty
     */
    public static float[] checkNotEmptyParam(String name, float[] value) {
        checkNotNullParamChecked("name", name);
        checkNotNullParamChecked("value", value);
        if (value.length == 0) throw UndertowMessages.MESSAGES.emptyParam(name);
        return value;
    }

    /**
     * Check that the named parameter is not empty.  Use a standard exception message if it is.
     *
     * @param name the parameter name
     * @param value the parameter value
     * @return the value that was passed in
     * @throws IllegalArgumentException if the value is empty
     */
    public static double[] checkNotEmptyParam(String name, double[] value) {
        checkNotNullParamChecked("name", name);
        checkNotNullParamChecked("value", value);
        if (value.length == 0) throw UndertowMessages.MESSAGES.emptyParam(name);
        return value;
    }

    private Assert() {
        throw new IllegalStateException("No instance");
    }

}
