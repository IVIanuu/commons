/*
 * Copyright 2017 Manuel Wrage
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.ivianuu.commons;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Patterns;

/**
 * @author Manuel Wrage (IVIanuu)
 */

public final class StringUtil {

    private StringUtil() {}

    public static boolean isEmail(final @NonNull CharSequence str) {
        return Patterns.EMAIL_ADDRESS.matcher(str).matches();
    }

    public static boolean isEmpty(final @Nullable String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isPresent(final @Nullable String str) {
        return !isEmpty(str);
    }

}
