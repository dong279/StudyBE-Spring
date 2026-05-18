package kr.jongyeol.springstudy.study.week2;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/week2/text")
public class Week2Controller {
    private final TextTransformService textTransformService;

    public Week2Controller(TextTransformService textTransformService) {
        this.textTransformService = textTransformService;
    }

    @ExceptionHandler({MissingServletRequestParameterException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<String> handleInvalidRequest() {
        return ResponseEntity.badRequest().body("request is invalid");
    }

    @GetMapping("/upper")
    public ResponseEntity<String> upper(@RequestParam String text) {
        if (text.isBlank()) {
            return ResponseEntity.badRequest().body("text must not be blank");
        }
        return ResponseEntity.ok(textTransformService.upper(text));
    }

    @GetMapping("/lower")
    public ResponseEntity<String> lower(@RequestParam String text) {
        if (text.isBlank()) {
            return ResponseEntity.badRequest().body("text must not be blank");
        }
        return ResponseEntity.ok(textTransformService.lower(text));
    }

    @GetMapping("/reverse")
    public ResponseEntity<String> reverse(@RequestParam String text) {
        if (text.isBlank()) {
            return ResponseEntity.badRequest().body("text must not be blank");
        }
        return ResponseEntity.ok(textTransformService.reverse(text));
    }

    @GetMapping("/length")
    public ResponseEntity<String> length(@RequestParam String text) {
        if (text.isBlank()) {
            return ResponseEntity.badRequest().body("text must not be blank");
        }
        return ResponseEntity.ok(String.valueOf(textTransformService.length(text)));
    }

    @PostMapping("/replace")
    public ResponseEntity<String> replace(@RequestBody ReplaceRequest request) {
        if (request.text().isBlank()) {
            return ResponseEntity.badRequest().body("text must not be blank");
        }
        if (request.from() == null || request.from().isBlank()) {
            return ResponseEntity.badRequest().body("from must not be blank");
        }
        return ResponseEntity.ok(textTransformService.replace(request));
    }

    @PostMapping("/word-count")
    public ResponseEntity<String> wordCount(@RequestBody TextRequest request) {
        if (request.text().isBlank()) {
            return ResponseEntity.badRequest().body("text must not be blank");
        }
        return ResponseEntity.ok(String.valueOf(textTransformService.wordCount(request.text())));
    }

    @PostMapping("/trim")
    public ResponseEntity<String> trim(@RequestBody TextRequest request) {
        if (request.text().isBlank()) {
            return ResponseEntity.badRequest().body("text must not be blank");
        }
        return ResponseEntity.ok(textTransformService.trim(request.text()));
    }

    @PostMapping("/mask")
    public ResponseEntity<String> mask(@RequestBody TextRequest request) {
        if (request.text().isBlank()) {
            return ResponseEntity.badRequest().body("text must not be blank");
        }
        return ResponseEntity.ok(textTransformService.mask(request.text()));
    }

    @PostMapping("/repeat")
    public ResponseEntity<String> repeat(@RequestBody RepeatRequest request) {
        if (request.text().isBlank()) {
            return ResponseEntity.badRequest().body("text must not be blank");
        }
        if (request.times() < 1 || request.times() > 10) {
            return ResponseEntity.badRequest().body("times must be between 1 and 10");
        }
        return ResponseEntity.ok(textTransformService.repeat(request));
    }

    @PostMapping("/palindrome")
    public ResponseEntity<String> palindrome(@RequestBody TextRequest request) {
        if (request.text().isBlank()) {
            return ResponseEntity.badRequest().body("text must not be blank");
        }
        return ResponseEntity.ok(String.valueOf(textTransformService.palindrome(request.text())));
    }
}
