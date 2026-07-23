package ht.mbds.calebtoussaint.tp3guidetouristiquecalebtoussaint.llm;

import java.util.List;

/**
 * Represente les informations touristiques renvoyees par le LLM, avec en
 * plus les metadonnees d'usage de tokens (pour calculer un cout, par exemple).
 *
 * @param villeOuPays le nom de la ville ou du pays
 * @param endroitsAVisiter la liste des endroits a visiter
 * @param prixMoyenRepas le prix moyen d'un repas, avec la devise
 * @param usage les informations d'usage de tokens pour cette requete
 */
public record InfosTouristiquesAvecUsage(
        String villeOuPays,
        List<String> endroitsAVisiter,
        String prixMoyenRepas,
        TokenUsageDto usage
) {
    /**
     * Cree une instance a partir des infos touristiques et de l'usage de tokens.
     *
     * @param infos les informations touristiques renvoyees par le LLM
     * @param usage les informations d'usage de tokens
     * @return l'instance combinee
     */
    public static InfosTouristiquesAvecUsage from(InfosTouristiques infos, TokenUsageDto usage) {
        return new InfosTouristiquesAvecUsage(
                infos.villeOuPays(),
                infos.endroitsAVisiter(),
                infos.prixMoyenRepas(),
                usage
        );
    }
}