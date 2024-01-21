package com.sgor.testEx.controller;

import com.sgor.testEx.dto.CompressBody;
import com.sgor.testEx.service.StringExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/string")
public class StringController {

    private static final int MAX_LENGTH_STRING = 2000;
    private static final int CLIENT_ERROR = 400;

    private final StringExecutor stringExecutor;

    public StringController(StringExecutor stringExecutor) {
        this.stringExecutor = stringExecutor;
    }

    /**
     * Ендпоинт для рассчета повторяющихся символов в строке.
     *
     * @param body CompressBody содержащий строку для рассчета в виде
     *             {
     *             "stringCompress": "aaaabbc"
     *             }
     * @return результат расчета в виде "a4b2c1"
     */
    @PostMapping("/compress")
    public ResponseEntity<String> compress(@RequestBody CompressBody body) {

        if (Objects.isNull(body.getStringCompress()) || body.getStringCompress().isEmpty()) {
            return ResponseEntity.status(CLIENT_ERROR).body("Укажите валидную строку!");
        }

        if (body.getStringCompress().length() > MAX_LENGTH_STRING)
            return ResponseEntity.status(CLIENT_ERROR).body("Укажите строку меньшей длинны!");

        return ResponseEntity
                .ofNullable(stringExecutor.compressString(body.getStringCompress())
                        .orElse("В процессе обработки возникла ошибка!"));
    }
}
