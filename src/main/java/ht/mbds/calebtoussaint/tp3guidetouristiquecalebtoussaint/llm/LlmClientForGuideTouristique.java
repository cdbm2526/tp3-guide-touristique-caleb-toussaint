package ht.mbds.calebtoussaint.tp3guidetouristiquecalebtoussaint.llm;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.Dependent;

import java.io.Serializable;

/**
 * Classe "metier" qui gere l'interface avec l'API du LLM (Gemini), via LangChain4j,
 * pour obtenir des informations touristiques sur une ville ou un pays.
 * Portee CDI "Dependent" : une instance de cette classe est creee et detruite en
 * meme temps que la ressource REST dans laquelle elle est injectee.
 */
@Dependent
public class LlmClientForGuideTouristique implements Serializable {

    /** Le service IA utilise pour interroger le LLM comme guide touristique. */
    private final GuideTouristique guideTouristique;

    /**
     * Recupere la cle secrete et cree le modele et le service IA.
     */
    public LlmClientForGuideTouristique() {
        String cle = System.getenv("GEMINI_KEY");

        ChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(cle)
                .modelName("gemini-2.5-flash")
                .temperature(0.7)
                .build();

        this.guideTouristique = AiServices.builder(GuideTouristique.class)
                .chatModel(model)
                .build();
    }

    /**
     * Envoie une demande d'informations touristiques au LLM et retourne sa reponse.
     *
     * @param villeOuPays le nom de la ville ou du pays
     * @return la reponse du LLM au format JSON
     */
    public String obtenirInfosTouristiques(String villeOuPays) {
        return this.guideTouristique.guide(villeOuPays);
    }
}