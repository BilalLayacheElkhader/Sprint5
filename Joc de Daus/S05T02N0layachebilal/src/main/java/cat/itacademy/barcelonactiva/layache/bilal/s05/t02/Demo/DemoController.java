package cat.itacademy.barcelonactiva.layache.bilal.s05.t02.Demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DemoController {
    public String welcome() {
        return "Welcome form secure endpoint";
    }
}

