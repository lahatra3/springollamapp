package mg.lahatra3.ollamaapp;

import java.util.Map;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import mg.lahatra3.ollamaapp.beans.OllamaAppRequestBody;
import reactor.core.publisher.Flux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class OllamaAppController {
    
    @Autowired
    private OllamaAppService ollamaAppService;

    @PostMapping("/generate")
    public Map<String, String> generate(@RequestBody() OllamaAppRequestBody ollamaAppRequestBody) {

        return ollamaAppService.generate(
            ollamaAppRequestBody.getMessage()
        );
    }
    
    @PostMapping("/generate-stream")
    public Flux<ChatResponse> getMethodName(@RequestBody OllamaAppRequestBody ollamaAppRequestBody) {

        return ollamaAppService.generateStream(
            ollamaAppRequestBody.getMessage()
        );
    }
    
}
