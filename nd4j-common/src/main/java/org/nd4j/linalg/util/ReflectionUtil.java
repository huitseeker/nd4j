/*-
 *
 *  * Copyright 2015 Skymind,Inc.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *
 *
 */

package org.nd4j.linalg.util;

/**
 * Reflect utilities
 *
 * @author Adam Gibson
 */
public final class ReflectionUtil {

    private ReflectionUtil() {
    }

    /**
     * Create a class array from the given array of objects
     *
     * @param objects the objects to getScalar classes for
     * @return the classes for each object in the array
     */
    public static Class<?>[] classesFor(Object[] objects) {
        Class<?>[] ret = new Class<?>[objects.length];
        for (int i = 0; i < objects.length; i++) {
            ret[i] = objects[i].getClass();
        }
        return ret;
    }


}
