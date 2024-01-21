package com.sgor.testEx.service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class StringExecutorImpl implements StringExecutor {

    /**
     * Метод рассчитывает количество символов.
     *
     * @param fullString строка для рассчета.
     * @return рассчитанная строка.
     */
    @Override
    public Optional<String> compressString(String fullString) {

        if (Objects.isNull(fullString) || fullString.isEmpty()) return Optional.empty();

        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        char currentChar = fullString.charAt(0);
        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i < fullString.length(); i++) {
            if (fullString.charAt(i) != currentChar) {
                list.add(Character.toString(currentChar) + count);
                count = 1;
                currentChar = fullString.charAt(i);
            } else {
                count++;
            }
        }

        list.add(Character.toString(currentChar) + count);

        list.stream().sorted((x1, x2) -> {
            return Integer.compare(Integer.parseInt(x2.substring(1, x2.length())),
                    Integer.parseInt(x1.substring(1, x1.length())));
        }).forEach(stringBuilder::append);

        return Optional.of(stringBuilder.toString());
    }
}
