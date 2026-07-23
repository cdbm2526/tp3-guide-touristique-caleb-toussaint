package ht.mbds.calebtoussaint.tp3guidetouristiquecalebtoussaint.llm;

import dev.langchain4j.service.Result;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

/**
 * Service IA qui joue le role d'un guide touristique. Il fournit des
 * informations touristiques (endroits a visiter, prix moyen d'un repas)
 * pour une ville ou un pays donne.
 */
public interface GuideTouristique {

    /**
     * Demande au LLM des informations touristiques sur une ville ou un pays.
     *
     * @param villeOuPays le nom de la ville ou du pays
     * @param nb le nombre d'endroits a visiter souhaite
     * @return le resultat contenant les informations touristiques structurees,
     *         ainsi que les metadonnees (usage de tokens, etc.)
     */
    @SystemMessage("""
            Tu es un guide touristique. Pour la ville ou le pays donne par l'utilisateur, \
            indique les {{nb}} principaux endroits a visiter, ainsi que le prix moyen d'un repas \
            dans la devise du pays.
            """)
    @UserMessage("Le lieu est : {{villeOuPays}}")
    Result<InfosTouristiques> guide(@V("villeOuPays") String villeOuPays, @V("nb") int nb);
}