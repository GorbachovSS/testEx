package com.sgor.testEx.service;

import java.util.Optional;

public interface StringExecutor {

    /**
     * Метод рассчитывает количество символов.
     *
     * @param fullString строка для рассчета.
     * @return рассчитанная строка.
     */
    Optional<String> compressString(String fullString);
}
