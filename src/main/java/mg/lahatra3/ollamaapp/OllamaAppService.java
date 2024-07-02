package mg.lahatra3.ollamaapp;

import java.util.Map;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class OllamaAppService {

    @Autowired
    private OllamaChatModel ollamaChatModel;


    public Map<String, String> generate(String message) {

        return Map.of("content", ollamaChatModel.call(message));
    }

    public Flux<ChatResponse> generateStream(String message) {
        
        Prompt prompt = new Prompt(message);
        return ollamaChatModel.stream(prompt); 
    }
}
