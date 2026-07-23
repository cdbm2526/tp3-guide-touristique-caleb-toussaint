package ht.mbds.calebtoussaint.tp3guidetouristiquecalebtoussaint.llm;

import dev.langchain4j.service.SystemMessage;

/**
 * Service IA qui joue le role d'un guide touristique. Il fournit des
 * informations touristiques (endroits a visiter, prix moyen d'un repas)
 * pour une ville ou un pays donne, au format JSON.
 */
public interface GuideTouristique {

    /**
     * Demande au LLM des informations touristiques sur une ville ou un pays.
     *
     * @param villeOuPays le nom de la ville ou du pays
     * @return la reponse du LLM au format JSON
     */
    @SystemMessage("""
            Tu es un guide touristique. Pour la ville ou le pays donne par l'utilisateur, \
            indique les 2 principaux endroits a visiter, ainsi que le prix moyen d'un repas \
            dans la devise du pays. Reponds uniquement avec du JSON, exactement dans ce format, \
            sans aucun texte supplementaire et sans utiliser Markdown :
            {
              "ville_ou_pays": "nom de la ville ou du pays",
              "endroits_a_visiter": ["endroit 1", "endroit 2"],
              "prix_moyen_repas": "<prix> <devise du pays>"
            }
            """)
    String guide(String villeOuPays);
}