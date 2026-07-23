package ht.mbds.calebtoussaint.tp3guidetouristiquecalebtoussaint.llm;

import java.util.List;

/**
 * Represente les informations touristiques renvoyees par le LLM pour
 * une ville ou un pays donne.
 *
 * @param villeOuPays le nom de la ville ou du pays
 * @param endroitsAVisiter la liste des endroits a visiter
 * @param prixMoyenRepas le prix moyen d'un repas, avec la devise
 */
public record InfosTouristiques(
        String villeOuPays,
        List<String> endroitsAVisiter,
        String prixMoyenRepas
) {
}