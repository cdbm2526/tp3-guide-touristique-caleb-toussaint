package ht.mbds.calebtoussaint.tp3guidetouristiquecalebtoussaint.llm;

import dev.langchain4j.model.output.TokenUsage;

/**
 * DTO (Data Transfer Object) qui reprend les informations de TokenUsage
 * de LangChain4j, pour pouvoir les serialiser facilement en JSON.
 *
 * @param inputTokenCount le nombre de tokens en entree (question + contexte)
 * @param outputTokenCount le nombre de tokens en sortie (reponse du LLM)
 * @param totalTokenCount le nombre total de tokens utilises
 */
public record TokenUsageDto(
        Integer inputTokenCount,
        Integer outputTokenCount,
        Integer totalTokenCount
) {
    /**
     * Cree un TokenUsageDto a partir d'une instance de TokenUsage de LangChain4j.
     *
     * @param tokenUsage l'usage de tokens fourni par LangChain4j
     * @return le DTO correspondant
     */
    public static TokenUsageDto from(TokenUsage tokenUsage) {
        return new TokenUsageDto(
                tokenUsage.inputTokenCount(),
                tokenUsage.outputTokenCount(),
                tokenUsage.totalTokenCount()
        );
    }
}