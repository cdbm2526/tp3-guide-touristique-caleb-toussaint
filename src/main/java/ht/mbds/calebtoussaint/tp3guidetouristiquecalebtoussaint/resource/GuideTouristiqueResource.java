package ht.mbds.calebtoussaint.tp3guidetouristiquecalebtoussaint.resource;

import ht.mbds.calebtoussaint.tp3guidetouristiquecalebtoussaint.llm.LlmClientForGuideTouristique;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Ressource REST fournissant un guide touristique (endroits a visiter,
 * prix moyen d'un repas) pour une ville ou un pays donne.
 */
@Path("/guide")
public class GuideTouristiqueResource {

    @Inject
    private LlmClientForGuideTouristique llmClient;

    /**
     * Retourne des informations touristiques pour la ville ou le pays donne.
     *
     * @param villeOuPays le nom de la ville ou du pays sur lequel on veut des informations
     * @return la reponse du LLM au format JSON (endroits a visiter, prix moyen d'un repas)
     */
    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String endroitsDeVisite(@PathParam("ville_ou_pays") String villeOuPays) {
        return llmClient.obtenirInfosTouristiques(villeOuPays);
    }
}